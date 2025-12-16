package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportManager {
	
	public static ExtentReports extent;
	
	public static ExtentReports getReports() {
		
		if(extent ==null) {
			
		String reportPath=	System.getProperty("user.dir") + "/reports/extent.html";
		
		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
		
		spark.config().setReportName("Amazon Automation Report");
		spark.config().setDocumentTitle("Automation results");
		
		extent = new ExtentReports();
				extent.attachReporter(spark);
				
				extent.setSystemInfo("Tester", "Snigdha");
				extent.setSystemInfo("Env", "QA");
				
		}
		
		return extent;
		
		
	}

}
