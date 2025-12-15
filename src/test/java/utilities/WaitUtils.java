package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverFactory;

public class WaitUtils {
	
	 private static  WebDriver driver =DriverFactory.getDriver();
	 
	 private static WebDriverWait getWait() {
		    return new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
		}
	    
	    //wait for visibility
	    
	    public  static WebElement waitforVisibility( By locator) {
	    	
	    	return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
	    	
	    }
	    
	// wait for clickable 
	    
	    public static  WebElement waitforClickable(By locator) {
	    	
	    	return getWait().until(ExpectedConditions.elementToBeClickable(locator));
	    }
	    
	    // Wait for presence (element exists in DOM)

	    public static  WebElement waitforPresenceOFElement(By locator) {
	    	
	    	return getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
	    }
	    
	    // Wait for invisibility

	    public static boolean waitForInvisibility(By locator) {
	      
	    	return getWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
	    }
	    
	    // Wait for text to appear

	    public static boolean waitfortext(By locator,String text) {
	    	
	    	return getWait().until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	    }
	    
	    
	    // Fluent Wait (advanced)

	    public static WebElement fluentWait(By locator, int timeoutSec, int pollingMillis) {

	        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
	            .withTimeout(Duration.ofSeconds(timeoutSec))
	            .pollingEvery(Duration.ofMillis(pollingMillis))
	            .ignoring(NoSuchElementException.class)
	            .ignoring(StaleElementReferenceException.class);

	        return fluentWait.until(driver -> driver.findElement(locator));
	    }
	    
	    
}
