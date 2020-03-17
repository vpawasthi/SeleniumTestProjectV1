package com.impledge.shipnauticv1.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPO {

	private WebDriver driver =null;
    List <WebElement >  elements;
	
    //First Panel Product List
    
    
   
    // Second Panel Product Details 
    By productNameSp = By.xpath("//app-product-detail//mat-expansion-panel[1]//div[@class='mat-list-text']/p[1]");
   
    By productDescriptionSp = By.xpath("//app-product-detail//mat-expansion-panel[1]//div[@class='mat-list-text']/p[2]");
    
    By variantNameSp = By.xpath("//app-product-detail//mat-expansion-panel[2]//mat-list-item//div[@class='mat-list-text']/span");
    
    By variantDeleteSp = By.xpath("//app-product-detail//mat-expansion-panel[2]//mat-list-item//div[@appdialog='alert']/mat-icon[contains(text(),'delete')]");
    
    By addNewVariantBtn = By.xpath("//app-product-detail//button/span/span[text(),'New  Variant']");
    
    //Third Panel Product  Manage Details
    
    By productNameTxt = By.xpath("//app-product-manage//input[@formcontrolname='name']");
    
    By productdescriptionTxtArea = By.xpath("//app-product-manage//textarea[@formcontrolname='description']");
	
    By productSaveCheckBtn = By.xpath("//app-product-manage//button/span/mat-icon[contains(text(),'check')]");
    
  //Third Panel Product Variant Details
    By addNewProductToOrder = By.xpath("//app-product-variant/mat-toolbar/span[contains(text(),'Add a new product to Order')]"); 
    
    By varaintUploadImgeBtn = By.xpath("//app-product-variant-manage//mat-icon[text()='cloud_upload']");

    By varaintNameTxt = By.xpath("//app-product-variant-manage//input[@formcontrolname='name']");
    
    By variantDescriptionTxtArea = By.xpath("//app-product-variant-manage//textarea[@formcontrolname='description']");
	
    By variantSaveCheckBtn = By.xpath("//app-product-variant//button/span/mat-icon[contains(text(),'check')]");

    By varaintSKUTxt = By.xpath("//app-product-variant-manage//input[@formcontrolname='sku']");
    
    By variantModelNumberTxt = By.xpath("//app-product-variant-manage//input[@formcontrolname='modelNumber']");
	
    By variantCountryofOriginLB = By.xpath("//app-product-variant-manage//mat-select[@formcontrolname='originCountryCode']");
    
    By variantCurrencyCodeLB = By.xpath("//app-product-variant-manage//mat-select[@formcontrolname='currencyCode']");
    
    By variantListPriceTxt = By.xpath("//app-product-variant-manage//input[@formcontrolname='listPrice']");
    
    By variantWeightUnitLB = By.xpath("//app-product-variant-manage//mat-select[@formcontrolname='weightUnitCode']");
    
    By variantNetWeightTxt =By.xpath("//app-product-variant-manage//input[@formcontrolname='netWeight']");
    
    By variantGrossWeightTxt = By.xpath("//app-product-variant-manage//input[@formcontrolname='grossWeight']");
    
    By variantLengthTxt = By.xpath("//app-product-variant-manage//input[@formcontrolname='length']");
    
    By variantDimenssionUnitLB = By.xpath("//app-product-variant-manage//mat-select[@formcontrolname='dimensionUnitCode']");
    
    By variantWidthTxt = By.xpath("//app-product-variant-manage//input[@formcontrolname='width']");
    
    By variantHeightTxt = By.xpath("//app-product-variant-manage//input[@formcontrolname='height']");
    
  //******************************** Third Panel Product Variant Country Details **********************************************
   
    By variantCDCountryAddBtn = By.xpath("//perfect-scrollbar[@id='third-panel-scrollbar']//button/span/mat-icon[contains(text(),'add')]");

    By varaintCDCountryLB = By.xpath("//app-product-variant-country-manage//mat-select[@formcontrolname='countryCode']");
    
    By varaintCDCountryOriginLB = By.xpath("//app-product-variant-country-manage//mat-select[@formcontrolname='originCountryCode']");
    
    By variantCDCountryDescriptionTxtArea = By.xpath("//app-product-variant-country-manage//textarea[@formcontrolname='description']");
	
    By varaintCDLegalDescriptionTxtArea = By.xpath("//app-product-variant-country-manage//textarea[@formcontrolname='legalDescription']");
    
    By variantCDExportHSCodeTxt = By.xpath("//app-product-variant-country-manage//input[@formcontrolname='exportHS']");
	
    By variantCDExportHSDescriptionTxtArea = By.xpath("//app-product-variant-country-manage//textarea[@formcontrolname='exportHSDescription']");
    
    By variantCDImportHSCode = By.xpath("//app-product-variant-country-manage//input[@formcontrolname='importHS']");
	
    By variantCDImportHSDescriptionTxtArea = By.xpath("//app-product-variant-country-manage//textarea[@formcontrolname='importHSDescription']");
   
    By variantCDScheduleBNumberTxt = By.xpath("//app-product-variant-country-manage//input[@formcontrolname='scheduleBNumber']");
    
    By variantCDScheduleBDescTxtArea = By.xpath("//app-product-variant-country-manage//textarea[@formcontrolname='scheduleBDescription']");
    
    By variantCDECCNTxt = By.xpath("//app-product-variant-country-manage//input[@formcontrolname='ecn']");
    
    By variantCDCurrencyCodeLB = By.xpath("//app-product-variant-country-manage//mat-select[@formcontrolname='currencyCode']");
    
    By variantCDListPriceTxt = By.xpath("//app-product-variant-country-manage//input[@formcontrolname='listPrice']");
    
    By variantCDWeightUnitLB = By.xpath("//app-product-variant-country-manage//mat-select[@formcontrolname='weightUnitCode']");
    
    By variantCDNetWeightTxt = By.xpath("//app-product-variant-country-manage//input[@formcontrolname='netWeight']");
    
    By variantCDSaveBtn = By.xpath("//app-product-variant-country-manage//button/span[contains(text(),'Save')]");
    
    By variantCDCancelBtn = By.xpath("//app-product-variant-country-manage//button/span[contains(text(),'Cancel')]");
    
    By varintCDDescription = By.xpath("//perfect-scrollbar//div[@class='mat-list-item-content']/span[@class='col-3 list-item-ellipsis']");
    
    
    public ProductPO(WebDriver driver) {
      	 
      	 this.driver=driver;
       }
	
	
    public void selectOptionVisibleText(String sOption) {
		By element = By.xpath("//mat-option/span[contains(text(),'"+sOption +"')]");
    	 driver.findElement(element).click();
      }
    
    //**********Product List First Panel *********************************** 
    
    public void selectProduct_InListFP(String sProductName) {
		  By selectProduct = By.xpath("//app-product-list//mat-card//span[contains(text(),'"+ sProductName+"')]");
	    	 driver.findElement(selectProduct).click();
	      }
    
    //**********Product Details Second Panel ***********************************
    
    public String getProductNameSp() {
    	
    	return driver.findElement(productNameSp).getText();
    }
    
    public String getProductDescriptionSp() {
    	
    	return driver.findElement(productDescriptionSp).getText();
    }
    
    public String getFirstVaraintNameSp() {
    	
    	return driver.findElement(variantNameSp).getText();
    }
    
    public  void clickFirstVaraintNameSp() {
    	
    	 driver.findElement(variantNameSp).click();
    }
    
    public void addNewVaraintBtn() {
    	
    	driver.findElement(addNewVariantBtn).click();
    }
  
  //**********************Third Panel Product  Manage Details Methods************************************
    
    public void setProductName(String sProductName) {
    	
    	driver.findElement(productNameTxt).click();
    	driver.findElement(productNameTxt).clear();
    	driver.findElement(productNameTxt).sendKeys(sProductName);
     }
    
    public void setProductDescription(String sProductDescription) {
    	
    	driver.findElement(productdescriptionTxtArea).click();
    	driver.findElement(productdescriptionTxtArea).clear();
    	driver.findElement(productdescriptionTxtArea).sendKeys(sProductDescription);
     }

	public void saveProductBtn() {
	
		driver.findElement(productSaveCheckBtn).click();
		
	}
	
	//Third Panel Product Variant Details Methods

	public void setVariantName(String sVariantName) {
    	
    	driver.findElement(varaintNameTxt).click();
    	driver.findElement(varaintNameTxt).clear();
    	driver.findElement(varaintNameTxt).sendKeys(sVariantName);
     }
	
	public void setVariantDescription(String sVariantDescription) {
    	
    	driver.findElement(variantDescriptionTxtArea).click();
    	driver.findElement(variantDescriptionTxtArea).clear();
    	driver.findElement(variantDescriptionTxtArea).sendKeys(sVariantDescription);
     }

	public void setVariantSKU(String sSKU) {
	
		driver.findElement(varaintSKUTxt).click();
		driver.findElement(varaintSKUTxt).clear();
		driver.findElement(varaintSKUTxt).sendKeys(sSKU);
	}

	public void setVariantModelNumber(String sModelNumber) {
	
		driver.findElement(variantModelNumberTxt).click();
		driver.findElement(variantModelNumberTxt).clear();
		driver.findElement(variantModelNumberTxt).sendKeys(sModelNumber);
	}

	public void setVariantListPrice(String sListPrice) {
		
		driver.findElement(variantListPriceTxt).click();
		driver.findElement(variantListPriceTxt).clear();
		driver.findElement(variantListPriceTxt).sendKeys(sListPrice);
	}
	
	public void setVariantNetWeight(String sNetWeight) {
		
		driver.findElement(variantNetWeightTxt).click();
		driver.findElement(variantNetWeightTxt).clear();
		driver.findElement(variantNetWeightTxt).sendKeys(sNetWeight);
	}
	
	public void setVariantGrossWeight(String sGrossWeight) {
		
		driver.findElement(variantGrossWeightTxt).click();
		driver.findElement(variantGrossWeightTxt).clear();
		driver.findElement(variantGrossWeightTxt).sendKeys(sGrossWeight);
	}
	
	public void setVariantLengthTxt(String sLengthTxt) {
		
		driver.findElement(variantLengthTxt).click();
		driver.findElement(variantLengthTxt).clear();
		driver.findElement(variantLengthTxt).sendKeys(sLengthTxt);
	}
	
	public void setVariantWidthTxt(String sWidth) {
		
		driver.findElement(variantWidthTxt).click();
		driver.findElement(variantWidthTxt).clear();
		driver.findElement(variantWidthTxt).sendKeys(sWidth);
	}
	
	public void setVariantHeightTxt(String sHeightTxt) {
		
		driver.findElement(variantHeightTxt).click();
		driver.findElement(variantHeightTxt).clear();
		driver.findElement(variantHeightTxt).sendKeys(sHeightTxt);
	}
	
	public void selectVariantCountryofOrigin(String sCountry) {
		 driver.findElement(variantCountryofOriginLB).click(); 
		 selectOptionVisibleText(sCountry);
	 }
	
	public void selectVariantCurencyCode(String sCurrency) {
		 driver.findElement(variantCurrencyCodeLB).click(); 
		 selectOptionVisibleText(sCurrency);
	 }

	public void selectVariantWeightUnit(String sWeightUnit) {
		 driver.findElement(variantWeightUnitLB).click(); 
		 selectOptionVisibleText(sWeightUnit);
	 }

	public void selectVariantDimenssionUnit(String sDimUnit) {
		 driver.findElement(variantDimenssionUnitLB).click(); 
		 selectOptionVisibleText(sDimUnit);
	 }

	public void clickVariantDetailsSaveBtn() {
		 driver.findElement(variantSaveCheckBtn).click(); 
	 }
	  //*************************Third Panel Product Variant Country Details***********************************

	public void selectVariantCDCountryofOrigin(String sCountry) {
		 driver.findElement(varaintCDCountryOriginLB).click(); 
		 selectOptionVisibleText(sCountry);
	 }
	
	public void selectVariantCDCurencyCode(String sCurrency) {
		 driver.findElement(variantCDCurrencyCodeLB).click(); 
		 selectOptionVisibleText(sCurrency);
	 }

	public void selectVariantCDWeightUnit(String sWeightUnit) {
		 driver.findElement(variantCDWeightUnitLB).click(); 
		 selectOptionVisibleText(sWeightUnit);
	 }

	public void selectVariantCDCountry(String sCountry) {
		 driver.findElement(varaintCDCountryLB).click(); 
		 selectOptionVisibleText(sCountry);
	 }
	
	public void setVariantCDCountryDescriptionTxtArea(String sVariantCDCountryDescriptionTxt) {
			
			driver.findElement(variantCDCountryDescriptionTxtArea).click();
			driver.findElement(variantCDCountryDescriptionTxtArea).clear();
			driver.findElement(variantCDCountryDescriptionTxtArea).sendKeys(sVariantCDCountryDescriptionTxt);
		}

	public void setVaraintCDLegalDescriptionTxtArea(String sVaraintCDLegalDescriptionTxtArea) {
		
		driver.findElement(varaintCDLegalDescriptionTxtArea).click();
		driver.findElement(varaintCDLegalDescriptionTxtArea).clear();
		driver.findElement(varaintCDLegalDescriptionTxtArea).sendKeys(sVaraintCDLegalDescriptionTxtArea);
	}

	public void setVariantCDExportHSCodeTxt(String sVariantCDExportHSCodeTxt) {
	
		driver.findElement(variantCDExportHSCodeTxt).click();
		driver.findElement(variantCDExportHSCodeTxt).clear();
		driver.findElement(variantCDExportHSCodeTxt).sendKeys(sVariantCDExportHSCodeTxt);
	}


	public void setVariantCDExportHSDescriptionTxtArea(String sVariantCDExportHSDescriptionTxtArea) {
		
		driver.findElement(variantCDExportHSDescriptionTxtArea).click();
		driver.findElement(variantCDExportHSDescriptionTxtArea).clear();
		driver.findElement(variantCDExportHSDescriptionTxtArea).sendKeys(sVariantCDExportHSDescriptionTxtArea);
	}

    public void setVariantCDImportHSCode(String sVariantCDImportHSCode) {
		
		driver.findElement(variantCDImportHSCode).click();
		driver.findElement(variantCDImportHSCode).clear();
		driver.findElement(variantCDImportHSCode).sendKeys(sVariantCDImportHSCode);
	}
	 
    public void setVariantCDImportHSDescriptionTxtArea(String sVariantCDImportHSDescriptionTxtArea) {
		
		driver.findElement(variantCDImportHSDescriptionTxtArea).click();
		driver.findElement(variantCDImportHSDescriptionTxtArea).clear();
		driver.findElement(variantCDImportHSDescriptionTxtArea).sendKeys(sVariantCDImportHSDescriptionTxtArea);
	}
    
	public void setVariantCDScheduleBNumberTxt(String sVariantCDScheduleBNumberTxt) {
			
			driver.findElement(variantCDScheduleBNumberTxt).click();
			driver.findElement(variantCDScheduleBNumberTxt).clear();
			driver.findElement(variantCDScheduleBNumberTxt).sendKeys(sVariantCDScheduleBNumberTxt);
		}
	
	public void setVariantCDScheduleBDescTxtArea(String sVariantCDScheduleBDescTxtArea) {
		
		driver.findElement(variantCDScheduleBDescTxtArea).click();
		driver.findElement(variantCDScheduleBDescTxtArea).clear();
		driver.findElement(variantCDScheduleBDescTxtArea).sendKeys(sVariantCDScheduleBDescTxtArea);
	}
	
	public void setVariantCDECCNTxt(String sVariantCDECCNTxt) {
		
		driver.findElement(variantCDECCNTxt).click();
		driver.findElement(variantCDECCNTxt).clear();
		driver.findElement(variantCDECCNTxt).sendKeys(sVariantCDECCNTxt);
	}
	   
	public void setVariantCDListPriceTxt(String sVariantCDListPriceTxt) {
		
		driver.findElement(variantCDListPriceTxt).click();
		driver.findElement(variantCDListPriceTxt).clear();
		driver.findElement(variantCDListPriceTxt).sendKeys(sVariantCDListPriceTxt);
	}

	public void setVariantCDNetWeightTxt(String sVariantCDNetWeightTxt) {
		
		driver.findElement(variantCDNetWeightTxt).click();
		driver.findElement(variantCDNetWeightTxt).clear();
		driver.findElement(variantCDNetWeightTxt).sendKeys(sVariantCDNetWeightTxt);
	}

	public void clickVariantCDSaveBtn() {
		
		driver.findElement(variantCDSaveBtn).click();
	}
	
	public void clickVariantCDCancelBtn() {
		
		driver.findElement(variantCDCancelBtn).click();
	}
	    
	public void clickVariantCDAddBtn() {
		
		driver.findElement(variantCDCountryAddBtn).click();
	}   
	
	 public String getProductCDDescription() {
	    	
	    	return driver.findElement(varintCDDescription).getText();
	    }
	    
	    
	 public void scrollIntoView(By xpathExp, String  sMoveUpDown) {
	    	WebElement element = driver.findElement(xpathExp);
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	if (sMoveUpDown.equals("DOWN"))
	    		js.executeScript("arguments[0].scrollIntoView(true);", element);	
	    	else
	    		js.executeScript("arguments[0].scrollIntoView(false);", element);
	    }
	 
	
	  //*************************Business Function ***********************************

   
	public void bfCreateProduct(String sProdName, String sProdDescription) throws InterruptedException {
		this.setProductName(sProdName);
		this.setProductDescription(sProdDescription);
		this.saveProductBtn();
		Thread.sleep(7000);

	}
	
   	
	public void bfCreateVaraintwithDefaultListValues(String sVarName, 
			                  String sVarDescp, 
			                  String sSku, 
			                  String sModelNo, 
			                  String sListPrice,
			                  String sNetWeight,
			                  String sGrossWeight,
			                  String sLength,
			                  String sWidth,
			                  String sHeight) throws InterruptedException {
		
		this.setVariantName(sVarName);
		this.setVariantDescription(sVarDescp);
		this.setVariantListPrice(sListPrice);
		//length
		this.scrollIntoView(variantHeightTxt,"DOWN");
		Thread.sleep(7000);
	//	
		this.setVariantLengthTxt(sLength);
		this.setVariantWidthTxt(sWidth);
		this.setVariantHeightTxt(sHeight);
		this.scrollIntoView(variantGrossWeightTxt,"UP");
		Thread.sleep(7000);
		this.setVariantSKU(sSku);
		this.setVariantModelNumber(sModelNo);
		this.setVariantNetWeight(sNetWeight);
		this.setVariantGrossWeight(sGrossWeight);
		this.clickVariantDetailsSaveBtn();
		Thread.sleep(7000);
	
		}
	
		public void bfCreateVaraintwithAllInput(String sVarName, 
									            String sVarDescp, 
									            String sSku, 
									            String sModelNo, 
									            String sCountry,
									            String sCurrency,
									            String sListPrice,
									            String sWeightUnit,
									            String sNetWeight,
									            String sGrossWeight,
									            String sDimUnit,
									            String sLength,
									            String sWidth,
									            String sHeight) throws InterruptedException {
									
				this.setVariantName(sVarName);
				this.setVariantDescription(sVarDescp);
				this.selectVariantCountryofOrigin(sCountry);
				this.selectVariantCurencyCode(sCurrency);
				this.setVariantListPrice(sListPrice);
				this.scrollIntoView(variantHeightTxt,"DOWN");
				this.selectVariantDimenssionUnit(sDimUnit);
				this.setVariantLengthTxt(sLength);
				this.setVariantWidthTxt(sWidth);
				this.setVariantHeightTxt(sHeight);
				this.scrollIntoView(variantGrossWeightTxt,"UP");
				this.setVariantSKU(sSku);
				this.setVariantModelNumber(sModelNo);
				this.selectVariantWeightUnit(sWeightUnit);
				this.setVariantNetWeight(sNetWeight);
				this.setVariantGrossWeight(sGrossWeight);
				this.clickVariantDetailsSaveBtn();
				Thread.sleep(7000);

		}

	
	public void bfCreateVariantCDCountrywithDefaultListValues(String sVariantCDCountryDescriptionTxt,
															String sVaraintCDLegalDescriptionTxtArea,
															String sVariantCDExportHSCodeTxt,
															String sVariantCDExportHSDescriptionTxtArea,
															String sVariantCDImportHSCode,
															String sVariantCDImportHSDescriptionTxtArea,
															String sVariantCDScheduleBNumberTxt,
															String sVariantCDScheduleBDescTxtArea,
															String sVariantCDECCNTxt,
															String sVariantCDListPriceTxt,
															String sVariantCDNetWeightTxt) throws InterruptedException {
		
		this.setVariantCDCountryDescriptionTxtArea(sVariantCDCountryDescriptionTxt);
		this.setVaraintCDLegalDescriptionTxtArea(sVaraintCDLegalDescriptionTxtArea);
		this.setVariantCDExportHSCodeTxt(sVariantCDExportHSCodeTxt);
		this.setVariantCDScheduleBNumberTxt(sVariantCDScheduleBNumberTxt);
		this.setVariantCDScheduleBDescTxtArea(sVariantCDScheduleBDescTxtArea);
		this.setVariantCDECCNTxt(sVariantCDECCNTxt);
		this.setVariantCDListPriceTxt(sVariantCDListPriceTxt);
		this.scrollIntoView(variantCDSaveBtn,"DOWN");
		this.setVariantCDExportHSDescriptionTxtArea(sVariantCDExportHSDescriptionTxtArea);
		this.setVariantCDImportHSCode(sVariantCDImportHSCode);
		this.setVariantCDImportHSDescriptionTxtArea(sVariantCDImportHSDescriptionTxtArea);
		this.setVariantCDNetWeightTxt(sVariantCDNetWeightTxt);
		this.clickVariantCDSaveBtn();
		Thread.sleep(7000);
	}

	public void bfCreateVariantCDCountrywithAllInput(String sCountry,
													String sCOCountry,
													String sVariantCDCountryDescriptionTxt,
													String sVaraintCDLegalDescriptionTxtArea,
													String sVariantCDExportHSCodeTxt,
													String sVariantCDExportHSDescriptionTxtArea,
													String sVariantCDImportHSCode,
													String sVariantCDImportHSDescriptionTxtArea,
													String sVariantCDScheduleBNumberTxt,
													String sVariantCDScheduleBDescTxtArea,
													String sVariantCDECCNTxt,
													String sCurrency,
													String sVariantCDListPriceTxt,
													String sWeightUnit,
													String sVariantCDNetWeightTxt) throws InterruptedException {
													
		Thread.sleep(3000);
		this.selectVariantCDCountry(sCountry);
		this.selectVariantCDCountryofOrigin(sCOCountry);
		this.setVariantCDCountryDescriptionTxtArea(sVariantCDCountryDescriptionTxt);
		this.setVaraintCDLegalDescriptionTxtArea(sVaraintCDLegalDescriptionTxtArea);
		this.setVariantCDExportHSCodeTxt(sVariantCDExportHSCodeTxt);
		this.setVariantCDScheduleBNumberTxt(sVariantCDScheduleBNumberTxt);
		this.setVariantCDScheduleBDescTxtArea(sVariantCDScheduleBDescTxtArea);
		this.setVariantCDECCNTxt(sVariantCDECCNTxt);
		this.selectVariantCDCurencyCode(sCurrency);
		this.scrollIntoView(variantCDSaveBtn,"DOWN");
		this.setVariantCDListPriceTxt(sVariantCDListPriceTxt);
		this.selectVariantCDWeightUnit(sWeightUnit);
		this.setVariantCDExportHSDescriptionTxtArea(sVariantCDExportHSDescriptionTxtArea);
		this.setVariantCDImportHSCode(sVariantCDImportHSCode);
		this.setVariantCDImportHSDescriptionTxtArea(sVariantCDImportHSDescriptionTxtArea);
		this.setVariantCDNetWeightTxt(sVariantCDNetWeightTxt);
		this.clickVariantCDSaveBtn();
		Thread.sleep(7000);

		}
	
}
