package ua.training.model.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * JdbcConnection
 * <p>
 * Description: Class that use properties {@link ua.training.model.jdbc.DbProperties} for connection to MySQL
 * <p>
 * Created: 09.04.2018
 * <p>
 * Updated:
 *
 * @author Zakusylo Pavlo
 */
public class JdbcConnection {
    private static DbProperties props = new DbProperties();
    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(props.getUrl(), props.getUser(), props.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private JdbcConnection() throws SQLException {
    }

    public static Connection getInstance() {
        return connection;
    }

    public static void closeInstance() {
        props = null;
        connection = null;
    }
}
