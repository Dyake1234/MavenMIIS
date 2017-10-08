package com.automation.pageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.base.BasePageObjectRepository;

public class DashboardPageRepository extends BasePageObjectRepository {

	@FindBy(className="page-header")
	public	WebElement headername;
	
	@FindBy(linkText="Inventory")	public WebElement sideInventory;
	
	@FindBy(css="img[alt='Burger Menu']")  public WebElement sidebartrigger;
	
	@FindBy(xpath="(//a[contains(@href, 'inventory/inventory-list')])[2]") public WebElement Inventory;
	
	@FindBy(className="btn btn-primary btn-add-inv") public WebElement Addbutton;
	
	@FindBy(css="img[alt='Burger Menu']") public WebElement ToggleButton;
	
	
	public DashboardPageRepository(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
