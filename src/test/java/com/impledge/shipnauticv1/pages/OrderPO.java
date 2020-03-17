package com.impledge.shipnauticv1.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPO {

	    private WebDriver driver =null;
	    List <WebElement >  elements;
	   	
	    //**************************Header Panel*********************************
	/*
	 * By homeHeaderBtn =By.xpath("//text()[.='home']/ancestor::button[1]");
	 * 
	 * By contactHeaderBtn = By.xpath("//text()[.='people']/ancestor::button[1]");
	 * By productHeaderBtn =
	 * By.xpath("//text()[.='unarchive']/ancestor::button[1]"); By orderHeaderBtn =
	 * By.xpath("//text()[.='description']/ancestor::button[1]");
	 * 
	 * By createNewOrderBtn =By.xpath("//text()[.='add']/ancestor::button[1]");
	 * 
	 * // By sourceCreateOrderBtn = By.xpath(
	 * "/html[1]/body[1]/app-root[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/app-header[1]/mat-toolbar[1]/button[2]"
	 * );
	 * 
	 * By sourceCreateOrderBtn = By.xpath("//app-header/mat-toolbar/button[2]");
	 * 
	 * By leftMenuBtn = By.xpath("//text()[.='menu']/ancestor::button[1]");
	 * 
	 * // By selectSource =
	 * By.xpath("//button/span[contains(text(),'"+sSourceName+"']"); //wrong xpath
	 */
	    //*************************Middle Panel ***************************************

	   public By orderID= By.xpath("//app-order-detail//span[contains(text(),'Order -')]");
	    
        //From
	    
	    //To
	    
	    
	    
	    //Items
	   By itemCheckBoxSP = By.xpath("//mat-checkbox[@id='mat-checkbox-2']/label/div");
	   // By itemCheckBoxSP = By.xpath("//mat-checkbox[@id='mat-checkbox-2']//input");
        //Additional Info
	    
	    //Shipments
	    //Shipment item1  FedEx/USPS
        By shipmentItemListItem = By.xpath("//mat-nav-list/mat-list-item[1]/div/span");
	    
	    //Tag
	    
	    
	    //****************** Order Third Panel*********************
        By serachName = By.cssSelector("input[placeholder='Search or add contact title']");
        
        //*********************************************************************************************************************************************
	/*
	 * //Order.ShipTo.Contact Third Panel 
	 * 
	 * 
	 * By taxIdType= By.cssSelector("mat-select[formcontrolname='taxIdType']");
	 * 
	 * By taxIdTxt= By.cssSelector("input[formcontrolname='taxIdNumber']");
	 * 
	 * By Notes = By.cssSelector("textarea[formcontrolname='notes']");
	 * 
	 * //By NotesMultiTxt= By Notes.first();
	 * 
	 * By contactTypeSel=
	 * By.cssSelector("mat-select[formcontrolname='addressTypes']");
	 * 
	 * By countrySel= By.cssSelector("mat-select[formcontrolname='country']");
	 * 
	 * By address1Txt= By.cssSelector("input[formcontrolname='address1']"); By
	 * address2Txt= By.cssSelector("input[formcontrolname='address2']"); By
	 * address3Txt= By.cssSelector("input[formcontrolname='address3']"); By cityTxt=
	 * By.cssSelector("input[formcontrolname='city']");
	 * 
	 * By stateSel= By.cssSelector("mat-select[formcontrolname='stateOrProvince']");
	 * 
	 * By zipTxt= By.cssSelector("input[formcontrolname='postalCode']");
	 * 
	 * By contactNameTxt= By.cssSelector("input[formcontrolname='name']"); By
	 * companyNameTxt= By.cssSelector("input[formcontrolname='company']"); By
	 * phoneTxt= By.cssSelector("input[formcontrolname='phoneNumber']"); By faxTxt=
	 * By.cssSelector("input[formcontrolname='fax']"); By emailTxt=
	 * By.cssSelector("input[formcontrolname='email']"); //By addressNotesMultiTxt=
	 * By Notes.last(); //By addressNotesMultiTxt=
	 * element.all(by.cssSelector('textarea[formcontrolname="notes"]'));
	 * 
	 * //By resedentialSel=
	 * By.cssSelector('mat-slide-toggle[formcontrolname="isResidential"]')); By
	 * resedentialSel= By.cssSelector("input[type='checkbox']");
	 * 
	 * By saveCheckTickMark =
	 * By.xpath("//button/span/mat-icon[contains(text(),'check')]");
	 */	    
        By saveCheckTickMark = By.xpath("//button/span/mat-icon[contains(text(),'check')]");
	    ///*********************************************************************************************************************************************
	    
        By addNewProductToOrder = By.xpath("//app-product-variant/mat-toolbar/span[contains(text(),'Add a new product to Order')]"); 

	    // Item Search in third panel 
	    By addItemBtn = By.xpath("//button/span/mat-icon[contains(text(),'add')]");
	    //By searchItemBtn = By.xpath("//button/span/mat-icon[contains(text(),'add')]/following-sibling::button[1]"); // playlist_add
	    //By searchItemBtn = By.xpath("//button/span/mat-icon[contains(text(),'playlist_add')]"); // playlist_add
	    By searchItemBtn = By.xpath("//app-order-detail//mat-expansion-panel[3]//button/span/span[contains(text(),'Search')]"); // playlist_add
	    //By searchItemTxt = By.xpath("//div/label[contains(text(),'Search:')]//*[@class='mat-form-field-infix']/input");
	    
	    By searchItemTxt = By.xpath("//div[@class='col-7']//*[@class='mat-form-field-infix']/input");	    		
	    By itemCheckBoxTP = By.cssSelector("mat-checkbox[formcontrolname='isChecked']");
	    By itemQuantityTxt = By.cssSelector("input[formcontrolname='quantity']");
	    By itemLicenseSymbolTxt = By.cssSelector("input[formcontrolname='licenseSymbol']");
	    By itemSerialNumberTxt = By.cssSelector("input[formcontrolname='serialNumber']");
	    By saveSearchedItem = By.xpath("//app-product-multi//button/span/mat-icon[contains(text(),'check')]");
	    By selectItemRow1 = By.xpath("//mat-panel-title/div[contains(text(),'1')]");
	    
	    
	    						
   
	
	
	  public OrderPO(WebDriver driver) {
	    	 
	    	 this.driver=driver;
	     }
	  public void selectOptionVisibleText(String sOption) {
			By element = By.xpath("//mat-option/span[starts-with(text(),' "+sOption +" ')]");
	    	 driver.findElement(element).click();
	      }
	  
	
	  public String getOrderID() {
	    	 return driver.findElement(orderID).getText();

	      }
	  
	  
	  public void selectSearchName(String sSearchName) {
	  		this.setSearchName(sSearchName);
	  		//By element = By.xpath("//mat-option/span[starts-with(text(),' "+sSearchName +"')]");
	  		By element = By.xpath("//mat-option/span[contains(text(),' "+sSearchName +"')]");
	  		//By element = By.xpath("//mat-option[@id='mat-option-332']"); //working fine 
	  		
	    	 driver.findElement(element).click();
		
	      }
	  
	  	private void setSearchName(String sSearchContact) {
			  driver.findElement(serachName).sendKeys(sSearchContact);
			 
			  }
	  	
	  	
	  public Boolean isNewProductinOrderLabel() {
		  
		  String sLabel = driver.findElement(addNewProductToOrder).getText();
		  
       	 System.out.println("International Order - Add new product: "+sLabel);

		  if (sLabel.equals("Add a new product to Order") == true )
			  return true; 
		  else
			  return false;
	  }
	
	  ///*********************************************************************************************************************************************
	    
	/*
	 * //Header public void clickHomeHeaderBtn() {
	 * driver.findElement(homeHeaderBtn).click(); }
	 * 
	 * public void clickOrderHeaderBtn() {
	 * driver.findElement(orderHeaderBtn).click(); }
	 * 
	 * public void clickCreateNewOrderBtn() {
	 * driver.findElement(createNewOrderBtn).click(); }
	 * 
	 * 
	 * public void clickSourceCreateOrderBtn() {
	 * driver.findElement(sourceCreateOrderBtn).click(); }
	 * 
	 * public void selectSource(String sSourceName) { By selectSource =
	 * By.xpath("//span[text()='"+sSourceName+"']");
	 * driver.findElement(selectSource).click(); }
	 * 
	 * public void clickLeftMenuBtn() { driver.findElement(leftMenuBtn).click(); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * public void setTaxNumber(String sTaxNumber) {
	 * driver.findElement(taxIdTxt).sendKeys(sTaxNumber);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * public void setAddress1(String sAddress1Input) {
	 * driver.findElement(address1Txt).sendKeys(sAddress1Input);
	 * 
	 * }
	 * 
	 * public void setAddress2(String sAddress2Input) {
	 * driver.findElement(address2Txt).sendKeys(sAddress2Input);
	 * 
	 * }
	 * 
	 * public void setAddress3(String sAddress3Input) {
	 * driver.findElement(address3Txt).sendKeys(sAddress3Input);
	 * 
	 * }
	 * 
	 * public void setCity(String sCity) {
	 * driver.findElement(cityTxt).sendKeys(sCity);
	 * 
	 * }
	 * 
	 * public void setZip(String sZip) { driver.findElement(zipTxt).sendKeys(sZip);
	 * 
	 * }
	 * 
	 * public void setContactName(String sContactName) {
	 * driver.findElement(contactNameTxt).sendKeys(sContactName);
	 * 
	 * }
	 * 
	 * public void setCompanyName(String sCompanyName) {
	 * driver.findElement(companyNameTxt).sendKeys(sCompanyName);
	 * 
	 * }
	 * 
	 * public void setPhoneNumber(String sPhoneNo) {
	 * driver.findElement(phoneTxt).sendKeys(sPhoneNo);
	 * 
	 * } public void setFaxNumber(String sFaxNo) {
	 * driver.findElement(faxTxt).sendKeys(sFaxNo);
	 * 
	 * } public void setEmailId(String sEmail) {
	 * driver.findElement(emailTxt).sendKeys(sEmail);
	 * 
	 * }
	 * 
	 * public void setContactNotes(String sContactNotes) { //
	 * driver.findElements(Notes).indexOf(1).sendKeys(sContactNotes); elements =
	 * driver.findElements(Notes); elements.get(0).sendKeys(sContactNotes); }
	 * 
	 * public void setAddressNotes(String sAddNotes) { elements =
	 * driver.findElements(Notes); elements.get(1).sendKeys(sAddNotes);
	 * 
	 * }
	 * 
	 * public void clickShipToAddressSave() {
	 * driver.findElement(saveCheckTickMark).click(); }
	 */	  
	  ///*********************************************************************************************************************************************

	  	public void clickShipToAddressSave() {
	  	 driver.findElement(saveCheckTickMark).click(); 
	  	 }
	  	
	  	
	  public void selectOrderNo_InFirstPanel(String sOrderNo) {
		  By selectOrder = By.xpath("//span[@class='col-2 padding'][contains(text(),'"+ sOrderNo+"')]");
	    	 driver.findElement(selectOrder).click();
	      }
	  
	  public void selectItemCheckBoxInSecondPanel() {
	    	 driver.findElement(itemCheckBoxSP).click();
	      }
	  
	  public void selectShipmentsInSecondPanel(String sShipmentIndex) {
		     By shipmentItemListItem = By.xpath("//mat-nav-list/mat-list-item["+sShipmentIndex+"]/div/span");
	    	 driver.findElement(shipmentItemListItem).click();
	      }
	  
	
	  
	  // Item Search in third panel 
	  
	  public void clickAddNewItem() {
	    	 driver.findElement(addItemBtn).click();
	      }
	  
	  
	  public void clickSearchItem() {
	    	 driver.findElement(searchItemBtn).click();
	      }
	  
	  public void selectFirstRowItemTP() {
	    	 driver.findElement(selectItemRow1).click();
	      }
	  
	  public void setSearchedItemText(String searchedItem) {
	    	 driver.findElement(searchItemTxt).click();
	    	 driver.findElement(searchItemTxt).sendKeys(searchedItem);
	      }
	  
	  public void selectFirstItemCheckBoxTP() {
	    	 driver.findElement(itemCheckBoxTP).click();

	      }
	  
	  public void setQuantityItemText(String sQuantity) {
	    	 driver.findElement(itemQuantityTxt).click();
	    	 driver.findElement(itemQuantityTxt).clear();
	    	 driver.findElement(itemQuantityTxt).sendKeys(sQuantity);
	      }
	  
	  public void setLicenseSymbolText(String sLicenseSymbol) {
	    	 driver.findElement(itemLicenseSymbolTxt).click();
	    	 driver.findElement(itemLicenseSymbolTxt).sendKeys(sLicenseSymbol);
	      }
	  
	  public void setSerialNumberText(String sSerialNumber) {
	    	 driver.findElement(itemSerialNumberTxt).click();
	    	 driver.findElement(itemSerialNumberTxt).sendKeys(sSerialNumber);
	      }
	  
	  public void clickSaveSearchedItem() {
	    	 driver.findElement(saveSearchedItem).click();

	      }
	  
	  //*****************Business Function *******************************
	  
	  public void selectSearchedItem(String sSearchedItem, String sQuantity, String sLicenseNo, String sSerialNo) throws InterruptedException {
		
		  /*
		 * WebDriverWait wait = new WebDriverWait(driver,20);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(this.orderID));
		 */
			
		  		this.clickSearchItem();
		  		Thread.sleep(20000);
	           	WebDriverWait wait = new WebDriverWait(driver,20);
	   		    wait.until(ExpectedConditions.visibilityOfElementLocated(this.selectItemRow1));
			   	this.setSearchedItemText(sSearchedItem);
				Thread.sleep(10000);
		    	this.selectFirstRowItemTP();
				this.selectFirstItemCheckBoxTP();
				this.setQuantityItemText(sQuantity);
				this.setLicenseSymbolText(sLicenseNo);
				this.setSerialNumberText(sSerialNo);
				this.clickSaveSearchedItem();
				Thread.sleep(10000);

	    }
}
