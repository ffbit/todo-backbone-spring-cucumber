package cucumber.todo.hook;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CleanDb {
    private String driverClass = "org.apache.derby.jdbc.EmbeddedDriver";
    private String connectionUrl = "jdbc:derby://localhost:1527/todos;create=true";
    private String username = "sa";
    private String password = "sa";

    private Connection connection;

    @Before
    public void setUp() throws Exception {
        registerDriver();
        initConnection();

        executeUpdate("TRUNCATE TABLE SA.TODOS");
    }

    private void registerDriver() throws Exception {
        Class.forName(driverClass).newInstance();
    }

    private void initConnection() throws Exception {
        connection = DriverManager
                .getConnection(String.format("%s;username=%s;password=%s",
                        connectionUrl, username, password));
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
