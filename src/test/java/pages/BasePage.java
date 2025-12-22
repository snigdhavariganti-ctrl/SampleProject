package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import factory.DriverFactory;
import utilities.WaitUtils;

public class BasePage {

    protected WebDriver driver;
    private static final Logger log = LogManager.getLogger(BasePage.class);

    public BasePage() {
        this.driver = DriverFactory.getDriver();
    }

    // CLICK element (safe click with JS fallback)
    public void click(By locator) {
        try {
            WaitUtils.waitforClickable(locator).click();
        } catch (Exception e) {
            log.info("Normal click failed. Trying JS click: {}", locator);
            jsClick(locator);
        }
    }

    // INPUT / SEND KEYS
    public void input(By locator, String text) {
        WebElement ele = WaitUtils.waitforVisibility(locator);
        ele.clear();
        log.info("Typing into element: {} value: {}", locator, text);
        ele.sendKeys(text);
    }

    // GET TEXT
    public String getText(By locator) {
        return WaitUtils.waitforVisibility(locator).getText();
    }

    // FIND single element
    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    // FIND multiple elements
    protected List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    // SCROLL INTO VIEW
    public void scrollIntoView(By locator) {
        WebElement element = WaitUtils.waitforVisibility(locator);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // JS CLICK fallback
    public void jsClick(By locator) {
        WebElement element = WaitUtils.waitforVisibility(locator);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);
    }

    // CHECK IF ELEMENT DISPLAYED
    public boolean isDisplayed(By locator) {
        try {
            return WaitUtils.waitforVisibility(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // SWITCH TO NEW TAB (if opened)
    public void switchToNewTabIfOpened() {
        Set<String> handles = driver.getWindowHandles();
        if (handles.size() > 1) {
            ArrayList<String> tabs = new ArrayList<>(handles);
            driver.switchTo().window(tabs.get(1));
        }
    }
}
