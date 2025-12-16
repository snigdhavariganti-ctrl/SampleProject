package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import factory.DriverFactory;

public class ScreenshotUtil {
	
    public static String takeScreenshot(String testName) {
    	
    	String timestamp = new SimpleDateFormat("yyy_MM_dd_hh_mm_ss").format(new Date());
    	
    	
    	String screenshotName = testName + "_" + timestamp + ".png";
    	
    	String folderPath  = System.getProperty("user.dir") + "/screenshots";
    	
    	
    	File folder = new File(folderPath);
    	
    	if(!folder.exists())
    		folder.mkdir();
    	
    	String filePath = folderPath + screenshotName;
    	
    	
        File src = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        
        File dest = new File(filePath);
        
        
        try {
        	
        	FileUtils.copyFile(src, dest);
        	 System.out.println("📸 Screenshot saved: " + filePath);
        } catch (IOException e) {
            System.out.println("❌ Failed to save screenshot: " + e.getMessage());
        
        }
		return filePath;

    }
}
    
    
    


