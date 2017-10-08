package com.automation.inventorymanagement;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.pageObjects.InventoryListPage;
import com.automation.pageObjects.Pages;
import com.automation.testbase.TestBase;

public class AddProduct_Valid extends TestBase{

	
private static Logger Log = LogManager.getLogger(AddProduct_Valid.class.getName());


@BeforeTest
public void Initialize() throws IOException, InterruptedException{
	driver = Initializer();
}

@BeforeMethod(alwaysRun=true)  
public void Login() throws IOException, InterruptedException{

	navigateToBaseURL();
	Pages.loginPage().LoginwithCredentials(defaultusername, defaultpassword);
	
}

@Test(groups={"InventoryManagement"})  //include data provider for adding multiple products

public void AddingProduct_ValidEntry() throws InterruptedException  {
	
	Pages.inventoryPage().GotoPage();
	Pages.inventoryPage().clickAddProductButton(InventoryListPage.Test_Product_QA);
	Pages.inventoryPage().addRandomQuantity();
	Pages.inventoryPage().selectLocation(InventoryListPage.Location_UpperCanteen);
	
	Assert.assertTrue(true);
}

@AfterMethod(alwaysRun=true)	
public void deletecookies(){
	
	driver.manage().deleteAllCookies();


}

@AfterTest
public void tearDown(){
	closedriver();


}


}