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
import com.impledge.shipnauticv1.utility.XLSXUtility;

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
	 
	 @Test(priority=2)
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
			  
			  if (HomePage.isLoggedInLCC())
			      test.log(Status.INFO, "Already logged in ");
			  else
				  LoginPage.loginLCC(sUserName,sPassword);
			  
			 // LoginPage.loginLCC(BaseTest.sUserName,BaseTest.sPassword);
		      
			  HomePage.clickContactHeaderBtn();
			  HomePage.clickCreateNewBtn();
			  ContactPage.bfCreateContact("Automation Contact02", "EIN", "EIN1234", "Automation Contact Description of contact details");

			  String sActualContactName = ContactPage.getContactNameSp();
		      System.out.println(sActualContactName);

		      String sExpectedResult = "Automation Contact02"; 
		      
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

	 @Test(priority=3)
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
			  
		
			  if (HomePage.isLoggedInLCC())
			      test.log(Status.INFO, "Already logged in ");
			  else
				  LoginPage.loginLCC(sUserName,sPassword);
		      
			  HomePage.clickContactHeaderBtn();
			  HomePage.clickCreateNewBtn();
			  ContactPage.bfCreateContact("Automation Contact1", "EIN", "EIN1234", "Automation Contact Description of contact details");

			  String sActualContactName = ContactPage.getContactNameSp();
		      System.out.println(sActualContactName);
      
		      ContactPage.bfCreateShipToAddressInContactwithDefaultListValues("IN","Buiilding 123, Green Boulward", "Sector -62", "Noida", "Gautam buddha Nagar", "UP", "201030", "Bharat", "Impledge Noida", "9873226508", "", "vinit.awasthi@impledge.com", "Address NOtes", "TRUE");
		      
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
	 
	 @Test(priority=4)
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
			  
			  if (HomePage.isLoggedInLCC())
			      test.log(Status.INFO, "Already logged in ");
			  else
				  LoginPage.loginLCC(sUserName,sPassword);
		      
			  HomePage.clickContactHeaderBtn();
			  HomePage.clickCreateNewBtn();
			  ContactPage.bfCreateContact("Automation Contact003", "EIN", "EIN1234", "Automation Contact Description of contact details");

			  String sActualContactName = ContactPage.getContactNameSp();
		      System.out.println(sActualContactName);

		      
		      if (sActualContactName.equals("Automation Contact003"))
		           test.log(Status.PASS,"Contact is Created without Address");
		      else
		    	  test.log(Status.FAIL, "Contact is not created without Address");
		      
		      
		      ContactPage.selectContact_InListFP("Automation Contact003");
		      
		      ContactPage.clickAddNewAddressBtn();
		      
		      ContactPage.bfCreateShipToAddressInContactwithDefaultListValues("IN","Building 123, Green Boulward", "Sector -62", "Noida", "Gautam buddha Nagar", "UP", "201030", "Bharat", "Impledge Noida", "9873226508", "", "vinit.awasthi@impledge.com", "Address NOtes", "TRUE");

		      
			
		      
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
	 @Test(priority=5)
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
			  
			  if (HomePage.isLoggedInLCC())
			      test.log(Status.INFO, "Already logged in ");
			  else
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
	 
	 @Test(priority=1)
		public void TestCreateContactwithTestData() {
		 int iTotalRowCount;
		 int rownum;
		 
		 String sContactName, sTaxIdType, sTaxNumber, sContactDescription;
		 String sContactType; 
		 String sCountryCode, sAddress1Input, sAddress2Input, sAddress3Input, sCity, sStateCodeORStateName, sZip,
		        sAddressContactName, sCompanyName, sPhoneNo, sFaxNo, sEmail, sAddNotes, sClick;
		 
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
		      
     		  XLSXUtility.setExcelFileSheet("Contact.xlsx","Contact");
			  
   		      iTotalRowCount= XLSXUtility.getTotalRowNumber()+1;
   		   
   			  System.out.println("Totoal Row in spreadsheet: "+iTotalRowCount);
   	            HomePage.clickContactHeaderBtn();

   		   
           for (rownum=1; rownum <iTotalRowCount; rownum ++ )
           {
              	System.out.println("Reading data from xls for Login - Refer Row Number : " + rownum);
              	
              
              	
              	sContactName = XLSXUtility.getCellData(rownum, 1);
         		System.out.println("Contact Name"+sContactName);
         		  
         		sContactDescription = XLSXUtility.getCellData(rownum, 2);
         		System.out.println("Contact Description"+sContactDescription);
         		
         		 sTaxIdType  = XLSXUtility.getCellData(rownum, 3);
         		 sTaxNumber = XLSXUtility.getCellData(rownum, 4);
         		
         		sAddressContactName= XLSXUtility.getCellData(rownum, 5);
         		sCompanyName = XLSXUtility.getCellData(rownum, 6);
         		sContactType = XLSXUtility.getCellData(rownum, 7);
         		sClick = XLSXUtility.getCellData(rownum, 8);
         		sCountryCode= XLSXUtility.getCellData(rownum, 9);
         		sAddress1Input= XLSXUtility.getCellData(rownum, 10);
         		sAddress2Input= XLSXUtility.getCellData(rownum, 11);
         		sAddress3Input= XLSXUtility.getCellData(rownum, 12);
         		sCity= XLSXUtility.getCellData(rownum, 13);
         		sStateCodeORStateName= XLSXUtility.getCellData(rownum, 14);
         		sZip= XLSXUtility.getCellData(rownum, 15);
		        sPhoneNo= XLSXUtility.getCellData(rownum, 16);
		        sEmail= XLSXUtility.getCellData(rownum, 17);
		        sFaxNo= XLSXUtility.getCellData(rownum, 18);
		        sAddNotes= XLSXUtility.getCellData(rownum, 19);
         		
         		  HomePage.clickCreateNewBtn();
         		  
         		  ContactPage.bfCreateContact(sContactName, sTaxIdType, sTaxNumber, sContactDescription);
         		  
         		  String sActualContactName = ContactPage.getContactNameSp();
   		          System.out.println(sActualContactName);

   		      
   		      if (sActualContactName.equals(sContactName)) {
   		           test.log(Status.INFO,"Contact is Created without Address"); 
   		        test.log(Status.PASS,"Contact is Created without Address"+sContactName);
   		      }
   		      else
   		      { 
   		    	  test.log(Status.FAIL, "Contact is not created without Address");
  	    	  	test.log(Status.INFO, "Actual Contact Name: "+sActualContactName+"Expected Contact Name :"+ sContactName);

   		      }
   		      
   		       ContactPage.selectContact_InListFP(sContactName);
   		       ContactPage.clickAddNewAddressBtn();
		       ContactPage.selectMultipleContactType(sContactType);
   		      
			   ContactPage.bfCreateShipToAddressInContactwithDefaultListValues(sCountryCode, sAddress1Input, sAddress2Input, sAddress3Input, sCity, sStateCodeORStateName, sZip, sAddressContactName, sCompanyName, sPhoneNo, sFaxNo, sEmail, sAddNotes, sClick);

			      String sActualAddressName = ContactPage.getFirstContactAddressSp();
	 		 	  System.out.println(sActualAddressName);
	 			  String sExpectedAddress = "Building 123, Green Boulward, Gautam buddha Nagar, UP, IN, 201301";
	 		
	 			  if (sActualAddressName.contentEquals(sExpectedAddress)) {
			           test.log(Status.INFO,"Contact is Created without Address");
	 			       test.log(Status.PASS,"Actual Address associated with saved Contact : "+sActualAddressName );
	 			  }
			      else
			      {
			    	  test.log(Status.INFO, "Contact is not created without Address");
			    	  test.log(Status.FAIL,"Actual Address associated with saved Contact : "+sActualAddressName+"Expected Address: "+sExpectedAddress );
			      }
	 		     	  
           } // end of for loop
     		  
			//  ContactPage.bfCreateContact("Automation Contact03", "EIN", "EIN1234", "Automation Contact Description of contact details");
			  
		//	  ContactPage.selectContact_InListFP("Automation Contact03");
		      
			/*
			 * ArrayList<String> sContactTypeList = new ArrayList<String>();
			 * sContactTypeList.add("Ship From"); sContactTypeList.add("Bill To");
			 *ContactPage.selectMultipleContactTypes(sContactTypeList.get(0)); 
			 */
		      
	//	      ContactPage.bfCreateShipToAddressInContactwithDefaultListValues("IN","Building 123, Green Boulward", "Sector -62", "Noida", "Gautam buddha Nagar", "UP", "20130", "Bharat", "Impledge Noida", "9873226508", "", "vinit.awasthi@impledge.com", "Address NOtes", "TRUE");
				
		} 
		catch (Exception e) {
			e.printStackTrace();
	    	  test.log(Status.ERROR, "Contact is not created without Address");  
		}
	}
	 
	 
	 @AfterClass
	 public void tearDown() {
		
		  driver.quit();
		  System.out.println("Browser Closed Sucessfully");
	 }

}
