package api.utilitise;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class ExtentReportManager implements ITestListener {
    public ExtentSparkReporter sparkReporter;//UI report
    public ExtentReports extent;//Common report
    public ExtentTest test;//Writing test
    String repname;

    public void onStart(ITestContext testContext) {//execute only once
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd.HH.mm.ss").format(new Date());//timestamp
        repname = "Test Report-" + timeStamp + ".html";

        sparkReporter = new ExtentSparkReporter(".Report" + repname);//Specify location of report
        sparkReporter.config().setDocumentTitle("RestAssuredAutomationProject");//title of report
        sparkReporter.config().setReportName("Pet Store user API");//name of the report
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application", "Pet Store user API ");
        extent.setSystemInfo("Operating system", System.getProperty("os.name"));
        extent.setSystemInfo("User name", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("user", "shiv");


    }

    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        test.createNode(result.getName());
        test.log(Status.PASS, "Test Passed");
    }

    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        test.createNode(result.getName());
        test.log(Status.FAIL, "Test Failed");
    }

    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        test.createNode(result.getName());
        test.log(Status.SKIP, "Test Skipped");

    }
    public void onFinish(ITestContext testContext)
    {
        extent.flush();
    }
}

