package cucumber.todo.hook;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JettyRunner {
    private static Logger log = LoggerFactory.getLogger(JettyRunner.class);

    private final String tags = "@web";

    private static Server server;
    private static Connector connector;

    @Before(tags)
    public void setUpJetty() throws Exception {
        setUpServer();
    }

    private static void setUpServer() throws Exception {
        setUpConnector();
        server = new Server();
        server.addConnector(connector);

        server.setHandler(new WebAppContext("src/main/webapp", "/"));
        server.start();

        log.info("Base URL: {}", getBaseUrl());
    }

    private static void setUpConnector() {
        connector = new SelectChannelConnector();
        connector.setPort(0);
    }

    public static String getBaseUrl() {
        return String.format("http://localhost:%d/", connector.getLocalPort());
    }

    @After(tags)
    public void tearDownJetty() throws Exception {
        server.stop();
    }

}
