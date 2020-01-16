package com.impledge.shipnauticv1.tests;


import java.io.PrintWriter;
import java.io.StringWriter;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.impledge.shipnauticv1.pages.LoginPO;
import com.impledge.shipnauticv1.utility.ReadingXLS;

public class FirstTest extends BaseTest {
	
	 //WebDriver driver = baseClass.initlisedriver();
	
	 	private static WebDriver driver;
	 	
	
	 	LoginPO LoginPage;
		
		@BeforeClass
		public void setUp() {
		driver = getDriver();
		System.out.println("Before Class method in First Test Class");
			
		}
		 
		@Test
	    public void LoginLCCApplication() {
			 String sUserName;
			 String sPassword;
		     
			 try {
				 
				 test=extent.createTest("Test1");
				 
			     LoginPage = new LoginPO(driver);
				 		
			      ReadingXLS.sFile = ReadingXLS.sTEST_DATA_FILE_PATH +  "demoWorkSheet.xlsx";
			 
			 
			      sUserName=ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 2);
			      sPassword = ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 3);
			
			 	 LoginPage.loginLCC(sUserName,sPassword);
			 	 
			 	 test.log(Status.PASS, "login passed");
			 	 Thread.sleep(20000);
			 	 
			 	 Assert.assertEquals(LoginPage.getSubAccountRoleName(), "amitqaMain - Admin1");
			    
	    	 	 System.out.println("Login in First Test Case");
			 
			 	}
			 
			 catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//System.out.println(e.printStackTrace());
					
			/*
			 * StringWriter outError = new StringWriter(); e.printStackTrace(new
			 * PrintWriter(outError)); String errorString = outError.toString();
			 */
					
					//System.out.println(errorString);
					
				}
		
		}
	 
		 @AfterClass
		 public void tearDown() {
			
			  driver.close();
			  //driver.quit();
			  System.out.println("Browser Closed Sucessfully");
		 }
	 
}
