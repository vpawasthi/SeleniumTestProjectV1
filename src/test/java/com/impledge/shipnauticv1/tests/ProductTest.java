package com.impledge.shipnauticv1.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.impledge.shipnauticv1.pages.HomePO;
import com.impledge.shipnauticv1.pages.LoginPO;
import com.impledge.shipnauticv1.pages.ProductPO;
import com.impledge.shipnauticv1.utility.ReadingXLS;
import com.impledge.shipnauticv1.utility.XLSXUtility;

public class ProductTest extends BaseTest{
	
 private static WebDriver driver;
	 
	 String sUserName;
	 String sPassword;
	
	 LoginPO LoginPage;
	 HomePO HomePage;
	 
	 ProductPO ProductPage;
	 
	 @BeforeClass
		public void setUp() {
		driver = getDriver();
			
		}
	
	@Test(priority=2)
	public void TestCreateProductOnly() {
	
	try {
		
		  LoginPage = new LoginPO(driver);
		  HomePage = new HomePO(driver);
		  ProductPage = new ProductPO(driver);
		  
		  ReadingXLS.sFile = ReadingXLS.sTEST_DATA_FILE_PATH +  "demoWorkSheet.xlsx";
		  sUserName=ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 2);
		  sPassword = ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 3);

		  test=extent.createTest("TestCreateProduct");
		  
		  if (HomePage.isLoggedInLCC())
		      test.log(Status.INFO, "Already logged in ");
		  else
			  LoginPage.loginLCC(sUserName,sPassword);
		  HomePage.ClickProductHeaderBtn();
		  HomePage.clickCreateNewBtn();
		  
		  ProductPage.bfCreateProduct("AutomationTest", "Automation Test Description of Product Details");
		  
