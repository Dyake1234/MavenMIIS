package com.automation.testbase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.automation.excelhelper.ExcelDriven;



public class TestBase extends Driver{
	
	ExcelDriven excel;
	
	
	private static Logger Log = LogManager.getLogger(TestBase.class.getName());

	public WebDriver Initializer() throws IOException, InterruptedException 
	{
		 loadFile();
		 
		if(prop.getProperty("mode").equals("local"))
		{
		
			Log.info("Initializing LocalDriver");
			driver = LocalDriver();

		}
		 
		else if(prop.getProperty("mode").equals("remote"))
		{
			Log.info("Initializing RemoteDriver");
			driver = RemoteDriver();
		}
		
		return driver;
	}
	
	public void getScreenshot(String methodname, String folder)
	{
		

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");	
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try
		{
			String reportDirectory = System.getProperty("user.dir")+"\\src\\main\\java\\com\\automation\\takescreenshot\\";
					
			File destinationfile = new File(reportDirectory+folder+"\\"+methodname+"_"+formater.format(calendar.getTime())+".png");
			FileUtils.copyFile(src, destinationfile);
			
			Reporter.log("<a href='" +destinationfile+ "'> <img src ='"+destinationfile+"'height='100' width='100'/> </a> ");
			
			Log.debug("Captured Screenshot");
		} catch (IOException e) 
		{
				Log.info(e.getMessage());
		}
		
	}
	public void navigateToBaseURL()
	{
		driver.get(prop.getProperty("url")); 
		Log.info("Navigated to BaseURL");
	}
	
	public void closedriver()
	{
		driver.close();
		driver = null;
	}
	
	
	public String[][] getData(String excelname, String sheetname)
	{
		loadFile();
		String path = System.getProperty("user.dir")+prop.getProperty("Excelpath")+excelname;
		excel = new ExcelDriven(path, sheetname);   //path of excel and sheetname
		return	excel.DataProviderExcel();
	}
	
	@Test
	public void Openreport() throws IOException, InterruptedException
	{	Initializer();
		driver.get(System.getProperty("user.dir")+"\\test-output\\index.html");
	}

}
