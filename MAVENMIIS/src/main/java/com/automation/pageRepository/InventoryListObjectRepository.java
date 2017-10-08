package com.automation.pageRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.base.BasePageObjectRepository;

public class InventoryListObjectRepository extends BasePageObjectRepository{

	@FindBy(className="btn-add-inv")
	public WebElement AddButton;
	
	@FindBy(id="product-fltr-collection")
	public WebElement collections;
	
	@FindBy(id="prod-apply-fltr-btn")
	public WebElement Applybutton;
	
	@FindBy(xpath="//table[@id='tbl-inventory-list']/tbody/tr")
	public List<WebElement> inventorytable;
	
	@FindBy(css="div[id='add-product-table_filter'] input[type='search']")
	public WebElement addsearchtextbox;
	
	@FindBy(xpath="//li[@class='paginate_button ']/a")
	public List<WebElement> paginate_button;
	
	@FindBy(xpath="//li[@id='tbl-inventory-list_next']/a")
	public WebElement NextButton;
	
	By next = By.cssSelector("#tbl-inventory-list_next>a");
	public By searchedelement = By.className("add-prod-btn");
	
	@FindBy(xpath="//table[@id='tbl-inventory-list']/tbody/tr/td[3]/a")
	 public List<WebElement> tablelinks;
	
	@FindBy(className="add-prod-btn")
	public WebElement selectbutton;
	
	@FindBy(id="tbl-inventory-list_processing")
	 public WebElement loading;
	
	@FindBy(id="restock-form-qty")
	 public WebElement restockquantityfield;
	
	//public List <WebElement> TableLinks = table.findElements(Links);
	@FindBy(id="restock-form-loc")
	public WebElement restocklocationdropdown;
	
	@FindBy(className="restock-loc-btn")
	public WebElement restockaddlocationbutton;
	
	@FindBy(className="bootbox-body")
	public  WebElement Textprompt;
	
	@FindBy(id="save-restock-btn")
	public WebElement savebutton;
	
	public final int timeout = 30;

	

	public InventoryListObjectRepository(WebDriver driver)
	{
		super(driver);
	}
}
