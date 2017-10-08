package com.automation.pageObjects;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automation.base.BasepageClass;
import com.automation.pageRepository.DashboardPageRepository;


public class DashboardPage extends BasepageClass<DashboardPageRepository>{

private static Logger Log = LogManager.getLogger();	
	
		public DashboardPage(WebDriver driver)
		{
			super(driver, new DashboardPageRepository(driver));
		}

		public static final String Media_Files="Media Files";
		public static final String Pages= "Pages";
		public static final String Menu= "Menu";
		
	public boolean isAt()
	{

		try{
			//checkPageIsReady();
			boolean b = objectrepository.headername.getText().contains("Dashboard");
			Log.info("Login Successful");
			return b;
			}	
		catch(Exception e){
			Log.error("Failure to login");
			return false;
		}

	}
	
	public void AccessInventoryList()
	{
		IsElementPresent(20)
	    .until(ExpectedConditions.elementToBeClickable(objectrepository.sidebartrigger));
		checkPageIsReady();
		objectrepository.sidebartrigger.click();
		objectrepository.sideInventory.click();
		objectrepository.Inventory.click();
	}
	
	public String geTtitle()
	{
		IsElementPresent(10).until(ExpectedConditions.elementToBeClickable(objectrepository.sidebartrigger));
		checkPageIsReady();
		return driver.getTitle();
	}
	
	public void clickToggleMenuBar(){
		
		objectrepository.ToggleButton.click();
	}
	
	
	public void navigateToCMSblah(String category)
	{
		driver.findElement(By.xpath("//a/span[contains(text(),'CMS')]/parent::a/following-sibling::ul[@aria-disabled='false']//span[contains(text(),'"+category+"')]")).click();
	}
	
	public void navigateToCoreblah(String category)
	{
		driver.findElement(By.xpath("//a/span[contains(text(),'Core')]/parent::a/following-sibling::ul[@aria-disabled='false']//span[contains(text(),'"+category+"')]")).click();
	}
	
	
	public void navigateToSettingsblah(String category)
	{
		driver.findElement(By.xpath("//a/span[contains(text(),'Settings')]/parent::a/following-sibling::ul[@aria-disabled='false']//span[contains(text(),'"+category+"')]")).click();
	}
	
	
	
		
}
