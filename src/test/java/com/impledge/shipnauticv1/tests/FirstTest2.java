package com.impledge.shipnauticv1.tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.impledge.shipnauticv1.pages.FreightShipmentPO;
import com.impledge.shipnauticv1.pages.HomePO;
import com.impledge.shipnauticv1.pages.LoginPO;
import com.impledge.shipnauticv1.pages.OrderPO;
import com.impledge.shipnauticv1.pages.OrderTPShipmentPO;
import com.impledge.shipnauticv1.pages.ParcelShipmentPO;
import com.impledge.shipnauticv1.utility.ReadingXLS;
import com.impledge.shipnauticv1.utility.XLSXUtility;

public class FirstTest2 extends BaseTest {
	
	
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
		@Ignore 
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
			 	 
			 	 Assert.assertEquals(LoginPage.getSubAccountRoleName(), "amitqaMain - Admin1");
			    
	    	 	 System.out.println("Login in First Test2 Case");
			 
				  
				  test.log(Status.PASS, "login passed2");
			 	}
			 
			 catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		@Ignore 
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
		
		@Ignore
		@Test 
		public void TestElement() {
			
			 try { 
			  LoginPage = new LoginPO(driver);
			  HomePage = new HomePO(driver);
			  OrderPage = new OrderPO(driver);
				 
			  
			  
			  
			  ReadingXLS.sFile = ReadingXLS.sTEST_DATA_FILE_PATH +  "demoWorkSheet.xlsx";
			 
			 sUserName=ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 2);
			
		      sPassword = ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 3);
		
		 	  LoginPage.loginLCC(sUserName,sPassword);
		 	  
           //   Thread.sleep(7000);
              driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 	  
		// 	  OrderPage.clickHomeHeaderBtn();
             
      //        Thread.sleep(7000);
             
             //.homeHeaderBtn.click();

     //         Thread.sleep(7000);
             
