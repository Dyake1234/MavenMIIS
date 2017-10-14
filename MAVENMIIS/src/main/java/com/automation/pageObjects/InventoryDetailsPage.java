package com.automation.pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.automation.base.BasepageClass;
import com.automation.pageRepository.InventoryDetailsObjectRepository;


public class InventoryDetailsPage extends BasepageClass<InventoryDetailsObjectRepository> 
{
	
	
	private static Logger Log = LogManager.getLogger(InventoryDetailsPage.class.getName());
	
	/* 	unit of measure */
	public static final String unitofmeasure_pc = "pc"; 
	public static final String unitofmeasure_g = "g";



	public InventoryDetailsPage(WebDriver driver)
	{
		super( driver, new InventoryDetailsObjectRepository(driver));
	}
	
	public void clickEdit()
	{
		IsElementPresent(objectrepository.timeout)
		.until(ExpectedConditions.visibilityOf(objectrepository.DetailsForm));
	
		objectrepository.EditButton.click();
		Log.info("Clicked Edit");
	}
	
	public void clickSave()
	{
		objectrepository.Savebutton.click();
		Log.debug("Clicked Save");
		
	}
	
	public boolean validateUnitofMeasure(String ExcelSheet, String Sheetname) 
	{	
		ArrayList <String> unitofmeasures = checkOptions(ExcelSheet, Sheetname);
		
		 select = new Select(objectrepository.UnitofMeasureDropdown);

		List<WebElement> list = select.getOptions();
		int count = 0;	
		for(WebElement each: list)
		{	
			for(int i = 0 ;i<unitofmeasures.size();i++)
			{
				if(each.getText().equals(unitofmeasures.get(i)))
				{
					Log.info("validated -> "+each.getText());
					count++;
				}
			}		
		}
		
		if(unitofmeasures.size() == count)
		{
			Log.info("Succesful in validating dropdown");
			return true ;
		}
		else
			Log.info("dropdown options does not match");
			return false;
		
	}
	
	public boolean inventoryDetailsWindow()
	{
		if(driver.findElements(objectrepository.detailsform).size() > 0 ){
			Log.info("InventoryDetails Window is Present");
			return true;
		}
		
		else
			Log.info("InventoryDetails Window is not Present");
			return false;
		
	}

	public void selectUnitOfMeasure(String unitofmeasure)
	{
		selectDropDown(unitofmeasure, objectrepository.UnitofMeasureDropdown);
		Log.debug("Selected "+unitofmeasure+" as unitofmeasure");
	}
	
	public String validatePrompt(){
		IsElementPresent(objectrepository.timeout).until(ExpectedConditions.visibilityOf(objectrepository.Textprompt));
		String text = objectrepository.Textprompt.getText();
		Log.info("Text Prompted"+text);
		return text;
	}
	



	
}
