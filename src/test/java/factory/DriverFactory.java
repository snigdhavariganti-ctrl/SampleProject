package factory;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigReader;

public class DriverFactory {

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static WebDriver initDriver(String browser, boolean headless) {

        if (tlDriver.get() == null) {

            boolean remote = Boolean.parseBoolean(ConfigReader.get("remote"));

            if (remote) {
                setupRemoteDriver(browser);
            } else {
                setupLocalDriver(browser, headless);
            }
        }

        return getDriver();
    }

    // -------------------------------
    // LOCAL DRIVER SETUP
    // -------------------------------
    private static void setupLocalDriver(String browser, boolean headless) {

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions opt = new ChromeOptions();
            if (headless) opt.addArguments("--headless=new");
            opt.addArguments("--remote-allow-origins=*");

            tlDriver.set(new ChromeDriver(opt));
        }

        else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions opt = new EdgeOptions();
            if (headless) opt.addArguments("--headless=new");

            tlDriver.set(new EdgeDriver(opt));
        }

        else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions opt = new FirefoxOptions();
            if (headless) opt.addArguments("--headless");

            tlDriver.set(new FirefoxDriver(opt));
        }

        else {
            throw new RuntimeException("Invalid browser name: " + browser);
        }
    }

    // -------------------------------
    // REMOTE DRIVER (SELENIUM GRID)
    // -------------------------------
    private static void setupRemoteDriver(String browser) {

        try {
            String gridUrl = ConfigReader.get("grid.url");

            if (browser.equalsIgnoreCase("chrome")) {
                tlDriver.set(new RemoteWebDriver(new URL(gridUrl), new ChromeOptions()));
            }
            else if (browser.equalsIgnoreCase("edge")) {
                tlDriver.set(new RemoteWebDriver(new URL(gridUrl), new EdgeOptions()));
            }
            else if (browser.equalsIgnoreCase("firefox")) {
                tlDriver.set(new RemoteWebDriver(new URL(gridUrl), new FirefoxOptions()));
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Grid URL", e);
        }
    }

    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    public static void quitDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }
}