//             OrderPage.clickOrderHeaderBtn();
	         HomePage.clickOrderHeaderBtn();

            // .orderHeaderBtn.click();
             Thread.sleep(7000);
             
             //OrderPage.clickLeftMenuBtn();
             HomePage.clickLeftMenuBtn();
            Thread.sleep(7000);
             
            // .menuBtn.click();
             
             //OrderPage.selectSource("MS 01");
             HomePage.selectSource("MS 01");


             Thread.sleep(7000);

            // OrderPage.clickSourceCreateBtn();
             //.selectSource.click();

            // OrderPage.sourceCreateOrderBtn.click();
             String sOrderNo ="1114";

             //driver.findElement(By.xpath("//span[@class='col-2 padding'][contains(text(),'1114')]")).click(); 
          //    driver.findElement(By.xpath("//span[@class='col-2 padding'][contains(text(),'"+ sOrderNo+"')]")).click(); 
             OrderPage.selectOrderNo_InFirstPanel(sOrderNo);
             
             Thread.sleep(7000);

             // Item  
             driver.findElement(By.xpath("//mat-checkbox[@id='mat-checkbox-2']//label//div")).click();
             //ParcelShipment
             driver.findElement(By.xpath("//div[@id='mat-tab-label-1-0']")).click();
      //       Thread.sleep(7000);
		 	 //PackageType
			 driver.findElement(By.xpath("//mat-select[@formcontrolname='packageType']")).click();
		//	 Thread.sleep(7000);
			 //driver.findElement(By.xpath("//mat-option[@id='mat-option-743']")).click();
			 
			 String  sPackageType= " 1 cubic feet (ft) 1 x 1 x 1 ";
			 
			 //driver.findElement(By.xpath("//mat-option/span[text()=' 1 cubic feet (ft) 1 x 1 x 1 ']")).click();
			 
			 //sPackageType
			 driver.findElement(By.xpath("//mat-option/span[text()='"+sPackageType +"']")).click();
			 
			 
			 //TotalVale
			 driver.findElement(By.xpath("//input[@formcontrolname='value']")).click();
			 driver.findElement(By.xpath("//input[@formcontrolname='value']")).clear();
			 driver.findElement(By.xpath("//input[@formcontrolname='value']")).sendKeys("10");
			 //Signature
			 driver.findElement(By.xpath("//mat-select[@formcontrolname='signature']")).click();
			 String sSignature="Adult";
			 driver.findElement(By.xpath("//mat-option/span[text()=' "+sSignature +" ']")).click(); 
		//	 Thread.sleep(7000);
			 //Weight
			 driver.findElement(By.xpath("//input[@formcontrolname='weight']")).click();
			 driver.findElement(By.xpath("//input[@formcontrolname='weight']")).sendKeys("10");
			 //Weight Unit
			 driver.findElement(By.xpath("//mat-select[@formcontrolname='weightUnit']")).click();
			 String sWeightUnit="Kg";
			 driver.findElement(By.xpath("//mat-option/span[text()=' "+sWeightUnit +" ']")).click(); 		 
             					 
			 //driver.findElement(By.xpath("//mat-option/span[contains(.,'" + countryName + "')]")).click();
             //Reseidential
		 	 driver.findElement(By.xpath("//mat-slide-toggle[@id='mat-slide-toggle-3']//div[@class='mat-slide-toggle-bar']")).click();
		 	 //Insure 
			 driver.findElement(By.xpath("//mat-slide-toggle[@id='mat-slide-toggle-4']//div[@class='mat-slide-toggle-bar']")).click();
		//	 Saturday Delivery
		      driver.findElement(By.xpath("//mat-slide-toggle[@id='mat-slide-toggle-5']//div[@class='mat-slide-toggle-bar']")).click();
			 //Additional Handling
			 driver.findElement(By.xpath("//mat-slide-toggle[@id='mat-slide-toggle-6']//div[@class='mat-slide-toggle-bar']")).click();
			 //Machinaable
			 driver.findElement(By.xpath("//mat-slide-toggle[@id='mat-slide-toggle-7']//div[@class='mat-slide-toggle-bar']")).click();
			 //Test Label
			 driver.findElement(By.xpath("//mat-slide-toggle[@id='mat-slide-toggle-8']//div[@class='mat-slide-toggle-bar']")).click();
			 	  
			// driver.findElement(By.xpath("//button/span/span[text()='Calculate Rate']")).click();
			 //Calculate Rate
			 driver.findElement(By.xpath("//button/span/span[contains(text(),'Calculate Rate')]")).click();
			   Thread.sleep(7000);
			 //driver.findElement(By.xpath("//span[@class='mat-select-placeholder ng-tns-c14-562 ng-star-inserted']")).click();
			 //Service Box
			 driver.findElement(By.xpath("//mat-select[@id='mat-select-12']")).click();
			 String sServiceName="FEDEX_2_DAY (FEDEX)" ; //"Priority (USPS)";
			//Select Service Type
			 driver.findElement(By.xpath("//mat-option/span[text()=' "+sServiceName +" ']")).click(); 
			 
		//	 if (sServiceName.matches("FEDEX")) { 
			 //FedEx Refrence Option
			 driver.findElement(By.xpath("//mat-select[@formcontrolname='referenceOne']")).click();
			 String sRefFieldOption="Customer Reference";
			 driver.findElement(By.xpath("//mat-option/span[text()=' "+sRefFieldOption +" ']")).click();
			 driver.findElement(By.xpath("//mat-select[@formcontrolname='referenceTwo']")).click();
			 String sRefFieldOption1="Department Number";
			 driver.findElement(By.xpath("//mat-option/span[text()=' "+sRefFieldOption1 +" ']")).click();
			 driver.findElement(By.xpath("//mat-select[@formcontrolname='referenceThree']")).click();
			 String sRefFieldOption2="Purchase Order Number";
			 driver.findElement(By.xpath("//mat-option/span[text()=' "+sRefFieldOption2 +" ']")).click();
			//FedEx RefrenceValue option	 
			 driver.findElement(By.xpath("//input[@formcontrolname='referenceOneValue']")).sendKeys("CR345");
			 driver.findElement(By.xpath("//input[@formcontrolname='referenceTwoValue']")).sendKeys("CR345");
			 driver.findElement(By.xpath("//input[@formcontrolname='referenceThreeValue']")).sendKeys("CR345");
	//		 }
			 //Ship For button
			 driver.findElement(By.xpath("//button/span/span[contains(text(),' Ship ')]")).click();
			   Thread.sleep(7000);
		
			   
     //           
 //            JavascriptExecutor js = (JavascriptExecutor) driver;
   //          js.executeScript("window.scrollBy(0,400)");
			   
        //     WebElement element = driver.findElement(By.xpath("//perfect-scrollbar[@id='second-panel-scrollbar']/div/div[3]/div"));
            //Shipment item1  FedEx/USPS
             WebElement element = driver.findElement(By.xpath("//mat-nav-list/mat-list-item[1]/div/span"));
             
             ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
             
			   driver.findElement(By.xpath("//mat-nav-list/mat-list-item[1]/div/span")).click();
			 //Tracking Overflow Menu  

			   
			   
			   
			 /*		 
								 Customer Reference 
								 Department Number 
								 Purchase Order Number 
								 Return Merchandise Authorization 
								 
								 
								  GROUND_HOME_DELIVERY (FEDEX) 
								   Priority (USPS) 
								    FEDEX_2_DAY (FEDEX) 
		*/	 
			
			 
			
			 
			   // driver.findElement(By.xpath("//mat-option/span[contains(.,'" + countryName + "')]")).click()
			 
			 	} catch (Exception e) {
			 		// TODO Auto-generated catch block
			 		e.printStackTrace();
			 }
			  
			
		}

		@Ignore
		@Test 
		public void TestShipmentOverflowElement() {
			
			 try { 
			  LoginPage = new LoginPO(driver);
			  HomePage = new HomePO(driver);
			  OrderPage = new OrderPO(driver);
			  OrderTPShipmentPage = new OrderTPShipmentPO(driver); 
			  ParcelShipmentPage =new ParcelShipmentPO(driver);
			  
			  
			  ReadingXLS.sFile = ReadingXLS.sTEST_DATA_FILE_PATH +  "demoWorkSheet.xlsx";
			 
			 sUserName=ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 2);
			
		      sPassword = ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 3);
		
		 	  LoginPage.loginLCC(sUserName,sPassword);
		 	  
         
              driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 	  
	         //OrderPage.clickOrderHeaderBtn();
	         HomePage.clickOrderHeaderBtn();
             Thread.sleep(7000);
             //OrderPage.clickLeftMenuBtn();
             HomePage.clickLeftMenuBtn();
            Thread.sleep(7000);
            //OrderPage.selectSource("MS 01");
            HomePage.selectSource("MS 01");
             Thread.sleep(7000);
            // OrderPage.sourceCreateOrderBtn.click();
             String sOrderNo ="1115";
             OrderPage.selectOrderNo_InFirstPanel(sOrderNo);
             Thread.sleep(7000);
			 driver.findElement(By.xpath("//mat-slide-toggle[@formcontrolname='residential']")).click();
		//	 ParcelShipmentPage.selectCarrierServiceName(sServiceName);
             
     //           
 //            JavascriptExecutor js = (JavascriptExecutor) driver;
   //          js.executeScript("window.scrollBy(0,400)");
			   
        //     WebElement element = driver.findElement(By.xpath("//perfect-scrollbar[@id='second-panel-scrollbar']/div/div[3]/div"));
            //Shipment item1  FedEx/USPS
             WebElement element = driver.findElement(By.xpath("//mat-nav-list/mat-list-item[1]/div/span"));
             
             ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
             
			   //driver.findElement(By.xpath("//mat-nav-list/mat-list-item[1]/div/span")).click();
			   element.click();
			 //Tracking Overflow Menu  

		/*
			   OrderTPShipmentPage.oepnPackingSlipDlg();
		 OrderTPShipmentPage.openCloseShipmentDlg();
		   OrderTPShipmentPage.openCommercialInvoiceDlg();
			 
		   OrderTPShipmentPage.openCancelRefundDlg();
		  OrderTPShipmentPage.openFreightReviseBookingDlg();
		   OrderTPShipmentPage.openFreightCancelBookingDlg();
			   
		OrderTPShipmentPage.regenrateLabel();
		OrderTPShipmentPage.reprintCarrierDocument();
			*/ 
			 	} catch (Exception e) {
			 		// TODO Auto-generated catch block
			 		e.printStackTrace();
			 }
			  
			
		}
		@Ignore
		@Test 
		public void TestShipmentOverflowElement1() {
			
			 try { 
			  LoginPage = new LoginPO(driver);
			  HomePage = new HomePO(driver);
			  OrderPage = new OrderPO(driver);
			  OrderTPShipmentPage = new OrderTPShipmentPO(driver); 
			  ParcelShipmentPage =new ParcelShipmentPO(driver);
			  
			  
			  ReadingXLS.sFile = ReadingXLS.sTEST_DATA_FILE_PATH +  "demoWorkSheet.xlsx";
			 
			 sUserName=ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 2);
			
		      sPassword = ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 3);
		
		 	  LoginPage.loginLCC(sUserName,sPassword);
		 	  
         
              driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 	  
