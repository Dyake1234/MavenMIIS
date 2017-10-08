package com.automation.pageRepository;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.base.BasePageObjectRepository;

public class InventoryDetailsObjectRepository extends BasePageObjectRepository {

	
	@FindBy(className="inv-edit-btn")
	public WebElement EditButton;
	
	@FindBy(css="#details-form")
	public WebElement DetailsForm;
	
	public By detailsform = By.cssSelector("#details-form");
	
	@FindBy(css="#unitOfMeasure")
	public WebElement UnitofMeasureDropdown;
	
	@FindBy(className="details-save-btn")
	public WebElement Savebutton;
	
	@FindBy(className="bootbox-body")
	public  WebElement Textprompt;
	
	
	public final int timeout = 30;
	
	public String ExcelPath = "C:\\Users\\Jake\\Desktop\\TestData.xlsx";
	public String Sheetname = "UnitofMeasure";
	
	public InventoryDetailsObjectRepository(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}

}
