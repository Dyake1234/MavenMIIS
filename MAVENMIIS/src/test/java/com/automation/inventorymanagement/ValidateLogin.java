package com.automation.inventorymanagement;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.pageObjects.DashboardPage;
import com.automation.pageObjects.LoginPage;
import com.automation.pageObjects.Pages;
import com.automation.testbase.TestBase;


public class ValidateLogin extends TestBase {


	@BeforeClass
	public void Initialize() throws IOException, InterruptedException, InvalidFormatException
	{
		driver = Initializer();
	}
	@DataProvider
	public String[][] getLoginData()
	{
		return getData("TestData.xlsx", "ValidCredentials");
	}
	
	@Test(dataProvider = "getLoginData")
	
	public void Valogin(String username, String password) throws IOException, InterruptedException 
	{
		navigateToBaseURL();
		Pages.loginPage().LoginwithCredentials(username, password);
		Assert.assertTrue(Pages.loginPage().verifyLogin());
	}

	@AfterMethod
	public void deleteCookies()
	{
		driver.manage().deleteAllCookies(); //closing driver
	}
	
	@AfterClass()	
	public void tearDown()
	{
		closedriver(); 
	} 

}
