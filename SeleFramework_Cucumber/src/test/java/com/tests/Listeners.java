package com.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.resources.ExtentReportsNg;

public class Listeners extends BaseTest implements ITestListener {
	ExtentTest test;
	ExtentReports extent=ExtentReportsNg.getExtentReportsNg();
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal(); //Thread Safe
	
	@Override
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName()); 
		extentTest.set(test);//unique thread id(ErrorvalidationTest)->test
	  }

	@Override 
	 public void onTestSuccess(ITestResult result) {
	    test.log(Status.PASS, "Test passed");
	  }

	@Override
	  public void onTestFailure(ITestResult result) {
	    extentTest.get().fail(result.getThrowable());
	    try {
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    String sourcepath=null;
	    try {
	    	 sourcepath= getScreenshot(result.getMethod().getMethodName(),driver);
	    }
	  catch(IOException e) {
		  e.printStackTrace();
	  }
	    test.addScreenCaptureFromPath(sourcepath,result.getMethod().getMethodName());
	  }

	 @Override
	  public void onTestSkipped(ITestResult result) {
	    // not implemented
	  }

	 @Override
	 public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	  }

	@Override
	  public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }

	 @Override
	  public void onStart(ITestContext context) {
	    // not implemented
	  }

	  @Override
	  public void onFinish(ITestContext context) {
	    extent.flush();
	  }
	}

	
	

