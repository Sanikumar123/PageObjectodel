package com.w2a.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utility.CommonDataProvider;
import com.w2a.utility.ExcelReader;

public class AddCustomerTest extends TestBase{
	
	@Test(dataProviderClass=CommonDataProvider.class, dataProvider="dp")
	public void addCustomerTest(String uname, String pword)
	{
		System.out.println(uname);
		System.out.println(pword);
	}
	
	
	


}
