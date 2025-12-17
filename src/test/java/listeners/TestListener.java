package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.ExtentReportManager;
import utilities.ScreenshotUtil;

public class TestListener implements ITestListener {
	
	private static ExtentReports extent = ExtentReportManager.getReports();
	
	private static ThreadLocal<ExtentTest>  test = new ThreadLocal<>();

     public void onTestStart(ITestResult result) {
    	 
    	 ExtentTest extentTest =  extent.createTest(result.getMethod().getMethodName());
         test.set(extentTest);
    	 
         System.out.println("🟦 Test Started: " + result.getName());

     }
     
     public void onTestSuccess(ITestResult result) {
    	 test.get().log(Status.PASS, "Test Passed");
         System.out.println("🟦 Test Sucess: " + result.getName());

     }
		
     public void onTestFailure(ITestResult result) {
    	 test.get().log(Status.FAIL, "Test Failed");
         test.get().log(Status.FAIL, result.getThrowable());

         System.out.println("🟥 Test Failed: " + result.getName());
         
         String screenshotPath=  ScreenshotUtil.takeScreenshot(result.getName());
         
         test.get().addScreenCaptureFromPath(screenshotPath);
         
         System.out.println("📸 Screenshot saved at: " + screenshotPath);
     }
     
     public void onTestSkipped(ITestResult result) {
    	 
    	 test.get().log(Status.SKIP,"Test Skipped");
    	 
         System.out.println("🟨 Test Skipped: " + result.getName());
     }
     
     public void onStart(ITestContext context) {
         System.out.println("🚀 Test Execution Started...");
     }

     @Override
     public void onFinish(ITestContext context) {
    	 extent.flush();
         System.out.println("🏁 Test Execution Finished.");
     }

}
