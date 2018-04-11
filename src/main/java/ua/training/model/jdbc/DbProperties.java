package ua.training.model.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * DbProperties
 * <p>
 * Description: Class that get properties from {@link resource#db.properties}
 * <p>
 * Created: 09.04.2018
 * <p>
 * Updated:
 *
 * @author Zakusylo Pavlo
 */
public class DbProperties {
    private static String URL;
    private static String USER;
    private static String PASSWORD;

    public DbProperties() {
        Properties props;

        try (InputStream is = getClass().getClassLoader().getResourceAsStream("db.properties");) {

            props = new Properties();
            props.load(is);

        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }

        URL = props.getProperty("db.url");
        USER = props.getProperty("db.user");
        PASSWORD = props.getProperty("db.password");
    }

    public String getUrl() {
        return URL;
    }

    public String getUser() {
        return USER;
    }

    public String getPassword() {
        return PASSWORD;
    }
}
