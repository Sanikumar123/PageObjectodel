package com.w2a.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.listeners.CustomListener;

@Listeners(CustomListener.class)
public class BankManagerLogintest extends TestBase {
	
	@Test
	public void loginAsbankManager()
	{
		
		driver.findElement(By.xpath("//*[text()='Bank Manager Login']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@ng-click='addCust()']")).isDisplayed());
		
		
	}

}
