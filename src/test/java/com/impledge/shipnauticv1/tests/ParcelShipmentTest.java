package com.impledge.shipnauticv1.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.impledge.shipnauticv1.pages.ContactPO;
import com.impledge.shipnauticv1.pages.FreightShipmentPO;
import com.impledge.shipnauticv1.pages.HomePO;
import com.impledge.shipnauticv1.pages.LoginPO;
import com.impledge.shipnauticv1.pages.OrderPO;
import com.impledge.shipnauticv1.pages.OrderTPShipmentPO;
import com.impledge.shipnauticv1.pages.ParcelShipmentPO;
import com.impledge.shipnauticv1.pages.ProductPO;
import com.impledge.shipnauticv1.utility.ReadingXLS;
import com.impledge.shipnauticv1.utility.XLSXUtility;

public class ParcelShipmentTest extends BaseTest {

		 private static WebDriver driver;
		 
		 String sUserName;
		 String sPassword;
		
		 LoginPO LoginPage;
		 HomePO HomePage;
		 OrderPO OrderPage;
		 OrderTPShipmentPO OrderTPShipmentPage;
		 ParcelShipmentPO ParcelShipmentPage;
		 FreightShipmentPO FreightShipmentPage;
		 
		 @BeforeClass
			public void setUp() {
			driver = getDriver();
				
			}


		   /*
		    * Test Method  : TestDomesticParcelShipment()
		    * Objective    : Domestic Shipment and Label genration
		    * Verification : Shipment Status by PreTransit
		    * Author 	   : Vinit Awasthi
		    * Creation Date: dd/03/2020
		    * Modification Date:dd/mm/yyyy 
		    */
				 
				     @Ignore 
			     	 @Test (priority =1)
					public void TestDomesticParcelShipmentviaData() {
					
			     		
			     	 String sSearchContactName;
			     	 String sServiceName;
		             String sPackageName;
		             
		             String sTotalValue,sCurrency, sSignature,sTotalWeight, sWeightUnit,sResidential, sInsure,sSaturdayDelivery,sAdditonalHandling,sMachineable,sTestlabel,sCR1,sCR1Value,sCR2,sCR2Value,sCR3,sCR3Value; 
					 
		             try {
		     			
		            	 LoginPage = new LoginPO(driver);
		   			  	HomePage = new HomePO(driver);
		   			  	OrderPage = new OrderPO(driver);
		   			  	ParcelShipmentPage =new ParcelShipmentPO(driver);
		   			  
		   			  	ReadingXLS.sFile = ReadingXLS.sTEST_DATA_FILE_PATH +  "demoWorkSheet.xlsx";
		   			  	sUserName=ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 2);
		   			  	sPassword = ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 3);

		   			  	test=extent.createTest("TestDomesticParcelShipmentviaData");
		   			  
		   			  	if (HomePage.isLoggedInLCC())
		   			  		test.log(Status.INFO, "Already logged in ");
		   			  	else
						  LoginPage.loginLCC(sUserName,sPassword);
				  
		              XLSXUtility.setExcelFileSheet("Shipments.xlsx","DomParclShipment");
		   			  
		      		   int iTotalRowCount = XLSXUtility.getTotalRowNumber()+1;
		      		   
		      		  System.out.println("Total Row in spreadsheet: "+iTotalRowCount);
		      	    	      		   
