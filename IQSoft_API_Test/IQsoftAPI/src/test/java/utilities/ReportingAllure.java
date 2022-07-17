package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testCases.BaseTest;

public class ReportingAllure implements ITestListener {

    BaseTest baseTest = new BaseTest();
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    // Text attachments for Allure
    // Text attachments for Allure
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }



    @Override
    public void onTestStart(ITestResult iTestResult) {
        baseTest.logger.info(iTestResult.getName()+" Test Start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        baseTest.logger.info(iTestResult.getName()+" Test Succeed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        baseTest.logger.fatal(iTestResult.getName()+" Test Failed");
        saveTextLog(iTestResult.getName()+" Test Failed");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        baseTest.logger.warn(iTestResult.getName()+" Test Skipped");
        saveTextLog(iTestResult.getName()+" Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        baseTest.logger.fatal(iTestResult.getName()+" Test Failed");
        saveTextLog(iTestResult.getName()+" Test Failed");
    }
}
