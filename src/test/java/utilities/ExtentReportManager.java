package utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getReports() {

        if (extent == null) {

            // Jenkins-safe workspace path
            String reportDirPath = System.getProperty("user.dir")
                    + File.separator + "reports";

            // Create reports folder if not exists
            File reportDir = new File(reportDirPath);
            if (!reportDir.exists()) {
                reportDir.mkdirs();
            }

            String reportPath = reportDirPath
                    + File.separator + "extent.html";

            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

            spark.config().setReportName("Amazon Automation Report");
            spark.config().setDocumentTitle("Automation Results");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Tester", "Snigdha");
            extent.setSystemInfo("Environment", "QA");
        }

        return extent;
    }
}
