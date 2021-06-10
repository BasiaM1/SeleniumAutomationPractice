package TestBase;

import configuration.BrowserEnvironment;
import configuration.EnvironmentProperty;
import configuration.PropertyStore;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

import static java.lang.System.getProperty;

public class TestBase {
    protected static WebDriver driver;
    public HomePage homePage;
    //driver będzie wykorzystywany w teście dlatego nie może być prywatny
    private static Logger logger = LoggerFactory.getLogger("TestBase.class");
    private static BrowserEnvironment browserEnvironment;
    public static EnvironmentProperty environmentProperty;

    @BeforeAll
    public static void setUp() {
        environmentProperty = EnvironmentProperty.getInstance();//instancja singletona
        browserEnvironment = new BrowserEnvironment();
        driver = browserEnvironment.getDriver();
        logger.debug("Driver initialized");
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);//konf globalna
//        logger.debug("implicit wait set for 15 sec");
    }

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(driver);
        logger.debug("create object homePage");
    }

    @AfterEach
    void TearDown() {
        driver.quit();
        logger.debug("Driver closed");
    }
}
