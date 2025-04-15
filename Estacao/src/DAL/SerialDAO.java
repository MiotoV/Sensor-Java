package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Leituras;

public class SerialDAO {
    public void inserirLeitura(String umidade, String temperatura, String precipitacao) {
        String sql = "INSERT INTO leituras (umidade, temperatura, precipitacao, data_hora) VALUES (?, ?, ?, ?)";
        
        String dataHoraAtual = java.time.LocalDateTime.now()
                             .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        try (Connection conn = Conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, umidade);
            pstmt.setString(2, temperatura);
            pstmt.setString(3, precipitacao);
            pstmt.setString(4, dataHoraAtual);
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
     public List<Leituras> listarLeituras() {
    List<Leituras> lista = new ArrayList<>();
    String sql = "SELECT umidade, temperatura, precipitacao, data_hora FROM leituras ORDER BY data_hora DESC";

    try (Connection conn = Conexao.conectar();
         PreparedStatement pstmt = conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery()) {

        while (rs.next()) {
            Leituras leitura = new Leituras(
                rs.getString("umidade"),
                rs.getString("temperatura"),
                rs.getString("precipitacao"),
                rs.getString("data_hora")
            );
            lista.add(leitura);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
    }
}