		      		  	for (int rownum = 1; rownum <iTotalRowCount; rownum ++ )
		      		  		{
		      		  			System.out.println("Reading data from xls for Login - Refer Row Number : " + rownum);
		                 	
		      		  			sSearchContactName = XLSXUtility.getCellData(rownum, 2);
		      		  			System.out.println("Contact Name"+sSearchContactName); 
		            		  
		      		  			sPackageName = XLSXUtility.getCellData(rownum, 3);
		      		  				
					      		sServiceName = 	XLSXUtility.getCellData(rownum, 4);	
					      		sTotalValue = 	XLSXUtility.getCellData(rownum, 5);
					      		sCurrency = 	XLSXUtility.getCellData(rownum, 6);
					      		sSignature = 	XLSXUtility.getCellData(rownum, 7);
					      		sTotalWeight = 	XLSXUtility.getCellData(rownum, 8);
					      		sWeightUnit = 	XLSXUtility.getCellData(rownum, 9);
					      		sResidential = 	XLSXUtility.getCellData(rownum, 10);
					      		sInsure = 	XLSXUtility.getCellData(rownum, 11);
					      		sSaturdayDelivery = 	XLSXUtility.getCellData(rownum, 12);
					      		sAdditonalHandling = 	XLSXUtility.getCellData(rownum, 13);
					      		sMachineable = 	XLSXUtility.getCellData(rownum, 14);
					      		sTestlabel = 	XLSXUtility.getCellData(rownum, 15);
					      		sCR1 = 	XLSXUtility.getCellData(rownum, 16);
					      		sCR1Value = 	XLSXUtility.getCellData(rownum, 17);
					      		sCR2 = 	XLSXUtility.getCellData(rownum, 18);
					      		sCR2Value = 	XLSXUtility.getCellData(rownum, 19);
					      		sCR3 = 	XLSXUtility.getCellData(rownum, 20);
					      		sCR3Value = 	XLSXUtility.getCellData(rownum, 21);			
					      		
					      	  //Fix Bug --- 1628 ( Need to Comment below line after fixing of 1628 bug
							 	  HomePage.clickHomeHeaderBtn();
							 	  
							 	  //   
		      		  			 HomePage.clickOrderHeaderBtn();
					             Thread.sleep(7000);
					             HomePage.clickCreateNewBtn();
					             OrderPage.selectSearchName(sSearchContactName);
								 OrderPage.clickShipToAddressSave();
								 ParcelShipmentPage.selectPackageType(sPackageName);
					             ParcelShipmentPage.setTotalShipmentValue(sTotalValue);
					             if (sSignature!= "" )
					            	 ParcelShipmentPage.selectSignature(sSignature);
					             ParcelShipmentPage.setTotalWeightValue(sTotalWeight);
					             ParcelShipmentPage.selectTestLabelToggle();
					             ParcelShipmentPage.clickCalcualteRate();
					             Thread.sleep(7000);
		
					             ParcelShipmentPage.selectCarrierServiceName(sServiceName);
					             
					             if (sServiceName.endsWith("(FEDEX)"))
					             	{
					            	
					            	 ParcelShipmentPage.selectRefFieldListBox(1, sCR1);
					            	 //System.out.println("sCR1 option text "+sCR1);
					            	 ParcelShipmentPage.setRefFieldValueOne(sCR1Value);
					            	 ParcelShipmentPage.selectRefFieldListBox(2, sCR2);
					            	 ParcelShipmentPage.setRefFieldValueTwo(sCR2Value);
					            	 ParcelShipmentPage.selectRefFieldListBox(3, sCR3);
					            	 ParcelShipmentPage.setRefFieldValueThree(sCR3Value);
					            	 
					             	}
					             
					             ParcelShipmentPage.clickShipForBtn();
					           
					             String x = driver.findElement(By.xpath("//app-shipment-track/mat-toolbar/span[1]")).getText();
					             System.out.println(x);
					             
					             Integer iTrackingIDIndex = x.indexOf(" - PreTransit");
					             
					             String sTrackingID = x.substring(0, iTrackingIDIndex);
					             
					             System.out.println("sTrackingID: "+sTrackingID);
					             
					             XLSXUtility.setCellData(sTrackingID, rownum, 22);
					             
					             test.log(Status.INFO,"Created Order's Order id: "+ OrderPage.getOrderID());
					             
					             Boolean actual = x.endsWith("- PreTransit");
					             
					             Boolean expected = true;
					             Assert.assertEquals(actual,expected);
					             test.log(Status.PASS, "Shipment is created with Service Name: " +sServiceName );
					             test.log(Status.INFO, "Shipment label is printed with tracking id: "+sTrackingID);
					             System.out.println("Shipment label printed");
										
		      		  		} //end of for loop
		             }
					catch (Exception e) {
						e.printStackTrace();
						test.log(Status.FAIL, "Shipment is not created");
					}
				}

			     	 
   /*
    * Test Method  : TestDomesticParcelShipment()
    * Objective    : Domestic Shipment and Label genration
    * Verification : Shipment Status by PreTransit
    * Author 	   : Vinit Awasthi
    * Creation Date: dd/03/2020
    * Modification Date:dd/mm/yyyy 
    */
		 
		     @Ignore
	     	 @Test (priority =3)
			public void TestDomesticParcelShipment() {
			
             String sServiceName="FEDEX_2_DAY (FEDEX)";
             String sPackageName="1 cubic feet (ft) 1 x 1 x 1";
             String sSearchContactName="Anugrah";
			 
			 try {
				
				  LoginPage = new LoginPO(driver);
				  HomePage = new HomePO(driver);
				  OrderPage = new OrderPO(driver);
				  ParcelShipmentPage =new ParcelShipmentPO(driver);
				  
				  
				  ReadingXLS.sFile = ReadingXLS.sTEST_DATA_FILE_PATH +  "demoWorkSheet.xlsx";
		   		  sUserName=ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 2);
				  sPassword = ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 3);
				  
				  if (HomePage.isLoggedInLCC())
				      test.log(Status.INFO, "Already logged in ");
				  else
					  LoginPage.loginLCC(sUserName,sPassword);
			 	 // LoginPage.loginLCC(sUserName,sPassword);
			    //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 	  
		          //OrderPage.clickOrderHeaderBtn();
		          HomePage.clickOrderHeaderBtn();
	              Thread.sleep(7000);
	              HomePage.clickCreateNewBtn();
	             //OrderPage.clickSourceCreateOrderBtn(); 
				 OrderPage.selectSearchName(sSearchContactName);
				 OrderPage.clickShipToAddressSave();
				 ParcelShipmentPage.selectPackageType(sPackageName);
	             ParcelShipmentPage.setTotalShipmentValue("10");
	             ParcelShipmentPage.setTotalWeightValue("1");
	             ParcelShipmentPage.selectTestLabelToggle();
	             ParcelShipmentPage.clickCalcualteRate();
	             Thread.sleep(7000);

	             ParcelShipmentPage.selectCarrierServiceName(sServiceName);
	             ParcelShipmentPage.clickShipForBtn();
	           
		             
	             String x = driver.findElement(By.xpath("//app-shipment-track/mat-toolbar/span[1]")).getText();
	             System.out.println(x);
	             
	             Boolean actual = x.endsWith("- PreTransit");
	             
	             Boolean expected = true;
	             Assert.assertEquals(actual,expected);
	             
	             System.out.println("Shipment label printed");
								
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}



	     	 
	     	  
	     	  @Test (priority =2)
	  		public void TestInternationalParcelShipmentviaData() {
	     		  
	             String sSearchContactName;
		     	 String sServiceName;
	             String sPackageName,sSearchedItem, sQuantity, sLicenseNo, sSerialNo;
	             
	             String sTotalValue,sCurrency, sSignature,sTotalWeight, sWeightUnit,sResidential, sInsure,sSaturdayDelivery,sAdditonalHandling,sMachineable,sTestlabel,sCR1,sCR1Value,sCR2,sCR2Value,sCR3,sCR3Value; 
				 
	  	
	             try {
	  			
	  			  LoginPage = new LoginPO(driver);
	  			  HomePage = new HomePO(driver);
	  			  OrderPage = new OrderPO(driver);
	  			  OrderTPShipmentPage = new OrderTPShipmentPO(driver); 
	  			  ParcelShipmentPage =new ParcelShipmentPO(driver);
	  			  
	  			  
	  			  ReadingXLS.sFile = ReadingXLS.sTEST_DATA_FILE_PATH +  "demoWorkSheet.xlsx";
	  			 sUserName=ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 2);
	  			  sPassword = ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 3);
	  			  
	  		 	if (HomePage.isLoggedInLCC())
				      test.log(Status.INFO, "Already logged in ");
				  else
					  LoginPage.loginLCC(sUserName,sPassword);
	  		 	
	  		  XLSXUtility.setExcelFileSheet("Shipments.xlsx","IntlParclShipment");
   			  
     		   int iTotalRowCount = XLSXUtility.getTotalRowNumber()+1;
     		   
     		  System.out.println("Total Row in spreadsheet: "+iTotalRowCount);
	  		      
	  		 	for (int rownum = 1; rownum <iTotalRowCount; rownum ++ )
  		  		{
  		  			System.out.println("Reading data from xls for Login - Refer Row Number : " + rownum);
             	
  		  			sSearchContactName = XLSXUtility.getCellData(rownum, 2);
  		  			System.out.println("Contact Name"+sSearchContactName); 
        		  
  		  			sSearchedItem= XLSXUtility.getCellData(rownum, 3);
  		  			sQuantity= XLSXUtility.getCellData(rownum, 4);
  		  			sLicenseNo = XLSXUtility.getCellData(rownum, 5);
  		  			sSerialNo = XLSXUtility.getCellData(rownum, 6);
  		  			
  		  			
  		  			
  		  			sPackageName = XLSXUtility.getCellData(rownum, 7);
  		  			sServiceName = 	XLSXUtility.getCellData(rownum, 8);	
		      		sTotalValue = 	XLSXUtility.getCellData(rownum, 9);
		      		sCurrency = 	XLSXUtility.getCellData(rownum, 10);
		      		sSignature = 	XLSXUtility.getCellData(rownum, 11);
		      		sTotalWeight = 	XLSXUtility.getCellData(rownum, 12);
		      		sWeightUnit = 	XLSXUtility.getCellData(rownum, 13);
		      		sResidential = 	XLSXUtility.getCellData(rownum, 14);
		      		sInsure = 	XLSXUtility.getCellData(rownum, 15);
		      		sSaturdayDelivery = 	XLSXUtility.getCellData(rownum, 16);
		      		sAdditonalHandling = 	XLSXUtility.getCellData(rownum, 17);
		      		sMachineable = 	XLSXUtility.getCellData(rownum, 18);
		      		sTestlabel = 	XLSXUtility.getCellData(rownum, 19);
		      		sCR1 = 	XLSXUtility.getCellData(rownum, 20);
		      		sCR1Value = 	XLSXUtility.getCellData(rownum, 21);
		      		sCR2 = 	XLSXUtility.getCellData(rownum, 22);
		      		sCR2Value = 	XLSXUtility.getCellData(rownum, 23);
		      		sCR3 = 	XLSXUtility.getCellData(rownum, 24);
		      		sCR3Value = 	XLSXUtility.getCellData(rownum, 25);			
		      		
		      		 //Fix Bug --- 1628 ( Need to Comment below line after fixing of 1628 bug
				 	  HomePage.clickHomeHeaderBtn();
				 	  
				 	  //   
		  			 HomePage.clickOrderHeaderBtn();
		             Thread.sleep(7000);
		             
		  			 //    HomePage.waitProgressBarComplete();
		            	 HomePage.clickCreateNewBtn();
			             OrderPage.selectSearchName(sSearchContactName);
						 OrderPage.clickShipToAddressSave();
				
						 WebDriverWait wait = new WebDriverWait(driver,20);
						 wait.until(ExpectedConditions.visibilityOfElementLocated(OrderPage.orderID));
						 
						 OrderPage.selectSearchedItem(sSearchedItem, sQuantity, sLicenseNo, sSerialNo);
						 
						 
						 ParcelShipmentPage.selectPackageType(sPackageName);
			             ParcelShipmentPage.setTotalShipmentValue(sTotalValue);
			             if (sSignature!= "" )
			            	 ParcelShipmentPage.selectSignature(sSignature);
			             ParcelShipmentPage.setTotalWeightValue(sTotalWeight);
			             ParcelShipmentPage.selectTestLabelToggle();
			             
			             ParcelShipmentPage.clickCustomDeclaration();
		  	            	 
		             
		             
		             Thread.sleep(10000);
	  	             ParcelShipmentPage.applyCustomDeclarationDlg();
	  	             
	  	             
	  	             Thread.sleep(17000);
		             
		             ParcelShipmentPage.selectCarrierServiceName(sServiceName);
		             
		             if (sServiceName.endsWith("(FEDEX)"))
		             	{
		            	
		            	 ParcelShipmentPage.selectRefFieldListBox(1, sCR1);
		            	 //System.out.println("sCR1 option text "+sCR1);
		            	 ParcelShipmentPage.setRefFieldValueOne(sCR1Value);
		            	 ParcelShipmentPage.selectRefFieldListBox(2, sCR2);
		            	 ParcelShipmentPage.setRefFieldValueTwo(sCR2Value);
		            	 ParcelShipmentPage.selectRefFieldListBox(3, sCR3);
		            	 ParcelShipmentPage.setRefFieldValueThree(sCR3Value);
		            	 
		             	}
		             
		             ParcelShipmentPage.clickShipForBtn();
		             
		             
		             String x = driver.findElement(By.xpath("//app-shipment-track/mat-toolbar/span[1]")).getText();
		             System.out.println(x);
		             
		             Integer iTrackingIDIndex = x.indexOf(" - PreTransit");
		             
		             String sTrackingID = x.substring(0, iTrackingIDIndex);
		             
		             System.out.println("sTrackingID: "+sTrackingID);
		             
		             XLSXUtility.setCellData(sTrackingID, rownum, 26);
		             
		             String sOrderId = String.valueOf(OrderPage.getOrderID()).substring(8, 12);
		             
		             XLSXUtility.setCellData(sOrderId, rownum, 27);
		             
		           
		             
		             Boolean actual = x.endsWith("- PreTransit");
		             
		             Boolean expected = true;
		             Assert.assertEquals(actual,expected);
		             test.log(Status.PASS, "Shipment is created with Service Name: " +sServiceName );
		             test.log(Status.INFO, "Shipment label is printed with tracking id: "+sTrackingID);
		             test.log(Status.INFO,"Created Order's Order id: "+ sOrderId);
		             System.out.println("Shipment label printed");
		             
		             
		           
  		  		}
									
	  		} 
	  		catch (Exception e) {
	  			e.printStackTrace();
	  		}
	  	}


	     	 @Ignore
	     	  @Test (priority =4)
	  		public void TestInternationalParcelShipment() {
	     		 String sServiceName="INTERNATIONAL_ECONOMY (FEDEX)";
	             String sPackageName="1 cubic feet (ft) 1 x 1 x 1";
	             String sSearchContactName="Canada";
	  	
	             try {
	  			
	  			  LoginPage = new LoginPO(driver);
	  			  HomePage = new HomePO(driver);
	  			  OrderPage = new OrderPO(driver);
	  			  OrderTPShipmentPage = new OrderTPShipmentPO(driver); 
	  			  ParcelShipmentPage =new ParcelShipmentPO(driver);
	  			  
	  			  
	  			  ReadingXLS.sFile = ReadingXLS.sTEST_DATA_FILE_PATH +  "demoWorkSheet.xlsx";
	  			 sUserName=ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 2);
	  			  sPassword = ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 3);
	  			  
	  		 	  //LoginPage.loginLCC(sUserName,sPassword);
	  		 	if (HomePage.isLoggedInLCC())
				      test.log(Status.INFO, "Already logged in ");
				  else
					  LoginPage.loginLCC(sUserName,sPassword);
	  		      
	  		 //	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  		 	  