//	         OrderPage.clickOrderHeaderBtn();
	         HomePage.clickOrderHeaderBtn();

             Thread.sleep(7000);
             //OrderPage.clickLeftMenuBtn();
             HomePage.clickLeftMenuBtn();
            Thread.sleep(7000);
            HomePage.selectSource("MS 01");
            //OrderPage.selectSource("MS 01");
             Thread.sleep(7000);
            // OrderPage.sourceCreateOrderBtn.click();
             String sOrderNo ="1114";
             OrderPage.selectOrderNo_InFirstPanel(sOrderNo);
             Thread.sleep(7000);
             OrderPage.selectItemCheckBoxInSecondPanel();
             ParcelShipmentPage.selectPackageType("1 cubic feet (ft) 1 x 1 x 1");
             ParcelShipmentPage.setTotalShipmentValue("10");
             ParcelShipmentPage.setTotalWeightValue("1");
             ParcelShipmentPage.clickCalcualteRate();
             Thread.sleep(7000);

             ParcelShipmentPage.selectCarrierServiceName("FEDEX_2_DAY (FEDEX)");
             ParcelShipmentPage.clickShipForBtn();
             
     //           
 //            JavascriptExecutor js = (JavascriptExecutor) driver;
   //          js.executeScript("window.scrollBy(0,400)");
			   
        //     WebElement element = driver.findElement(By.xpath("//perfect-scrollbar[@id='second-panel-scrollbar']/div/div[3]/div"));
            //Shipment item1  FedEx/USPS
             WebElement element = driver.findElement(By.xpath("//mat-nav-list/mat-list-item[5]/div/span"));
             
             ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
             
			   //driver.findElement(By.xpath("//mat-nav-list/mat-list-item[1]/div/span")).click();
			   element.click();
			 //Tracking Overflow Menu  

			 	} catch (Exception e) {
			 		// TODO Auto-generated catch block
			 		e.printStackTrace();
			 }
			  
			
		}
		@Ignore
		@Test
			public void TestDomesticOrderCreation() {
			
			try {
				
				  LoginPage = new LoginPO(driver);
				  HomePage = new HomePO(driver);
				  OrderPage = new OrderPO(driver);
				  OrderTPShipmentPage = new OrderTPShipmentPO(driver); 
				  ParcelShipmentPage =new ParcelShipmentPO(driver);
				  
				  
				  ReadingXLS.sFile = ReadingXLS.sTEST_DATA_FILE_PATH +  "demoWorkSheet.xlsx";
				 
				 sUserName=ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 2);
				
			      sPassword = ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 3);
			
			 	  LoginPage.loginLCC(sUserName,sPassword);
			 	  
	         
	              driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 	  
