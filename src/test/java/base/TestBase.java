package base;

<<<<<<< HEAD
=======
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
>>>>>>> a3dd876ef156068d68059a139cdba17cd3017050
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import factory.DriverFactory;
import utilities.ConfigReader;

import java.time.Duration;

public class TestBase {

    protected WebDriver driver;
<<<<<<< HEAD
=======
    private static final Logger log = LogManager.getLogger(TestBase.class);

>>>>>>> a3dd876ef156068d68059a139cdba17cd3017050

    @BeforeMethod
    public void setUp() {

        ConfigReader.init();

        String browser = ConfigReader.get("browser");
        boolean headless = Boolean.parseBoolean(ConfigReader.get("headless"));
<<<<<<< HEAD

        driver = DriverFactory.initDriver(browser, headless);
=======
        log.info("Initializing driver...");

        driver = DriverFactory.initDriver(browser, headless);
        log.info("Driver initialized successfully.");
>>>>>>> a3dd876ef156068d68059a139cdba17cd3017050

        driver.manage().window().maximize();

        // Apply waits from config
        int implicitWait = Integer.parseInt(ConfigReader.get("implicit.wait"));
        int pageLoadTimeout = Integer.parseInt(ConfigReader.get("page.load.timeout"));

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(implicitWait));
        driver.manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));

        driver.get(ConfigReader.get("base.url"));
    }

    @AfterMethod
    public void tearDown() {
<<<<<<< HEAD
        DriverFactory.quitDriver();
=======
        log.info("Closing driver...");

        DriverFactory.quitDriver();
        
>>>>>>> a3dd876ef156068d68059a139cdba17cd3017050
    }
}
