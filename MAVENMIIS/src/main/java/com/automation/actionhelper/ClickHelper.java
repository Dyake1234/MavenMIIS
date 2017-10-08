package com.automation.actionhelper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

public class ClickHelper {

	private static Logger Log = LogManager.getLogger(ClickHelper.class.getName());
	
	public void clickElement(WebElement element) throws Exception{

		int maxretries = 3;
		int count = 0;
		Exception bad = null;
		
		
		while(count < maxretries)
		{
			try {
				element.click();
				break;
				
			} catch (StaleElementReferenceException e) {
				// TODO Auto-generated catch block
				
				bad = e;
				count++;
				Log.info("Element is stale, retrying to click the button for "+count+"attempt");			
					
			} catch(Exception e){
			
				Log.error(e.getMessage());
				
			}
			
		}
		
		if(count==maxretries){
			System.out.println(bad.getMessage());
			throw bad;
		}
		
		
	}
	
	
}
