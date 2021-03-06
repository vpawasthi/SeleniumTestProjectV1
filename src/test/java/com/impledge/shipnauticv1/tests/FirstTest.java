package com.impledge.shipnauticv1.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.impledge.shipnauticv1.pages.HomePO;
import com.impledge.shipnauticv1.pages.LoginPO;
import com.impledge.shipnauticv1.utility.ReadingXLS;
import com.impledge.shipnauticv1.utility.XLSXUtility;

public class FirstTest extends BaseTest {
	
	 	private static WebDriver driver;
	 	
	 	LoginPO LoginPage;
	 	HomePO HomePage;

	 	
	 	
		@BeforeClass
		public void setUp() {
		driver = getDriver();
		System.out.println("Before Class method in First Test Class");
			
		}
		 
		@Test
		//@Ignore
	    public void LoginLCCApplication() {
			 String sUserName;
			 String sPassword;
		     
			 try {
				 
				 test=extent.createTest("Test1 - Login in LCC");
				 
			     LoginPage = new LoginPO(driver);
			     HomePage = new HomePO(driver);
				 
			     
			      ReadingXLS.sFile = ReadingXLS.sTEST_DATA_FILE_PATH +  "demoWorkSheet.xlsx";
			      
			      sUserName=ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 2);
			      sPassword = ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 3);
			
			 	 LoginPage.loginLCC(sUserName,sPassword);
			 	 
			 	 test.log(Status.PASS, "login passed");
			 	 Thread.sleep(20000);
			 	 
			 	 Assert.assertEquals(LoginPage.getSubAccountRoleName(), "amitqaMain - Admin");
			    
	    	 	 System.out.println("Login in First Test Case");
	              HomePage.LogOutApp();
	    	 	 
			 	}
			 
			 catch (Exception e) {
							e.printStackTrace();
						}
				}
	 
		//@Ignore
		@Test
	    public void LoginLCCApplicationMultiple() {
			 String sUserName=null;
			 String sPassword=null;
			 String sExpectedResult;
			 int iTotalRowCount;
			 int rownum;
		
		   LoginPage = new LoginPO(driver);
		   HomePage = new HomePO(driver);
		 
			 try {
			       
 
				   XLSXUtility.setExcelFileSheet("Test");
				  
				   iTotalRowCount= XLSXUtility.getTotalRowNumber()+1;
				   
					  System.out.println("Totoal Row in spreadsheet"+iTotalRowCount);
				   
                  for (rownum=1; rownum <iTotalRowCount; rownum ++ )
                  {
                     	  System.out.println("Reading data from xls for Login - Refer Row Number : " + rownum);
                	  
                		  sUserName=XLSXUtility.getCellData(rownum, 2);
                		  System.out.println(sUserName);
                		
                		  sPassword=XLSXUtility.getCellData(rownum, 3);
                		  System.out.println(sPassword);
                    	
                    	  sExpectedResult =XLSXUtility.getCellData(rownum, 4);
                		  System.out.println(sExpectedResult);
                		  
                		  test=extent.createTest("Test - Login in LCC using data from row number : "+rownum);	 
                		  LoginPage.loginLCC(sUserName,sPassword);
         			 	 
        			 	  test.log(Status.PASS, "login passed");
        			 	  
        			 	  Thread.sleep(20000);
        			 	 
        			 	 // Assert.assertEquals(LoginPage.getSubAccountRoleName(), "amitqaMain - Admin");
        			 	  try {
        			 		 Assert.assertEquals(LoginPage.getSubAccountRoleName(), sExpectedResult);

            			 	  XLSXUtility.setCellData("PASS", rownum, 5);
  
        			 	  }
 
        			 	  catch (Exception e ) {
        			 		  e.printStackTrace();
        			 		 XLSXUtility.setCellData("FAIL", rownum, 5);
        			 		  System.out.println("Exception occured ");
        			 	  }
        			 	  System.out.println("Login in Test Case : using data from row number : " + rownum);
        			 	  
                          HomePage.LogOutApp();                                 		  
                		  
                          Thread.sleep(10000);
                          System.out.println("Logout from LCC Application aftr using data from row number : "+rownum);
        			 	  
                	  }
                  
			      
			 	}
			 
			 catch (Exception e) {
							e.printStackTrace();

						}
				}
	 	
		
		@AfterClass
		 public void tearDown() {
			
			  driver.close();
			  //driver.quit();
			  System.out.println("Browser Closed Sucessfully");
		 }
	 
}
