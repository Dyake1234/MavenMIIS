package com.automation.pageObjects;



import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.automation.base.BasepageClass;
import com.automation.pageRepository.LoginPageObjectRepository;

public class LoginPage extends BasepageClass<LoginPageObjectRepository>{
	
	private static  Logger log = LogManager.getLogger(LoginPage.class.getName());
	
		public LoginPage(WebDriver driver) throws FileNotFoundException, IOException{
			
			super(driver, new LoginPageObjectRepository(driver));
		}


		public void LoginwithCredentials(String username, String Password){
		
			objectrepository.usertextbox.sendKeys(username);
			log.info("Entered:" + username + " as username");
			objectrepository.passtextfield.sendKeys(Password);
			log.info("Entered:" + Password + " as password");
			objectrepository.Signbutton.click();
			log.debug("Clicked Sign-In Button");
		}
		public void ClickForgotPasswordLink(){
			objectrepository.ForgotPassword.click();
			
		}
		
		
		public boolean verifyLogin(){
			
				/*	if(objectrepository.valuerequired.size()>0 || objectrepository.Prompt.size()>0){
				return false;
			}
			else*/
				return new DashboardPage(driver).isAt();

		}

}
