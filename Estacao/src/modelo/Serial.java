package modelo;

import DAL.SerialDAO;
import com.fazecast.jSerialComm.*;
import java.io.IOException;
import java.io.InputStream;

public class Serial implements Runnable {

    private final SerialDAO serialDAO = new SerialDAO(); 

    @Override
    public void run() {
        executar();
    }

    public void executar() {
        String leitura = "";
        String[] valores;
        SerialPort comPort = SerialPort.getCommPort("COM5");
        comPort.openPort();
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
        InputStream in = comPort.getInputStream();
        
        try {
            while (Estaticos.coletaSerial) {
                int byteLido = in.read();
                if (byteLido == -1) continue; 

                leitura += (char) byteLido;

                if (leitura.endsWith("\n")) { 
                    leitura = leitura.trim(); 
                    valores = leitura.split(",");
                    
                    if (valores.length == 3) { 
                        System.out.println(valores[0] + " - " + valores[1] + " - " + valores[2]);
                        Estaticos.umidade = valores[0];
                        Estaticos.temperatura = valores[1];
                        Estaticos.precipitacao = valores[2];

                        serialDAO.inserirLeitura(valores[0], valores[1], valores[2]);
                        
                    } else {
                        System.err.println("Erro ao processar leitura: " + leitura);
                    }
                    
                    leitura = ""; 
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            comPort.closePort();
        }
    }
}
