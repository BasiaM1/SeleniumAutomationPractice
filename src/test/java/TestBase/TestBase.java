package TestBase;

import configuration.BrowserEnvironment;
import configuration.EnvironmentProperty;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.HomePage;

import java.util.concurrent.TimeUnit;


public class TestBase {
    protected static WebDriver driver;
    public HomePage homePage;
    //driver będzie wykorzystywany w teście dlatego nie może być prywatny
    private static Logger logger = LoggerFactory.getLogger("TestBase.class");
    private static BrowserEnvironment browserEnvironment;
    public static EnvironmentProperty environmentProperty;

    @BeforeEach
    public void setUp() {
        environmentProperty = EnvironmentProperty.getInstance();//instancja singletona
        browserEnvironment = new BrowserEnvironment();
        driver = browserEnvironment.getDriver();
        logger.debug("Driver initialized");
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);//konf globalna
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
//        logger.debug("implicit wait set for 15 sec");
        homePage = new HomePage(driver);
        logger.debug("create object homePage");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        logger.debug("Driver closed");
    }
}
