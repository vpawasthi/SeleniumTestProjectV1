package com.impledge.shipnauticv1.tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.impledge.shipnauticv1.pages.ContactPO;
import com.impledge.shipnauticv1.pages.HomePO;
import com.impledge.shipnauticv1.pages.LoginPO;
import com.impledge.shipnauticv1.pages.ProductPO;
import com.impledge.shipnauticv1.utility.ReadingXLS;

public class ContactTest extends BaseTest {
 private static WebDriver driver;
	 
	 String sUserName;
	 String sPassword;
	
	 LoginPO LoginPage;
	 HomePO HomePage;
	 ContactPO ContactPage;
	 
	 ProductPO ProductPage;
	 
	 @BeforeClass
		public void setUp() {
		driver = getDriver();
			
		}
	 @Ignore
	 @Test(priority=1)
		public void TestCreateContactOnly() {
		
		try {
			
			  LoginPage = new LoginPO(driver);
			  HomePage = new HomePO(driver);
			  ProductPage = new ProductPO(driver);
			  ContactPage = new ContactPO(driver);
			  
			  ReadingXLS.sFile = ReadingXLS.sTEST_DATA_FILE_PATH +  "demoWorkSheet.xlsx";
			  sUserName=ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 2);
			  sPassword = ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 3);

			  test=extent.createTest("TestCreateContactOnly");
			  
			  //LoginPage.loginLCC(sUserName,sPassword);
			  
			  LoginPage.loginLCC(BaseTest.sUserName,BaseTest.sPassword);
		      
			  HomePage.clickContactHeaderBtn();
			  HomePage.clickCreateNewBtn();
			  ContactPage.bfCreateContact("Automation Contact", "EIN", "EIN1234", "Automation Contact Description of contact details");

			  String sActualContactName = ContactPage.getContactNameSp();
		      System.out.println(sActualContactName);

		      String sExpectedResult = "Automation Contact"; 
		      