//	  	         OrderPage.clickOrderHeaderBtn();
		          HomePage.clickOrderHeaderBtn();

	  		      HomePage.clickCreateNewBtn();

	                     
	              Thread.sleep(7000);
	              
	//              OrderPage.clickSourceCreateOrderBtn(); 
	  			 
	  		   	//International Ship to address
	              OrderPage.selectSearchName(sSearchContactName);
	  			
	  		      OrderPage.clickShipToAddressSave();
	              
			/*
		 String sOrderNo="1125"; OrderPage.selectOrderNo_InFirstPanel(sOrderNo);
			 */          
	  			Thread.sleep(10000);
	  			
	  			selectSearchedItem();
	  			
	  			
	  			
	  			//OrderPage.selectItemCheckBoxInSecondPanel();
	  			
	  			  ParcelShipmentPage.selectPackageType(sPackageName);
	  	       //      ParcelShipmentPage.setTotalShipmentValue("10");
	  	       //      ParcelShipmentPage.setTotalWeightValue("1");
	  	             ParcelShipmentPage.selectTestLabelToggle();
	  	             
	  	             ParcelShipmentPage.clickCustomDeclaration();
	  	             Thread.sleep(10000);
	  	             ParcelShipmentPage.applyCustomDeclarationDlg();
	  	             
	  	             
	  	             Thread.sleep(17000);

	  	             ParcelShipmentPage.selectCarrierServiceName(sServiceName);//("FEDEX_GROUND (FEDEX)"); //  INTERNATIONAL_ECONOMY (FEDEX) // INTERNATIONAL_PRIORITY (FEDEX) 
	  	             ParcelShipmentPage.clickShipForBtn();
	  	           //  System.out.println("Shipment label printed");
	  	             Thread.sleep(15000);
	  	             String x = driver.findElement(By.xpath("//app-shipment-track/mat-toolbar/span[1]")).getText();
	  	             System.out.println(x);
	  	             Boolean actual = x.endsWith("- PreTransit");
		             
		             Boolean expected = true;
		             Assert.assertEquals(actual,expected);
		             
		             System.out.println("Shipment label printed");
									
	  		} 
	  		catch (Exception e) {
	  			e.printStackTrace();
	  		}
	  	}

	     	  
	     	  public void selectSearchedItem() throws InterruptedException {
	 	    	OrderPage.clickSearchItem();
	 			Thread.sleep(10000);
	 			OrderPage.setSearchedItemText("Toy133");
	 			OrderPage.selectFirstRowItemTP();
	 			OrderPage.selectFirstItemCheckBoxTP();
	 			OrderPage.setQuantityItemText("2");
	 			OrderPage.setLicenseSymbolText("LS@34");
	 			OrderPage.setSerialNumberText("SN890");
	 			OrderPage.clickSaveSearchedItem();
	 			Thread.sleep(10000);

	 	    }
	     	  
	     	  
			@AfterClass
			 public void tearDown() {
				
				  driver.close();
				  System.out.println("Browser Closed Sucessfully");
			 }




}
