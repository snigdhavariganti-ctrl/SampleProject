package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

import factory.DriverFactory;
import utilities.WaitUtils;

public class BasePage {

    protected WebDriver driver;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
    }

    // CLICK Element (Safe Click)
    public void click(By locator) {
        try {
            WaitUtils.waitforClickable(locator).click();
        } catch (Exception e) {
            System.out.println("Normal click failed. Trying JS click: " + locator);
            jsClick(locator);
        }
    }

    // INPUT / SENDKEYS
    public void input(By locator, String text) {
        WebElement ele = WaitUtils.waitforVisibility(locator);
        ele.clear();
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
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // JS CLICK fallback
    public void jsClick(By locator) {
        WebElement element = WaitUtils.waitforVisibility(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    // CHECK IF ELEMENT DISPLAYED
    public boolean isDisplayed(By locator) {
        try {
            return WaitUtils.waitforVisibility(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
