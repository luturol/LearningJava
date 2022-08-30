import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

    public static void main(String[] args) throws SQLException {
        Connection connection = new ConnectionFactory().Create();

        var stm = connection.createStatement();

        stm.execute("INSERT INTO PRODUTO(nome, descricao) VALUES(\"Mouse Logitech sem fio\", \"Mouse Logitech sem fio com bateria a pilha\");",
                Statement.RETURN_GENERATED_KEYS);

        ResultSet rst = stm.getGeneratedKeys();

        while (rst.next())
        {
            Integer id = rst.getInt(1);
            System.out.println("Id criado foi " + id);
        }
        connection.close();
    }
}
