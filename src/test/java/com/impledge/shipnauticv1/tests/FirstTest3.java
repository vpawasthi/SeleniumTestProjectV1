package com.impledge.shipnauticv1.tests;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.impledge.shipnauticv1.pages.LoginPO;
import com.impledge.shipnauticv1.utility.ReadingXLS;

public class FirstTest3 extends BaseTest {
	
	
	 private static WebDriver driver;
	
	 	@BeforeClass
		public void setUp() {
		driver = getDriver();
			
		}
		 
		@Test
	    public void LoginLCCApplication4() {
		     
			 try {
				 
				  test=extent.createTest("Test4");
				  test.log(Status.PASS, "login passed4");
			 	}
			 
			 catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		
		@Test
	    public void LoginLCCApplication5() {
		     
			 try {
				 test=extent.createTest("Test5");
				 test.createNode("Test5- 01");
				 
				  test.log(Status.SKIP, "login Failed 05");
			 	}
			 
			 catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		}
		
		 @AfterClass
		 public void tearDown() {
			
			  driver.close();
			  System.out.println("Browser Closed Sucessfully");
		 }
	 
}