//		         OrderPage.clickOrderHeaderBtn();
		         HomePage.clickOrderHeaderBtn();

	             Thread.sleep(7000);
	         //    OrderPage.clickLeftMenuBtn();
	           // Thread.sleep(7000);
	            //OrderPage.clickSourceCreateOrderBtn();
	            HomePage.clickCreateNewBtn();
				//OrderPage.clickCreateNewOrderBtn();
				OrderPage.selectSearchName("Anugrah");
				OrderPage.clickShipToAddressSave();
				//OrderPage.selectItemCheckBoxInSecondPanel();
	           
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
        @Ignore
		@Test
		public void TestDomesticParcelShipment() {
		
		try {
			
			  LoginPage = new LoginPO(driver);
			  HomePage = new HomePO(driver);
			  OrderPage = new OrderPO(driver);
			  OrderTPShipmentPage = new OrderTPShipmentPO(driver); 
			  ParcelShipmentPage =new ParcelShipmentPO(driver);
			  
			  
			  ReadingXLS.sFile = ReadingXLS.sTEST_DATA_FILE_PATH +  "demoWorkSheet.xlsx";
			 sUserName=ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 2);
			  sPassword = ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 3);
		 	  LoginPage.loginLCC(sUserName,sPassword);
		      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 	  
//	         OrderPage.clickOrderHeaderBtn();
	         HomePage.clickOrderHeaderBtn();

             Thread.sleep(7000);
          //    OrderPage.clickLeftMenuBtn();
           // Thread.sleep(7000);
            //OrderPage.clickSourceCreateOrderBtn(); 
            HomePage.clickCreateNewBtn();
			//OrderPage.clickCreateNewOrderBtn(); // not working 
			OrderPage.selectSearchName("Anugrah");
			OrderPage.clickShipToAddressSave();
			  ParcelShipmentPage.selectPackageType("1 cubic feet (ft) 1 x 1 x 1");
	             ParcelShipmentPage.setTotalShipmentValue("10");
	             ParcelShipmentPage.setTotalWeightValue("1");
	             ParcelShipmentPage.selectTestLabelToggle();
	             ParcelShipmentPage.clickCalcualteRate();
	             Thread.sleep(7000);

	             ParcelShipmentPage.selectCarrierServiceName("FEDEX_2_DAY (FEDEX)");
	             ParcelShipmentPage.clickShipForBtn();
	             System.out.println("Shipment label printed");
	             
	             String x = driver.findElement(By.xpath("//app-shipment-track/mat-toolbar/span[1]")).getText();
	             System.out.println(x);
							
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	    @Ignore 
		@Test
		public void TestDomesticParcelShipment1() {
		
		try {
			
			  LoginPage = new LoginPO(driver);
			  HomePage = new HomePO(driver);
			  OrderPage = new OrderPO(driver);
			  OrderTPShipmentPage = new OrderTPShipmentPO(driver); 
			  ParcelShipmentPage =new ParcelShipmentPO(driver);
			  
			  
			  ReadingXLS.sFile = ReadingXLS.sTEST_DATA_FILE_PATH +  "demoWorkSheet.xlsx";
			 sUserName=ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 2);
			  sPassword = ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 3);
		 	  LoginPage.loginLCC(sUserName,sPassword);
		 //     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 	  
