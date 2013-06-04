package cucumber.todo.hook;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import static org.aeonbits.owner.Config.Sources;

public class CleanDb {
    private Connection connection;

    @Sources("classpath:jdbc.properties")
    private interface JdbcConfig extends Config {
        @Key("database.driver")
        String getDriverClass();

        @Key("database.url")
        String getConnectionUrl();

        @Key("database.user")
        String getUsername();

        @Key("database.password")
        String getPassword();
    }

    @Before
    public void setUp() throws Exception {
        registerDriver();
        initConnection();

        executeUpdate("TRUNCATE TABLE SA.TODOS");
    }

    private void registerDriver() throws Exception {

    }

    private void initConnection() throws Exception {
        JdbcConfig cfg = ConfigFactory.create(JdbcConfig.class);

        Class.forName(cfg.getDriverClass()).newInstance();
        connection = DriverManager
                .getConnection(String.format("%s;username=%s;password=%s",
                        cfg.getConnectionUrl(), cfg.getUsername(), cfg.getPassword()));
    }

    private void executeUpdate(String sql) throws Exception {
        PreparedStatement statement = connection.prepareStatement(sql);

        try {
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            statement.close();
        }
    }

    @After
    public void tearDown() throws Exception {
        connection.close();
    }

}
