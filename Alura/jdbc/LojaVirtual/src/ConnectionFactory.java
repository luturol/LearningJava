import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
    private final String jdbcUrl = "jdbc:mysql://localhost:3306/loja_virtual";
    private final String user = "root";
    private final String password = "mynewpassword";

    public DataSource dataSource;

    public ConnectionFactory(){
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl(jdbcUrl);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);

        this.dataSource = comboPooledDataSource;
    }
    public Connection Create() throws SQLException {
        return this.dataSource.getConnection();
    }
}