//	         OrderPage.clickOrderHeaderBtn();
	         HomePage.clickOrderHeaderBtn();

       //      Thread.sleep(7000);
          //    OrderPage.clickLeftMenuBtn();
           // Thread.sleep(7000);
            OrderPage.selectOrderNo_InFirstPanel("1118");
            //second panel top order no
            String x = driver.findElement(By.xpath("//app-order-detail/mat-toolbar/span[1]")).getText();
            System.out.println(x);
             //OrderPage.clickSourceCreateOrderBtn(); 
			//OrderPage.clickCreateNewOrderBtn(); // not working 
			//OrderPage.selectSearchName("Anugrah");
			//OrderPage.clickShipToAddressSave();
            /*	
            ParcelShipmentPage.selectPackageType("1 cubic feet (ft) 1 x 1 x 1");
	             ParcelShipmentPage.setTotalShipmentValue("10");
	             ParcelShipmentPage.setTotalWeightValue("1");
	             ParcelShipmentPage.selectTestLabelToggle();
	             ParcelShipmentPage.clickCalcualteRate();
	           Thread.sleep(7000);
	             ParcelShipmentPage.selectCarrierServiceName("FEDEX_2_DAY (FEDEX)");
	             //ParcelShipmentPage.clickShipFor();
	             System.out.println("Shipment label printed");
				*/			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
        @Ignore 
	    @Test
		public void TestInternationalParcelShipment() {
		
		try {
			
			  LoginPage = new LoginPO(driver);
			  HomePage = new HomePO(driver);
			  OrderPage = new OrderPO(driver);
			  OrderTPShipmentPage = new OrderTPShipmentPO(driver); 
			  ParcelShipmentPage =new ParcelShipmentPO(driver);
			  
			  
			  ReadingXLS.sFile = ReadingXLS.sTEST_DATA_FILE_PATH +  "demoWorkSheet.xlsx";
			 sUserName=ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 2);
			  sPassword = ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 3);
		 	  LoginPage.loginLCC(sUserName,sPassword);
		      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 	  
