package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {

    private static ExtentReports extent;

    public static ExtentReports getReport() {

        if(extent == null) {

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter(
                            "reports/AutomationReport.html"
                    );

            extent = new ExtentReports();

            extent.attachReporter(reporter);

            extent.setSystemInfo(
                    "Tester",
                    "Nkosinathi Jiyane"
            );
        }

        return extent;
    }
}