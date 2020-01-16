package com.impledge.shipnauticv1.tests;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.impledge.shipnauticv1.pages.LoginPO;
import com.impledge.shipnauticv1.utility.ReadingXLS;

public class FirstTest2 extends BaseTest {
	
	
	 private static WebDriver driver;
	 
	 String sUserName;
	 String sPassword;
	
	 LoginPO LoginPage;
	 
	 @BeforeClass
		public void setUp() {
		driver = getDriver();
			
		}
		 
		@Test
	    public void LoginLCCApplication2() {
			
			 try {
				  test=extent.createTest("Test2");
				  LoginPage = new LoginPO(driver);
			 		
			      ReadingXLS.sFile = ReadingXLS.sTEST_DATA_FILE_PATH +  "demoWorkSheet.xlsx";
			 
			 
			      sUserName=ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 2);
			      sPassword = ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 3);
			
			 	 LoginPage.loginLCC(sUserName,sPassword);
			 	 
			 	 test.log(Status.PASS, "login passed");
			 	 Thread.sleep(20000);
			 	 
			 	 Assert.assertEquals(LoginPage.getSubAccountRoleName(), "amitqaMain - Admin");
			    
	    	 	 System.out.println("Login in First Test2 Case");
			 
				  
				  test.log(Status.PASS, "login passed2");
			 	}
			 
			 catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		
		@Test
	    public void LoginLCCApplication3() {
		     
			 try {
				 test=extent.createTest("Test3");
				 test.createNode("Test3- 01");
				 test.log(Status.FAIL, "login Failed 3");
				 test.fail("Fail");
				 
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
