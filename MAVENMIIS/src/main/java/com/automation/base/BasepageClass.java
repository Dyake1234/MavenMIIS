package com.automation.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.automation.actionhelper.ClickHelper;
import com.automation.excelhelper.ExcelDriven;


public class BasepageClass<ObjectRepository extends BasePageObjectRepository>
{

	protected WebDriver driver=null;
	protected ObjectRepository objectrepository;
	protected WebDriverWait waits;
	protected Select select;
	protected Properties prop = new Properties();
	protected String Excelpropertieslocation = System.getProperty("user.dir")+"\\src\\main\\java\\com\\automation\\utilities\\Excel.properties";
	protected ExcelDriven excel ;
	protected  ArrayList<String> list;
	protected JavascriptExecutor jsexecutor;
	protected BasepageClass(WebDriver driver, ObjectRepository object) 
	{
		this.driver = driver;
		objectrepository = object;
		PageFactory.initElements(driver, this);
	}

	protected void checkPageIsReady() 
	{
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  		  //Initially bellow given if condition will check ready state of page.
		  if (js.executeScript("return document.readyState").toString().equals("complete")){ 
		   return; 
		  } 
		  //This loop will rotate for 25 times to check If page Is ready after every 1 second.
		  //You can replace your value with 25 If you wants to Increase or decrease wait time.
		  for (int i=0; i<25; i++){ 
		   try {
		    Thread.sleep(1000);
		    }catch (InterruptedException e) {} 
		   //To check page ready state.
		   if (js.executeScript("return document.readyState").toString().equals("complete")){ 
		    break; 
		   }   
		  }
		 }
	protected WebDriverWait IsElementPresent(int seconds){	
				waits = new WebDriverWait(driver, seconds );		
				return waits;
			}
	protected void javascriptclick(WebElement element){
				JavascriptExecutor jsexecutor = (JavascriptExecutor)driver;
				jsexecutor.executeScript("arguments[0].click()", element);
				
			}
	protected ArrayList<String> checkOptions()
	{
					ArrayList<String> list = null;
					try {
						prop.load(new FileInputStream(Excelpropertieslocation));
						excel = new ExcelDriven(prop.getProperty("Excelpath"), prop.getProperty("UnitofMeasure"));
						 list = new ArrayList<String>();
							for(int i =1 ; i<excel.getLastRowNum()+1;i++)
							{
								excel.getRow(i);

									for (int d = 0; d<excel.getLastCellNum();d++)
									{
											list.add(excel.getCellData(d));	
									}
							}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
				
					}
						return list;	 		
	}
	
	
	protected void click(WebElement element)
	{
		ClickHelper click = new ClickHelper();
		try {
			click.clickElement(element);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	protected void selectDropDown(String name, WebElement element)
	{
		select = new Select(element);
		select.selectByVisibleText(name);
	}
	
	protected void selectDropDown(int index, WebElement element)
	{
		select = new Select(element);
		select.selectByIndex(index);
	}
	

	protected String generateRandomNumber()
	{
		 Random rand = new Random(); 
		 int pickedNumber = rand.nextInt(100) + 1; 
		 String number = Integer.toString(pickedNumber);
		 return number; 
	}
	
	protected String generateRandomNumber(int range)
	{
		 Random rand = new Random(); 
		 int pickedNumber = rand.nextInt(range) + 1; 
		 String number = Integer.toString(pickedNumber);
		 return number; 
	}
	
	
	
}