		  String sActualProductName = ProductPage.getProductNameSp();
	      String sActualProductDescription = ProductPage.getProductDescriptionSp();
	      //String sActualVariantName = ProductPage.getFirstVaraintNameSp();
	      System.out.println(sActualProductName);
	      System.out.println(sActualProductDescription);
//	      System.out.println(sActualVariantName);
	      
	      
	      if (sActualProductName.equals("AutomationTest"))
	           test.log(Status.PASS,"Product is Created without Varaint");
	      else
	    	  test.log(Status.FAIL, "Product is not created without Varaint");  
          
				
	} 
	catch (Exception e) {
		e.printStackTrace();
		  test.log(Status.FAIL, "Product is not created without Varaint");
	}
}
	@Test (priority=3)
	public void TestCreateProductwithVaraint() {
	
	try {
		
		  test=extent.createTest("TestCreateProductwithVaraint");

	      LoginPage = new LoginPO(driver);
		  HomePage = new HomePO(driver);
		  ProductPage = new ProductPO(driver);
		  
			
			  ReadingXLS.sFile = ReadingXLS.sTEST_DATA_FILE_PATH + "demoWorkSheet.xlsx";
			  sUserName=ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 2); sPassword =
			  ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 3);
			 
	 	  

		 //LoginPage.loginLCC(sUserName,sPassword);
	      
		  HomePage.ClickProductHeaderBtn();
		  HomePage.clickCreateNewBtn();
		  
		  ProductPage.bfCreateProduct("AutomationTest01", "Automation Test1 Description of Product Details");
		  Thread.sleep(10000);
	      ProductPage.bfCreateVaraintwithDefaultListValues("AutoVar01", "Automation varaint description", "SKU10", "MN23", "10", "1.5", "2.5", "5", "4", "3.1");					
          
	      String sActualProductName = ProductPage.getProductNameSp();
	      String sActualProductDescription = ProductPage.getProductDescriptionSp();
	      String sActualVariantName = ProductPage.getFirstVaraintNameSp();
	      System.out.println(sActualProductName);
	      System.out.println(sActualProductDescription);
	      System.out.println(sActualVariantName);
	      
	      if (sActualProductName.equals("AutomationTest01"))
	           test.log(Status.PASS,"Product is Created without Varaint");
	      else
	    	  test.log(Status.FAIL, "Product is not created without Varaint");  
         
	      
	      if (sActualVariantName.equals("AutoVar01"))
	           test.log(Status.PASS,"Product is Created with Varaint");
	      else
	    	  test.log(Status.FAIL, "Product is not created with Varaint");  
          
	} 
	catch (Exception e) {
		e.printStackTrace();
		test.log(Status.FAIL, "Product is not created with Varaint");
	}
}

    @Test (priority=4)
	public void TestCreateProductwithVaraintCountry() {
	
	try {
		
		  test=extent.createTest("TestCreateProductwithVaraintCountry");

	      LoginPage = new LoginPO(driver);
		  HomePage = new HomePO(driver);
		  ProductPage = new ProductPO(driver);
		  
			  ReadingXLS.sFile = ReadingXLS.sTEST_DATA_FILE_PATH + "demoWorkSheet.xlsx";
			  sUserName=ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 2); sPassword =
			  ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 3);
			
		  //LoginPage.loginLCC(sUserName,sPassword);
	      
		  HomePage.ClickProductHeaderBtn();
		  HomePage.clickCreateNewBtn();
		  
		  ProductPage.bfCreateProduct("AutomationTest2", "Automation Test2 Description of Product Details");
		  Thread.sleep(10000);
	      ProductPage.bfCreateVaraintwithDefaultListValues("AutoVar001", "Automation varaint description", "SKU10", "MN23", "10", "1.5", "2.5", "5", "4", "3.1");					
          
		  ProductPage.selectProduct_InListFP("AutomationTest2");
		  
	      String sActualProductName = ProductPage.getProductNameSp();
	      String sActualProductDescription = ProductPage.getProductDescriptionSp();
	      String sActualVariantName = ProductPage.getFirstVaraintNameSp();
	      System.out.println(sActualProductName);
	      System.out.println(sActualProductDescription);
	      System.out.println(sActualVariantName);
	      
	      if (sActualProductName.equals("AutomationTest2"))
	           test.log(Status.PASS,"Product is Created without Varaint");
	      else
	    	  test.log(Status.FAIL, "Product is not created without Varaint");  
	      
	      if (sActualVariantName.equals("AutoVar001"))
	           test.log(Status.PASS,"Product is Created with Varaint");
	      else
	    	  test.log(Status.FAIL, "Product is not created with Varaint");  
          ProductPage.clickFirstVaraintNameSp();
          ProductPage.clickVariantCDAddBtn();	      
	      ProductPage.bfCreateVariantCDCountrywithDefaultListValues("sVariantCDCountryDescriptionTxt", "sVaraintCDLegalDescriptionTxtArea", "EHS001", "sVariantCDExportHSDescriptionTxtArea", "IHS002", "sVariantCDImportHSDescriptionTxtArea", "SBN001", "sVariantCDScheduleBDescTxtArea", "ECCN001", "10.5", "2.7");
	      
	      test.log(Status.PASS,"Product is Created with Varaint Coutry Details");
	} 
	catch (Exception e) {
		e.printStackTrace();
		test.log(Status.FAIL, "Product is not created with Varaint");
	}
}
	
    @Test (priority=1)
	public void TestCreateProductwithVaraintCountryTestData() {
    	 int iTotalRowCount;
		 int rownum;
	       String sProdName, sProdDescription;
           	
           	String sVarName, sVarDescp, sSku, sModelNo, sCountryCode, sCurrencyCode, sListPrice, sWeightUnit,
           			sNetWeight, sGrossWeight, sDimUnit, sLength, sWidth, sHeight;
            
            String sVariantCDCountry, sVariantCDCOCountry, sVariantCDCountryDescriptionTxt, sVaraintCDLegalDescriptionTxtArea,
            sVariantCDExportHSCodeTxt, sVariantCDExportHSDescriptionTxtArea, sVariantCDImportHSCode, sVariantCDImportHSDescriptionTxtArea,
            sVariantCDScheduleBNumberTxt, sVariantCDScheduleBDescTxtArea, sVariantCDECCNTxt, sCDCurrency, sVariantCDListPriceTxt,
            sCDWeightUnit, sVariantCDNetWeightTxt;
	
	try {
		
		  test=extent.createTest("TestCreateProductwithVaraintCountryTestData");

	      LoginPage = new LoginPO(driver);
		  HomePage = new HomePO(driver);
		  ProductPage = new ProductPO(driver);
		  
			  ReadingXLS.sFile = ReadingXLS.sTEST_DATA_FILE_PATH + "demoWorkSheet.xlsx";
			  sUserName=ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 2); 
			  sPassword =ReadingXLS.getCellValue(ReadingXLS.sFile, 1, 3);
			
		    LoginPage.loginLCC(sUserName,sPassword);
	      
		 
		   XLSXUtility.setExcelFileSheet("Product.xlsx","Product");
			  
		   iTotalRowCount= XLSXUtility.getTotalRowNumber()+1;
		   
			  System.out.println("Totoal Row in spreadsheet: "+iTotalRowCount);
	            HomePage.ClickProductHeaderBtn();

		   
        for (rownum=1; rownum <iTotalRowCount; rownum ++ )
        {
           	System.out.println("Reading data from xls for Login - Refer Row Number : " + rownum);
           	
           
           	
           	sProdName=XLSXUtility.getCellData(rownum, 1);
      		System.out.println("sProdName"+sProdName);
      		  
      		sProdDescription=XLSXUtility.getCellData(rownum, 2);
      		System.out.println("sProdDescription"+sProdDescription);
      		
      		sVarName=XLSXUtility.getCellData(rownum, 4);
      		sVarDescp=XLSXUtility.getCellData(rownum, 5);
      		sSku=XLSXUtility.getCellData(rownum, 6);
      		sModelNo=XLSXUtility.getCellData(rownum, 7);
      		sCurrencyCode=XLSXUtility.getCellData(rownum, 8);
      		sListPrice=XLSXUtility.getCellData(rownum, 9);
      		sWeightUnit=XLSXUtility.getCellData(rownum, 10);
      		sNetWeight=XLSXUtility.getCellData(rownum, 11);
      		sGrossWeight=XLSXUtility.getCellData(rownum, 12);
      		sCountryCode=XLSXUtility.getCellData(rownum, 13);
      		sDimUnit=XLSXUtility.getCellData(rownum, 14);
      		sLength=XLSXUtility.getCellData(rownum, 15);
      		sWidth=XLSXUtility.getCellData(rownum, 16);
      		sHeight=XLSXUtility.getCellData(rownum, 17);
      		
      		sVariantCDCountry = XLSXUtility.getCellData(rownum, 18);
      		sVariantCDCOCountry = XLSXUtility.getCellData(rownum, 19);
      		sVariantCDCountryDescriptionTxt= XLSXUtility.getCellData(rownum, 20);
      		sVaraintCDLegalDescriptionTxtArea= XLSXUtility.getCellData(rownum, 21);
      		
      		sCDCurrency = XLSXUtility.getCellData(rownum, 22);
      		sVariantCDListPriceTxt = XLSXUtility.getCellData(rownum, 23);
      		sCDWeightUnit = XLSXUtility.getCellData(rownum, 24);
            sVariantCDNetWeightTxt = XLSXUtility.getCellData(rownum, 25);
       		
      		sVariantCDExportHSCodeTxt= XLSXUtility.getCellData(rownum, 26);
            sVariantCDExportHSDescriptionTxtArea= XLSXUtility.getCellData(rownum, 27);
            
            sVariantCDECCNTxt = XLSXUtility.getCellData(rownum, 28);
            sVariantCDScheduleBNumberTxt = XLSXUtility.getCellData(rownum, 29);
            sVariantCDScheduleBDescTxtArea = XLSXUtility.getCellData(rownum, 30);
           
            sVariantCDImportHSCode= XLSXUtility.getCellData(rownum, 31);
            sVariantCDImportHSDescriptionTxtArea= XLSXUtility.getCellData(rownum, 32);
            
  		  HomePage.clickCreateNewBtn();
		  ProductPage.bfCreateProduct(sProdName,sProdDescription);
		  String sActualProductName = ProductPage.getProductNameSp();
	      String sActualProductDescription = ProductPage.getProductDescriptionSp();
	      System.out.println(sActualProductName);
	      System.out.println(sActualProductDescription);
	   
	      if (sActualProductName.equals(sProdName)) {
	           test.log(Status.PASS,"Product is Created without Varaint");
	    	test.log(Status.INFO, "Product is created with Actual Product Name: "+sActualProductName);
	      }
	      else
	    	  { 
	    	  	test.log(Status.FAIL, "Product is not created without Varaint");  
	    	  	test.log(Status.INFO, "Actual Product Name: "+sActualProductName+"Expected Product Name :"+ sProdName);
	    	  }
	   
	   
		  Thread.sleep(10000);
		  
		  ProductPage.bfCreateVaraintwithAllInput(sVarName, sVarDescp, sSku, sModelNo, sCountryCode, sCurrencyCode, sListPrice, sWeightUnit, sNetWeight, sGrossWeight, sDimUnit, sLength, sWidth, sHeight);
		  
		  String sActualVariantName = ProductPage.getFirstVaraintNameSp();
	      System.out.println(sActualVariantName);
	      
	         if (sActualVariantName.equals(sVarName)) {
	           test.log(Status.PASS,"Product is Created with Varaint");
	           test.log(Status.INFO, "Product is created with Actual Variant Name: "+sActualVariantName);
	      }
	      else
	         { 
	    	  	test.log(Status.FAIL, "Product is not created without Varaint");  
	    	  	test.log(Status.INFO, "Actual Varaint Name: "+sActualVariantName+"Expected Product Name :"+ sVarName);
	    	  }
	      
		  //ProductPage.clickFirstVaraintNameSp(); 
		  System.out.println("LogINfo : Product & Varaint Created");
		  ProductPage.clickVariantCDAddBtn();
		  
		  ProductPage.bfCreateVariantCDCountrywithAllInput(sVariantCDCountry, sVariantCDCOCountry, sVariantCDCountryDescriptionTxt, sVaraintCDLegalDescriptionTxtArea, sVariantCDExportHSCodeTxt, sVariantCDExportHSDescriptionTxtArea, sVariantCDImportHSCode, sVariantCDImportHSDescriptionTxtArea, sVariantCDScheduleBNumberTxt, sVariantCDScheduleBDescTxtArea, sVariantCDECCNTxt, sCDCurrency, sVariantCDListPriceTxt, sWeightUnit, sVariantCDNetWeightTxt);
		
		  String sActualVariantCDDescription = ProductPage.getProductCDDescription();
	      System.out.println(sActualVariantCDDescription);
	      
	         if (sActualVariantCDDescription.equals(sVariantCDCountryDescriptionTxt)) {
	 		  test.log(Status.PASS,"Product is Created with Varaint Coutry Details");
	           test.log(Status.INFO, "Product is created with Actual Variant Country Description : "+sActualVariantCDDescription);
	      }
	      else
	         { 
	    	  	test.log(Status.FAIL, "Product Varaint Country Details is not created ");  
	    	  	test.log(Status.INFO, "Actual Product Varaint Country Details : "+sActualVariantCDDescription+"Expected Product Varaint Country Details  :"+ sVariantCDCountryDescriptionTxt);
	    	  }
	      
		  

           }//end of for loop
	
	  	} 
	catch (Exception e) {
		e.printStackTrace();
		test.log(Status.FAIL, "Product is not created with Varaint & Variant Country Details");
	}
}
    
    
    
	@AfterClass
	 public void tearDown() {
		
		  driver.quit();
		  System.out.println("Browser Closed Sucessfully");
	 }
		
}
