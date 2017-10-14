package com.automation.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.automation.pageObjects.Pages;


public class Driver {

	 public static WebDriver driver=null;
	 public  Properties  prop = new Properties();
	 public  String defaultpassword;
	 public  String defaultusername;
	 public	 FileInputStream file;
	 public  DesiredCapabilities capabilities;

	 
	 public WebDriver LocalDriver() throws IOException, InterruptedException{
		
		 loadFile();
		 getdefaultcredentials();
			 	
		 if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
			{
			 System.setProperty("webdriver.chrome .driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();

			}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
			{
			
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		
			driver = new FirefoxDriver();
		
			}
		else{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\drivers\\IEDriverServer32.exe");
			driver = new InternetExplorerDriver();
			}

			driver.manage().window().maximize();
	
			driver.manage().deleteAllCookies();
		
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			Pages.driver = driver;
			
		return driver;	
		
	}

	public WebDriver RemoteDriver() throws IOException, InterruptedException{
	
		 loadFile();
		 getdefaultcredentials();
		 	
		if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
	 	   {
		  capabilities = DesiredCapabilities.firefox();
	      capabilities.setCapability(FirefoxDriver.BINARY,new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe").getAbsolutePath());
	      driver =  new RemoteWebDriver(new URL(prop.getProperty("firefoxclient")), capabilities);
	 	   }
	      else if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
	       {
	    	  	capabilities = DesiredCapabilities.chrome();
	    	  	capabilities.setCapability("chrome.binary", new File("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe").getAbsolutePath());
	    	  	driver =  new RemoteWebDriver(new URL(prop.getProperty("chromeclient")), capabilities);
	       }

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		Pages.driver = driver;
		
	return driver;
		
	}
	
	public void loadFile(){
		
		try {
		
			prop.load(new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\automation\\configurations\\Configuration.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public void getdefaultcredentials(){
		
		 defaultusername = prop.getProperty("username");
		 defaultpassword = prop.getProperty("password");
	}
	
	
}
