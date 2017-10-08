package com.automation.listeners;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.automation.testbase.Driver;
import com.automation.testbase.TestBase;

public class Listeners implements ITestListener {

private static Logger Log = LogManager.getLogger(Listeners.class.getName());
TestBase tb= new TestBase();
	
public int counter=0;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		Log.info("===========================Starting TestCase "+result.getName()+"============================");
		
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	
		
		tb.getScreenshot(result.getName(), "multipledata");
	}

	public void onTestFailure(ITestResult result) {
	
		System.out.println(result.getName()+" has failed");
		tb.getScreenshot(result.getName(), "failed");
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		

    }

    // Follo
	

	public boolean retry(ITestResult result) {
		
		if(counter < 4){
			counter++;
			
			System.out.println(counter);
			return true;
		}
		
		else
		return false;
	}

}
