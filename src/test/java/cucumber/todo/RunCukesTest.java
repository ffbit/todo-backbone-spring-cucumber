package cucumber.todo;

import cucumber.api.junit.Cucumber;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class RunCukesTest {

    private static Server server = new Server();
    private static Connector connector = new SelectChannelConnector();

    @BeforeClass
    public static void setUp() throws Exception {
        connector.setPort(0);
        server.addConnector(connector);
        server.start();
    }

    public static int getLocalPort() {
        return connector.getLocalPort();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        server.stop();
    }

}
