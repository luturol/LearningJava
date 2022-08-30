import java.sql.Connection;
import java.sql.SQLException;

public class TesteRemocao {
    public static void main(String[] args) throws SQLException {
        Connection connection = new ConnectionFactory().Create();

        var stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");

        stm.setInt(1, 2);
        stm.execute();

        var modifiedRows = stm.getUpdateCount();
        System.out.println("Quantidade de linhas modificadas " + modifiedRows);
    }
}
