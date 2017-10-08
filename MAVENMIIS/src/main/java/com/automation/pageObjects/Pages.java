package com.automation.pageObjects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class Pages {

	public static WebDriver driver;
	
	public static LoginPage loginPage() throws FileNotFoundException, IOException{
		
		return new LoginPage(driver);
	}
	public static DashboardPage dashboardPage() throws FileNotFoundException, IOException{
		
		return new DashboardPage(driver);
	}
	public static InventoryListPage inventoryPage() {
		
		return new InventoryListPage(driver);
	}
	public static InventoryDetailsPage inventoryDetailsPage() throws FileNotFoundException, IOException{
		
		return new InventoryDetailsPage(driver);
	}
}
