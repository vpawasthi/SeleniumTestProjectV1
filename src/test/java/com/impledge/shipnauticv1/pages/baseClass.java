package com.impledge.shipnauticv1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.impledge.shipnauticv1.utility.readingProperty;

public class baseClass {

	public static  WebDriver driver=null;
	
	public static  final WebDriver setDriver() {
		   
		  //String browserDriver = readingProperty.getSingleProperty("browserDriver.Browser");
		  String browserDriver ="Chrome";
		  
		  System.out.println("Browser driver value: " + browserDriver);
		 		  
		  if ( browserDriver.equals("Chrome")) {
			  			System.setProperty("webdriver.chrome.driver","D:\\Softwares\\browserdrivers\\chromedriver.exe"); 
						return driver= new ChromeDriver(); 
	    }	
		  else { 
				  		  System.setProperty("webdriver.gecko.driver","D:\\Softwares\\browserdrivers\\geckodriver.exe"); 
				  		  return driver= new FirefoxDriver();
		  	}
	}
}