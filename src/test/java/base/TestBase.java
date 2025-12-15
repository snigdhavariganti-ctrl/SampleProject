package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import factory.DriverFactory;
import utilities.ConfigReader;

import java.time.Duration;

public class TestBase {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        ConfigReader.init();

        String browser = ConfigReader.get("browser");
        boolean headless = Boolean.parseBoolean(ConfigReader.get("headless"));

        driver = DriverFactory.initDriver(browser, headless);

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
        DriverFactory.quitDriver();
    }
}
