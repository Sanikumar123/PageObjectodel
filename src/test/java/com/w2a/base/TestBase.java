package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.w2a.utility.ExcelReader;
import com.w2a.utility.ExtentManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fin;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public ExtentReports report = ExtentManager.getInstance();
	public  ExtentTest test;


	@BeforeSuite
	public void setUp() throws IOException {
		
		

		if (driver == null) {
			// loading config properties file
			fin = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\Config.properties");
			config.load(fin);
			log.debug("Config file loaded!!!");

			// loading OR properties file
			fin = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\OR.properties");
			config.load(fin);

			// declaring chromedriver
			if (config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
				driver = new ChromeDriver();
				log.debug("Chrome Browser opened!!!");

			}

			// launching testurl
			driver.get(config.getProperty("testurl"));
			log.debug("test url launched"+config.getProperty("testurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);

		}

	}

	public void click(String xpath) {
		
		try {
		driver.findElement(By.xpath(xpath)).click();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		test.log(Status.INFO, "Clicking on : "+xpath);
		
	}
	
	
	
	
	@AfterSuite
	public void tearDown() {
		if (driver != null) {
			report.flush();
			driver.quit();
			
		}

	}

}
