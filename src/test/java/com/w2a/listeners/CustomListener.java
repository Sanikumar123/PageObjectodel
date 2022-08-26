package com.w2a.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import com.w2a.utility.*;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.w2a.base.TestBase;

public class CustomListener extends TestBase implements ITestListener {
	
	
	
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("The name of the testcase success is :"+result.getMethod());
		test.log(Status.PASS, result.getName()+" PASS");
		
		
		
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("The name of the testcase failed is :"+result.getMethod());	
		try {
			CaptureScreenshot.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.log(Status.FAIL, result.getName()+" FAIL");
	    
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("The name of the testcase Skipped is :"+result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		System.out.println(context.getName()+" test case started");	
		test =report.createTest(context.getName());
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("The name of the testcase finished is :"+context.getName());
		
	}

}
