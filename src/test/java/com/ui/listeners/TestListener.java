package com.ui.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReporterUtility;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.logging.log4j.Logger;


import com.utility.LoggerUtility;

import java.util.Arrays;

public class TestListener implements ITestListener {

    Logger logger= LoggerUtility.getLogger(this.getClass());

    ExtentSparkReporter extentSparkReporter;
    ExtentReports extentReports;
    ExtentTest extentTest;

    public void onTestStart(ITestResult result)
    {
        logger.info(result.getMethod().getMethodName());
        logger.info(result.getMethod().getDescription());
        logger.info(Arrays.toString(result.getMethod().getGroups()));
        ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result)
    {
        logger.info(result.getMethod().getMethodName()+" "+"PASSED");
        ExtentReporterUtility.getTest().log(Status.PASS,result.getMethod().getMethodName()+" "+"PASSED");

    }

    public void onTestFailure(ITestResult result)
    {
        logger.info(result.getMethod().getMethodName()+" "+"FAILED");
        logger.error(result.getThrowable().getMessage());
        ExtentReporterUtility.getTest().log(Status.FAIL,result.getMethod().getMethodName()+" "+"FAILED");
        ExtentReporterUtility.getTest().log(Status.FAIL,result.getThrowable().getMessage()+" "+"FAILED");

        Object testclass=result.getInstance();
       BrowserUtility browserUtility= ((TestBase)testclass).getInstance();
       logger.info("Capturing info for the failed test class");
       String screenshotPath= browserUtility.takeScreenshot(result.getMethod().getMethodName());
       ExtentReporterUtility.getTest().addScreenCaptureFromPath(screenshotPath);



    }

    public void onTestSkipped(ITestResult result)
    {
        logger.warn(result.getMethod().getMethodName()+" "+"SKIPPED");
        ExtentReporterUtility.getTest().log(Status.SKIP,result.getMethod().getMethodName()+" "+"SKIPPED");

    }

    public void onStart(ITestContext context)
    {
        logger.info("Test Suite Started");
        ExtentReporterUtility.setupSparkReporter("reporter");


    }

    public void onFinish(ITestContext context)
    {
        logger.info("Test Suite Finished");
        ExtentReporterUtility.flushReport();

    }

}
