package com.w2a.utility;

import java.io.IOException;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.w2a.base.TestBase;

public class CommonDataProvider extends TestBase {
	
	@DataProvider(name="dp")
	public Object[][] getDataFromExcel(Method m) throws IOException
	{
		Object[][] data = ExcelReader.readData(System.getProperty("user.dir")+"\\src\\test\\resources\\Excel\\excelfile.xlsx", m.getName());
		return data;
	}

}