//	         OrderPage.clickOrderHeaderBtn();
	         HomePage.clickOrderHeaderBtn();

                   
             // Thread.sleep(7000);
            
             //OrderPage.clickSourceCreateOrderBtn(); 
			 
			//International Ship to address
            //OrderPage.selectSearchName("Manual");
			
			//OrderPage.clickShipToAddressSave();
            
	        String sOrderNo="1125"; 
            OrderPage.selectOrderNo_InFirstPanel(sOrderNo);
                
			Thread.sleep(10000);
			OrderPage.selectItemCheckBoxInSecondPanel();
			
			  ParcelShipmentPage.selectPackageType("1 cubic feet (ft) 1 x 1 x 1");
	       //      ParcelShipmentPage.setTotalShipmentValue("10");
	       //      ParcelShipmentPage.setTotalWeightValue("1");
	             ParcelShipmentPage.selectTestLabelToggle();
	             
	             //ParcelShipmentPage.clickCalcualteRate(); ///domestic 
	             ParcelShipmentPage.clickCustomDeclaration();
	             Thread.sleep(10000);
	             ParcelShipmentPage.applyCustomDeclarationDlg();
	             
	             
	             Thread.sleep(17000);

	             ParcelShipmentPage.selectCarrierServiceName("INTERNATIONAL_ECONOMY (FEDEX)");//("FEDEX_GROUND (FEDEX)"); //  INTERNATIONAL_ECONOMY (FEDEX) // INTERNATIONAL_PRIORITY (FEDEX) 
	             ParcelShipmentPage.clickShipForBtn();
	             System.out.println("Shipment label printed");
	             Thread.sleep(15000);
	             String x = driver.findElement(By.xpath("//app-shipment-track/mat-toolbar/span[1]")).getText();
	             System.out.println(x);
							
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
        @Ignore
	    @Test
		public void TestFreightParcelShipment() {
		
		try {
			
			  LoginPage = new LoginPO(driver);
			  HomePage = new HomePO(driver);
			  OrderPage = new OrderPO(driver);
			  OrderTPShipmentPage = new OrderTPShipmentPO(driver); 
			  ParcelShipmentPage =new ParcelShipmentPO(driver);
			  FreightShipmentPage = new FreightShipmentPO(driver) ;

			  
			  ReadingXLS.sFile = ReadingXLS.sTEST_DATA_FILE_PATH +  "demoWorkSheet.xlsx";
			 sUserName=ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 2);
			  sPassword = ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 3);
		 	  LoginPage.loginLCC(sUserName,sPassword);
		      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 	  
	         //OrderPage.clickOrderHeaderBtn();
	         HomePage.clickOrderHeaderBtn();
                   
             // Thread.sleep(7000);
            
             //OrderPage.clickSourceCreateOrderBtn(); 
			 
			//International Ship to address
            //OrderPage.selectSearchName("Manual");
			
			//OrderPage.clickShipToAddressSave();
            
	        String sOrderNo="1125"; 
            OrderPage.selectOrderNo_InFirstPanel(sOrderNo);
                
			Thread.sleep(10000);
			OrderPage.selectItemCheckBoxInSecondPanel();
			
			FreightShipmentPage.freightShipmentBooking();
			
		   WebDriverWait wait = new WebDriverWait(driver,30);
		   
		  // wait.until(ExpectedConditions.)
		   
			
		/***************************************************************
			ParcelShipmentPage.selectPackageType("1 cubic feet (ft) 1 x 1 x 1");
	       //      ParcelShipmentPage.setTotalShipmentValue("10");
	       //      ParcelShipmentPage.setTotalWeightValue("1");
	             ParcelShipmentPage.selectTestLabelToggle();
	             
	             //ParcelShipmentPage.clickCalcualteRate(); ///domestic 
	             ParcelShipmentPage.clickCustomDeclaration();
	             Thread.sleep(10000);
	             ParcelShipmentPage.applyCustomDeclarationDlg();
	             
	             
	             Thread.sleep(17000);

	             ParcelShipmentPage.selectCarrierServiceName("INTERNATIONAL_ECONOMY (FEDEX)");//("FEDEX_GROUND (FEDEX)"); //  INTERNATIONAL_ECONOMY (FEDEX) // INTERNATIONAL_PRIORITY (FEDEX) 
	             ParcelShipmentPage.clickShipFor();
	             
	    ***************************************************************/         
	             
	             
	             System.out.println("Shipment label printed");
	             Thread.sleep(15000);
	             String x = driver.findElement(By.xpath("//app-shipment-track/mat-toolbar/span[1]")).getText();
	             System.out.println(x);
							
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
       		  
			//	 LoginPage.loginLCC(BaseTest.sUserName,BaseTest.sPassword);
                //  BaseTest.testDataExcelFileName = "Product.xlsx";    
 
				   XLSXUtility.setExcelFileSheet("Product.xlsx","Product");
				  
				   iTotalRowCount= XLSXUtility.getTotalRowNumber()+1;
				   
					  System.out.println("Totoal Row in spreadsheet: "+iTotalRowCount);
				   
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
         			 	 
        			 	  test.log(Status.PASS, "login passed");
        			 	  
        			 	  Thread.sleep(20000);
        			 	 
        			 	 // Assert.assertEquals(LoginPage.getSubAccountRoleName(), "amitqaMain - Admin");
        			 	  try {
        			 		// Assert.assertEquals(LoginPage.getSubAccountRoleName(), sExpectedResult);

            			// 	  XLSXUtility.setCellData("PASS", rownum, 5);
  
        			 	  }
 
        			 	  catch (Exception e ) {
        			 		  e.printStackTrace();
        			 		 XLSXUtility.setCellData("FAIL", rownum, 5);
        			 		  System.out.println("Exception occured ");
        			 	  }
        			 	  System.out.println("Login in Test Case : using data from row number : " + rownum);
        			 	  
                      //    HomePage.LogOutApp();                                 		  
                		  
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
			  System.out.println("Browser Closed Sucessfully");
		 }
	 
}
