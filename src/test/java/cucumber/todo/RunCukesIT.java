package cucumber.todo;

import cucumber.api.junit.Cucumber;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(Cucumber.class)
public class RunCukesIT {
    private static Logger log = LoggerFactory.getLogger(RunCukesIT.class);

    private static Server server;
    private static Connector connector;
    private static WebDriver webDriver;

    @BeforeClass
    public static void setUpClass() throws Exception {
        setUpServer();
        setUpWebDriver();
    }

    @Before
    public void setUp() throws Exception {
        setUpWebDriver();
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

    private static void setUpWebDriver() {
        webDriver = new FirefoxDriver();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        getWebDriver().close();
        server.stop();
    }

    public static int getLocalPort() {
        return connector.getLocalPort();
    }

    public static String getBaseUrl() {
        return String.format("http://localhost:%d/", getLocalPort());
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

}
