package com.impledge.shipnauticv1.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.impledge.shipnauticv1.pages.HomePO;
import com.impledge.shipnauticv1.pages.LoginPO;
import com.impledge.shipnauticv1.pages.OrderPO;
import com.impledge.shipnauticv1.pages.OrderTPShipmentPO;
import com.impledge.shipnauticv1.pages.ParcelShipmentPO;
import com.impledge.shipnauticv1.utility.ReadingXLS;
import com.impledge.shipnauticv1.utility.XLSXUtility;

public class OrderTest extends BaseTest {

		 private static WebDriver driver;
		 
		 String sUserName;
		 String sPassword;
		
		 LoginPO LoginPage;
		 HomePO HomePage;
		 OrderPO OrderPage;
		 OrderTPShipmentPO OrderTPShipmentPage;
		 ParcelShipmentPO ParcelShipmentPage;
		
		 
		 @BeforeClass
			public void setUp() {
			driver = getDriver();
				
			}

   /*
    * Test Method  : TestDomesticOrderCreation()
    * Objective    : Domestic Order generation
    * Verification : Shipment Status by PreTransit
    * Author 	   : Vinit Awasthi
    * Creation Date: 12/03/2020
    * Modification Date:dd/mm/yyyy 
    */
		 
		 
		     
	     	 @Test (priority=1)
			public void TestDomesticOrderCreation() {
			
         //    String sServiceName="FEDEX_2_DAY (FEDEX)";
        //     String sPackageName="1 cubic feet (ft) 1 x 1 x 1";
             String sSearchContactName;
			 
			 try {
				
				  LoginPage = new LoginPO(driver);
				  HomePage = new HomePO(driver);
				  OrderPage = new OrderPO(driver);
				  ParcelShipmentPage =new ParcelShipmentPO(driver);
				  
				  
				  ReadingXLS.sFile = ReadingXLS.sTEST_DATA_FILE_PATH +  "demoWorkSheet.xlsx";
		   		  sUserName=ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 2);
				  sPassword = ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 3);
			 	  
				  test=extent.createTest("TestDomesticOrderCreation");
				  
				  
			 	  if (HomePage.isLoggedInLCC())
				      test.log(Status.INFO, "Already logged in ");
				  else
					  LoginPage.loginLCC(sUserName,sPassword);

			 	  HomePage.clickOrderHeaderBtn();
	              Thread.sleep(7000);
	              HomePage.clickCreateNewBtn();
 
	              XLSXUtility.setExcelFileSheet("Shipments.xlsx","DomesticOrder");
				  
	   		      int iTotalRowCount = XLSXUtility.getTotalRowNumber()+1;
	   		   
	   			  System.out.println("Totoal Row in spreadsheet: "+iTotalRowCount);

	   		   
	           for (int rownum = 1; rownum <iTotalRowCount; rownum ++ )
	           {
	              	System.out.println("Reading data from xls for Login - Refer Row Number : " + rownum);
	              	
	              	sSearchContactName = XLSXUtility.getCellData(rownum, 2);
	         		System.out.println("Searched Ship to Contact Name: "+sSearchContactName);
	         		
	         		OrderPage.selectSearchName(sSearchContactName);
					OrderPage.clickShipToAddressSave();
					
					test.log(Status.INFO,"Created Order's Order id: "+ OrderPage.getOrderID());
					
					Boolean actual = ParcelShipmentPage.isParcelShipmentTab();
					
					if (actual==true) {
					 test.log(Status.PASS,"Domestic Order is Created"); 
	   		        }
					else
					{
						 test.log(Status.FAIL,"Domestic Order is not Created");
						
					}
					
	           }
	              
	              
								
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}



	     	 
	     	   
	     	  @Test (priority=2)
	  		public void TestInternationalOrderCreation() {
	     	//	 String sServiceName="INTERNATIONAL_ECONOMY (FEDEX)";
	       //      String sPackageName="1 cubic feet (ft) 1 x 1 x 1";
	             String sSearchContactName;
	  	
	             try {
	 				
					  LoginPage = new LoginPO(driver);
					  HomePage = new HomePO(driver);
					  OrderPage = new OrderPO(driver);
					  ParcelShipmentPage =new ParcelShipmentPO(driver);
					  
					  
					  ReadingXLS.sFile = ReadingXLS.sTEST_DATA_FILE_PATH +  "demoWorkSheet.xlsx";
			   		  sUserName=ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 2);
					  sPassword = ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 3);
				 	  
					  test=extent.createTest("TestInternationalOrderCreation");
					  
					  
				 	  if (HomePage.isLoggedInLCC())
					      test.log(Status.INFO, "Already logged in ");
					  else
						  LoginPage.loginLCC(sUserName,sPassword);

				 	  //Fix Bug --- 1628 ( Need to Comment below line after fixing of 1628 bug
				 	  HomePage.clickHomeHeaderBtn();
				 	  
				 	  //   
				 	  HomePage.clickOrderHeaderBtn();
		              Thread.sleep(7000);
		              HomePage.clickCreateNewBtn();
	 
		              XLSXUtility.setExcelFileSheet("Shipments.xlsx","IntlOrder");
					  
		   		      int iTotalRowCount = XLSXUtility.getTotalRowNumber()+1;
		   		   
		   			  System.out.println("Totoal Row in spreadsheet: "+iTotalRowCount);

		   		   
		           for (int rownum = 1; rownum <iTotalRowCount; rownum ++ )
		           {
		              	System.out.println("Reading data from xls for Login - Refer Row Number : " + rownum);
		              	
		              	sSearchContactName = XLSXUtility.getCellData(rownum, 2);
		         		System.out.println("Searched Ship to Contact Name: "+sSearchContactName);
		         		
		         		OrderPage.selectSearchName(sSearchContactName);
						OrderPage.clickShipToAddressSave();
						
						test.log(Status.INFO,"Created Order's Order id: "+ OrderPage.getOrderID());
						
						
						Boolean actual = OrderPage.isNewProductinOrderLabel();
						
						if (actual==true) {
						 test.log(Status.PASS,"International Order is Created"); 
		   		        }
						else
						{
							 test.log(Status.FAIL,"International Order is not Created");
							
						}
						
		           }
		              
		              
									
	  		} 
	  		catch (Exception e) {
	  			e.printStackTrace();
	  		}
	  	}

	     
	     	  
			@AfterClass
			 public void tearDown() {
				
				  driver.close();
				  System.out.println("Browser Closed Sucessfully");
			 }




}
