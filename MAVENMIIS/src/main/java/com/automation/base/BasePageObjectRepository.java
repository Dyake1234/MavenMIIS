package com.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.automation.testbase.TestBase;

public class BasePageObjectRepository extends TestBase{

	public WebDriver driver;
	
	public BasePageObjectRepository(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


}
