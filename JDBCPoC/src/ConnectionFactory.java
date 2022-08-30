import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public String jdbcUrl = "jdbc:postgresql://localhost/%s?user=%s&password=%s";
    public String user = "java";
    public String password = "java";
    public String database = "postgres";

    public Connection Create() throws SQLException {
        //https://jdbc.postgresql.org/documentation/80/connect.html
        String jdbcUrlFormated = String.format(jdbcUrl, database, user, password);

        return DriverManager.getConnection(jdbcUrlFormated);
    }

}
