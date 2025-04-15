package DAL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInit {
    public static void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS leituras ("
                   + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                   + "umidade TEXT, "
                   + "temperatura TEXT, "
                   + "precipitacao TEXT, "
                   + "data_hora TEXT)";

        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada/verificada com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
