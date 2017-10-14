package com.automation.inventorymanagement;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automation.pageObjects.InventoryListPage;
import com.automation.pageObjects.Pages;
import com.automation.testbase.TestBase;

public class ValidateInitial extends TestBase{
	
	 private static Logger Log = LogManager.getLogger(ValidateInitial.class.getName());

	@BeforeTest
	public void Initialize() throws IOException, InterruptedException{

		Initializer();
	}

	@BeforeMethod
	public void Login() throws IOException, InterruptedException{

		navigateToBaseURL();
		Pages.loginPage().LoginwithCredentials(defaultusername, defaultpassword);
		Pages.inventoryPage().GotoPage();

	}
	@Parameters({"Excelsheet","Sheetname"})
	@Test(groups={"InventoryManagement"})
	public void ValidateInitialDef(String Excelsheet, String Sheetname) throws InterruptedException, IOException
	{
		Pages.inventoryPage().selectProduct(InventoryListPage.Pork_vland_Only).clickEdit();
		Assert.assertTrue(Pages.inventoryDetailsPage().inventoryDetailsWindow());
		Assert.assertTrue(Pages.inventoryDetailsPage().validateUnitofMeasure(Excelsheet, Sheetname));
	}
 
	@AfterMethod
	public void deleteCookies(){

	driver.manage().deleteAllCookies();
	}
	
	@AfterTest
	public void tearDown(){
	
		closedriver();

	}
	
	

}



