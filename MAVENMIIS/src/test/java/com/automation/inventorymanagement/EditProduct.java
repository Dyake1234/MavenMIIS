package com.automation.inventorymanagement;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.listeners.Listeners;

public class EditProduct {

	int counter=0;
	
	@Test
	public void Fail(){
		System.out.println(counter);
		counter++;
		Assert.assertEquals(counter, 4);
		
	
	}
}
