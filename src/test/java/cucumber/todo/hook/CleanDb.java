package cucumber.todo.hook;

import cucumber.api.java.Before;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CleanDb {
    private String driverClass = "org.apache.derby.jdbc.ClientDriver";
    private String connectionUrl = "jdbc:derby://localhost:1527/todos;create=true";
    private String username = "sa";
    private String password = "sa";

    @Before
    public void setUpDbUnit() throws Exception {
        Class.forName(driverClass).newInstance();
        Connection connection = DriverManager
                .getConnection(String.format("%s;username=%s;password=%s",
                        connectionUrl, username, password));

        PreparedStatement statement = connection
                .prepareStatement("TRUNCATE TABLE SA.TODOS");

        statement.execute();

        statement.close();
        connection.close();
    }

}
