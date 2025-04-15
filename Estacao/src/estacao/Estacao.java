package estacao;

import DAL.DatabaseInit;
import DAL.SerialDAO;
import apresentacao.frmPrincipal;
import modelo.Serial;

public class Estacao
{
    public static void main(String[] args)
    {
        DatabaseInit.criarTabela();
        new Thread(new Serial()).start();
        
        frmPrincipal frmP = new frmPrincipal(null, true);
        frmP.setVisible(true);
    }
}
