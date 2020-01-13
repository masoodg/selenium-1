package common;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base extends TestReporter {

    protected WebDriver driver;

    @Before
    public void setUp() {
        Properties appProperties = new PropertyLoader("application.properties").load();
        // Read desired browser from system properties e.g "mvn test -Dbrowser=chrome"
        String desiredBrowser = System.getProperty("browser");
        Browser browserName = Browser.valueOf(desiredBrowser.toUpperCase()); //TODO: Handle if the given desiredBrowser is not supported
        driver = BrowserFactory.getBrowser(browserName);

        // Read driver time out from application.properties file
        int timeout = Integer.parseInt(appProperties.getProperty("driver.timeout")); // TODO: A better solution to handle exception is possible
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);


    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
