package com.w2a.utility;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	private static ExtentSparkReporter htmlReporter;
	private static ExtentReports extent;
	
	public static ExtentReports getInstance() 
	{
		if(extent==null)
		{
			 htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") +"/test-output/testReport.html");
			extent = new ExtentReports();
			try {
				htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"\\src\\test\\resources\\extentconfig\\ReportsConfig.xml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			extent.attachReporter(htmlReporter);
		    
			
		}
		
		return extent;
	}

}
