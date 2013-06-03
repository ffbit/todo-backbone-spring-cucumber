package cucumber.todo.hook;

import cucumber.api.java.Before;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.operation.DatabaseOperation;

public class DbUnitHook {


    @Before
    public void setUpDbUnit() {
//        JdbcDatabaseTester databaseTester =
//                new JdbcDatabaseTester("org.h2.Driver", "jdbc:h2:tcp://localhost:9092/todos", "sa", "");
//        databaseTester.setTearDownOperation(DatabaseOperation.DELETE_ALL);
    }

}
