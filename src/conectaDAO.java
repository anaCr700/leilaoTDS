
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conectaDAO {

    private Connection conexao;
    public Connection getConexao() {
        return conexao;
    }

    public void conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/uc11", "root","1xwç00.lv24!#");
            System.out.println("SUCESSO DE CONEXÂO!");
        } catch (ClassNotFoundException e) {
            System.out.println("Falha ao carregar a classe de conexão. Classe não encontrada!");
        } catch (SQLException e) {
            System.out.println("Falha ao conectar com o banco. Erro de SQL.");
        }
    }

    public void desconectar() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
                System.out.println("DESCONECTADO COM SUCESSO!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao desconectar");
        }
    }
}
