package com.w2a.utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.w2a.base.TestBase;

public class CaptureScreenshot extends TestBase {
	
	
	public static void captureScreenshot() throws IOException
	{
		Date d = new Date();
		String screenshotname = d.toString().replace(":", "_").replace(" ", "_");
		TakesScreenshot scrShot = (TakesScreenshot)driver;
		File srcfile = scrShot.getScreenshotAs(OutputType.FILE);
		
		File destfile = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\screenshot\\"+screenshotname+".png");
		
        FileHandler.copy(srcfile, destfile);
		
		
	}

}
