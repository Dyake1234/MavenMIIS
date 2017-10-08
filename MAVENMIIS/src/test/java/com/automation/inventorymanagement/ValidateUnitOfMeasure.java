package com.automation.inventorymanagement;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.pageObjects.InventoryDetailsPage;
import com.automation.pageObjects.InventoryListPage;
import com.automation.pageObjects.Pages;
import com.automation.testbase.TestBase;


public class ValidateUnitOfMeasure extends TestBase{
	
	 private static Logger Log = LogManager.getLogger(ValidateUnitOfMeasure.class.getName());

	@BeforeTest
	public void Initialize() throws IOException, InterruptedException
	{
		Initializer();
	}

	@BeforeMethod
	public void Login() throws IOException, InterruptedException
	{

		navigateToBaseURL();
		Pages.loginPage().LoginwithCredentials(defaultusername, defaultpassword);
		Pages.dashboardPage().isAt();
		Pages.inventoryPage().GotoPage();
	}
	

	@Test(groups={"InventoryManagement"})
	public void ValidateDefineUnitofMeasureforQuantity() throws InterruptedException, FileNotFoundException, IOException{

		Pages.inventoryPage().selectProduct(InventoryListPage.Chips_Ahoy);
		Pages.inventoryDetailsPage().clickEdit();
		Pages.inventoryDetailsPage().selectUnitOfMeasure(InventoryDetailsPage.unitofmeasure_pc);
		Pages.inventoryDetailsPage().clickSave();
		Assert.assertEquals(Pages.inventoryDetailsPage().validatePrompt(), "Successfully Updated Product Inventory");
		
	}
	
	@AfterMethod
	public void deleteCookies(){

	driver.manage().deleteAllCookies();
	}
	
	@AfterTest(alwaysRun=true)	
	public void tearDown(){
		closedriver();
	}
	
	

}
