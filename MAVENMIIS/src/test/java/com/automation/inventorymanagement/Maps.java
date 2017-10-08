package com.automation.inventorymanagement;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.pageObjects.DashboardPage;
import com.automation.pageObjects.Pages;
import com.automation.testbase.TestBase;

public class Maps extends TestBase{
	
	
@BeforeTest
public void Initialize() throws IOException, InterruptedException{
	
	driver = Initializer();

}


@Test
public void navigateToCMS() throws FileNotFoundException, IOException, InterruptedException{
	
	navigateToBaseURL();
	Pages.loginPage().LoginwithCredentials(defaultusername, defaultpassword);
	Pages.dashboardPage().clickToggleMenuBar();
	Pages.dashboardPage().navigateToCMSblah(DashboardPage.Media_Files);
	
	Thread.sleep(3000l);
	
}


@AfterMethod
public void Deletecookies(){
	
	
	driver.manage().deleteAllCookies(); //closing drivers
	
}


@AfterTest
public void tearDown(){

	closedriver();

}

}
