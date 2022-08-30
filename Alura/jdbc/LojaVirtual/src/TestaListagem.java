import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaListagem {
    public static void main(String[] args) throws SQLException {

        Connection connection = new ConnectionFactory().Create();
        // CREATE TABLE PRODUTO (id INT AUTO_INCREMENT, nome VARCHAR(50) NOT NULL, descricao VARCHAR(255), PRIMARY KEY (id)) Engine = InnoDB;
        System.out.println("Fechando a conexao");


        var stm = connection.prepareStatement("SELECT id, nome, descricao FROM PRODUTO;");

//        stm.execute("INSERT INTO PRODUTO(nome, descricao) VALUES (\"Cerveja Skoll\", \"Cervaj Skoll que desce redondo\");");
        var result = stm.executeQuery();

        while(result.next())
        {
            Integer id = result.getInt("id");
            System.out.println(id);

            String nome = result.getString("nome");
            System.out.println(nome);
        }

//        stm.execute("CREATE TABLE PRODUTO (id INT AUTO_INCREMENT, nome VARCHAR(50) NOT NULL, descricao VARCHAR(255), PRIMARY KEY (id)) Engine = InnoDB;");

        connection.close();
    }
}
