package com.automation.pageRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.base.BasePageObjectRepository;

public class LoginPageObjectRepository extends BasePageObjectRepository {

	
	@FindBy(id ="txtEmail")
	public WebElement usertextbox;

	@FindBy(id = "txtPassword")
	public WebElement passtextfield;
	
	@FindBy(className = "sign-in")
	public WebElement Signbutton;
	
	@FindBy(linkText ="Forgot Password?")
	public WebElement ForgotPassword;
	
	@FindBy(className="alert-danger")
	public	List<WebElement> Prompt;
	
	@FindBy(className="parsley-required")
	public List<WebElement> valuerequired;

	
	
	public LoginPageObjectRepository(WebDriver driver) {
		super(driver);
	
		// TODO Auto-generated constructor stub
	}
	
	
	


}