		      if (sActualContactName.equals(sExpectedResult)) {
		           test.log(Status.PASS,"Contact is Created without Address");
		           test.log(Status.INFO,"Contact Name is : "+sActualContactName);
		      }
		      else
		      {
		    	  test.log(Status.FAIL, "Contact is not created without Address");
		    	  test.log(Status.FAIL, "Actual Contact Name: "+sActualContactName+"Expected Contact Name: "+sExpectedResult);
		      }
					
		} 
		catch (Exception e) {
			e.printStackTrace();
	    	  test.log(Status.ERROR, "Contact is not created without Address");  
		}
	}

	 @Ignore
	 @Test(priority=2)
		public void TestCreateContactwithAddress() {
		
		try {
			
			  LoginPage = new LoginPO(driver);
			  HomePage = new HomePO(driver);
			  ProductPage = new ProductPO(driver);
			  ContactPage = new ContactPO(driver);
			  
			  ReadingXLS.sFile = ReadingXLS.sTEST_DATA_FILE_PATH +  "demoWorkSheet.xlsx";
			  sUserName=ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 2);
			  sPassword = ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 3);

			  test=extent.createTest("TestCreateContactwithAddress");
			  
		 //   LoginPage.loginLCC(sUserName,sPassword);
		      
			  HomePage.clickContactHeaderBtn();
			  HomePage.clickCreateNewBtn();
			  ContactPage.bfCreateContact("Automation Contact1", "EIN", "EIN1234", "Automation Contact Description of contact details");

			  String sActualContactName = ContactPage.getContactNameSp();
		      System.out.println(sActualContactName);
      
		      ContactPage.bfCreateShipToAddressInContactwithDefaultListValues("IN","Buiilding 123, Green Boulward", "Sector -62", "Noida", "Gautam buddha Nagar", "UP", "20130", "Bharat", "Impledge Noida", "9873226508", "", "vinit.awasthi@impledge.com", "Address NOtes", "TRUE");
		      
		      String sActualAddressName = ContactPage.getFirstContactAddressSp();
			  System.out.println(sActualAddressName);
			  		      
			  
		      if (sActualContactName.equals("Automation Contact1"))
		           test.log(Status.PASS,"Contact is Created without Address");
		      else
		    	  test.log(Status.FAIL, "Contact is not created without Address");  
		      
		      if (sActualAddressName.contentEquals("Buiilding 123, Green Boulward, Gautam buddha Nagar, UP, IN, 201030"))
		           test.log(Status.PASS,"Contact is Created without Address");
		      else
		    	  test.log(Status.FAIL, "Contact is not created without Address");  
		      
	          
					
		} 
		catch (Exception e) {
			e.printStackTrace();
	    	  test.log(Status.FAIL, "Contact is not created without Address");  
		}
	}
	 
	 @Ignore
	 @Test(priority=3)
		public void TestCreateAddressonExistingContact() {
		
		try {
			
			  LoginPage = new LoginPO(driver);
			  HomePage = new HomePO(driver);
			  ProductPage = new ProductPO(driver);
			  ContactPage = new ContactPO(driver);
			  
			  ReadingXLS.sFile = ReadingXLS.sTEST_DATA_FILE_PATH +  "demoWorkSheet.xlsx";
			  sUserName=ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 2);
			  sPassword = ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 3);

			  test=extent.createTest("TestCreateAddressonExistingContact");
			  
			//  LoginPage.loginLCC(sUserName,sPassword);
		      
			  HomePage.clickContactHeaderBtn();
			  HomePage.clickCreateNewBtn();
			  ContactPage.bfCreateContact("Automation Contact03", "EIN", "EIN1234", "Automation Contact Description of contact details");

			  String sActualContactName = ContactPage.getContactNameSp();
		      System.out.println(sActualContactName);

		      
		      if (sActualContactName.equals("Automation Contact03"))
		           test.log(Status.PASS,"Contact is Created without Address");
		      else
		    	  test.log(Status.FAIL, "Contact is not created without Address");
		      
		      
		      ContactPage.selectContact_InListFP("Automation Contact03");
		      
		      ContactPage.clickAddNewAddressBtn();
		      
		      ContactPage.bfCreateShipToAddressInContactwithDefaultListValues("IN","Building 123, Green Boulward", "Sector -62", "Noida", "Gautam buddha Nagar", "UP", "20130", "Bharat", "Impledge Noida", "9873226508", "", "vinit.awasthi@impledge.com", "Address NOtes", "TRUE");

		      
			
		      
		      String sActualAddressName = ContactPage.getFirstContactAddressSp();
		 			  System.out.println(sActualAddressName);
		 			  
		 	  String sExpectedAddress = "Building 123, Green Boulward, Gautam buddha Nagar, UP, IN, 201030";		  
		 			   if (sActualAddressName.contentEquals(sExpectedAddress)) {
				           test.log(Status.PASS,"Contact is Created with Address");
		 			       test.log(Status.INFO,"Contact is Created with Actual Address:"+sActualAddressName);
		 			       }
				      else
				    	  {
					    	  test.log(Status.FAIL, "Contact is not created with Address");
			 		     	  test.log(Status.INFO,"Actual Address : "+sActualAddressName+"Expected Address : "+sExpectedAddress );
			 		       } 
		          
					
		} 
		catch (Exception e) {
			e.printStackTrace();
	    	  test.log(Status.ERROR, "Contact is not created with Address");  
		}
	}
	 
	 
	 @Ignore
	 @Test(priority=4)
		public void TestCreateAddressonShipFromExistingContact() {
		
		try {
			
			  LoginPage = new LoginPO(driver);
			  HomePage = new HomePO(driver);
			  ProductPage = new ProductPO(driver);
			  ContactPage = new ContactPO(driver);
			  
			  ReadingXLS.sFile = ReadingXLS.sTEST_DATA_FILE_PATH +  "demoWorkSheet.xlsx";
			  sUserName=ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 2);
			  sPassword = ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 3);

			  test=extent.createTest("TestCreateAddressonShipFromExistingContact");
			  
	//		  LoginPage.loginLCC(sUserName,sPassword);
		      
			  HomePage.clickContactHeaderBtn();
		//	  HomePage.clickCreateNewBtn();
		//	  ContactPage.bfCreateContact("Automation Contact03", "EIN", "EIN1234", "Automation Contact Description of contact details");
		      
		      ContactPage.selectContact_InListFP("Automation Contact03");
		      
		      String sActualContactName = ContactPage.getContactNameSp();
		      System.out.println(sActualContactName);

		      
		      if (sActualContactName.equals("Automation Contact03"))
		           test.log(Status.PASS,"Contact is Created without Address");
		      else
		    	  test.log(Status.FAIL, "Contact is not created without Address");
		      
		      ContactPage.clickAddNewAddressBtn();
		      
		      ContactPage.selectMultipleContactType("Ship From");
		      
			/*
			 * ArrayList<String> sContactTypeList = new ArrayList<String>();
			 * sContactTypeList.add("Ship From"); sContactTypeList.add("Bill To");
			 *ContactPage.selectMultipleContactTypes(sContactTypeList.get(0)); 
			 */
		      
		      ContactPage.bfCreateShipToAddressInContactwithDefaultListValues("IN","Building 123, Green Boulward", "Sector -62", "Noida", "Gautam buddha Nagar", "UP", "20130", "Bharat", "Impledge Noida", "9873226508", "", "vinit.awasthi@impledge.com", "Address NOtes", "TRUE");
		      String sActualAddressName = ContactPage.getFirstContactAddressSp();
		 			  System.out.println(sActualAddressName);
		 			  
		 			   if (sActualAddressName.contentEquals("Building 123, Green Boulward, Gautam buddha Nagar, UP, IN, 201030"))
				           test.log(Status.PASS,"Contact is Created without Address");
				      else
				    	  test.log(Status.FAIL, "Contact is not created without Address");
		 		     	  test.log(Status.FAIL,"Find Address associated with Saved Contact:: "+sActualAddressName ); 
	          
					
		} 
		catch (Exception e) {
			e.printStackTrace();
	    	  test.log(Status.FAIL, "Contact is not created without Address");  
		}
	}
	 
	 @Test(priority=5)
		public void TestCreateContactwithTestData() {
		
		try {
			
			  LoginPage = new LoginPO(driver);
			  HomePage = new HomePO(driver);
			  ProductPage = new ProductPO(driver);
			  ContactPage = new ContactPO(driver);
			  
			  ReadingXLS.sFile = ReadingXLS.sTEST_DATA_FILE_PATH +  "demoWorkSheet.xlsx";
			  sUserName=ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 2);
			  sPassword = ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 3);

			  test=extent.createTest("TestCreateContactwithTestData");
			  
     		  LoginPage.loginLCC(sUserName,sPassword);
		      
			  
     		  
     		  HomePage.clickContactHeaderBtn();
			  HomePage.clickCreateNewBtn();
		      
			  
			  
			  ContactPage.bfCreateContact("Automation Contact03", "EIN", "EIN1234", "Automation Contact Description of contact details");
		      ContactPage.selectContact_InListFP("Automation Contact03");
		      
		      String sActualContactName = ContactPage.getContactNameSp();
		      System.out.println(sActualContactName);

		      
		      if (sActualContactName.equals("Automation Contact03"))
		           test.log(Status.PASS,"Contact is Created without Address");
		      else
		    	  test.log(Status.FAIL, "Contact is not created without Address");
		      
		      
		      ContactPage.clickAddNewAddressBtn();
		      
		      ContactPage.selectMultipleContactType("Ship From");
		      
			/*
			 * ArrayList<String> sContactTypeList = new ArrayList<String>();
			 * sContactTypeList.add("Ship From"); sContactTypeList.add("Bill To");
			 *ContactPage.selectMultipleContactTypes(sContactTypeList.get(0)); 
			 */

		      
		      ContactPage.bfCreateShipToAddressInContactwithDefaultListValues("IN","Building 123, Green Boulward", "Sector -62", "Noida", "Gautam buddha Nagar", "UP", "20130", "Bharat", "Impledge Noida", "9873226508", "", "vinit.awasthi@impledge.com", "Address NOtes", "TRUE");

		      
			
		      
		      String sActualAddressName = ContactPage.getFirstContactAddressSp();
		 			  System.out.println(sActualAddressName);
		 			  
		 			   if (sActualAddressName.contentEquals("Building 123, Green Boulward, Gautam buddha Nagar, UP, IN, 201030"))
				           test.log(Status.PASS,"Contact is Created without Address");
				      else
				    	  test.log(Status.FAIL, "Contact is not created without Address");
		 		     	  test.log(Status.FAIL,"Find Address associated with Saved Contact:: "+sActualAddressName ); 
	          
					
		} 
		catch (Exception e) {
			e.printStackTrace();
	    	  test.log(Status.FAIL, "Contact is not created without Address");  
		}
	}
	 
	 
	 
	 
	 @AfterClass
	 public void tearDown() {
		
		  driver.quit();
		  System.out.println("Browser Closed Sucessfully");
	 }

}
