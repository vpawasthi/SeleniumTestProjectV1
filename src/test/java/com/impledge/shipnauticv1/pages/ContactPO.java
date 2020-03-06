package com.impledge.shipnauticv1.pages;

import java.awt.Desktop.Action;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContactPO {
	
	private WebDriver driver =null;
    List <WebElement >  elements;

    
  //**************************** First Panel Contact List************************************************
    By contactDeleteBtn = By.xpath("//app-customer-list/perfect-scrollbar//mat-card/div[@dialogicon='delete']/mat-icon[text(),'delete']");
    
 //**************************** Second Panel Contact Details************************************************ 
    By contactNameSp = By.xpath("//app-customer-detail//mat-expansion-panel[1]//div[@class='mat-list-text']/p[1]");
   
    By addressNameSp = By.xpath("//app-customer-detail//mat-expansion-panel[2]//mat-list-item//div[@class='mat-list-text']/span");
    
    By addressDeleteSp = By.xpath("//app-customer-detail//mat-expansion-panel[2]//mat-list-item//div[@appdialog='alert']/mat-icon[contains(text(),'delete')]");
    
    By addNewAddressBtn = By.xpath("//app-customer-detail//button/span/span[contains(text(),'New  Address')]");
	
    //Contact Third Panel
    //*******************Third Panel Customer Manage Web Elements **************************************

    By serachName= By.cssSelector("input[placeholder='Search or add contact title']");
    
    By contactName = By.xpath("//app-customer-manage//input[@formcontrolname='name']");

    By taxIdType= By.cssSelector("mat-select[formcontrolname='taxIdType']"); 

    By taxIdTxt= By.cssSelector("input[formcontrolname='taxIdNumber']"); 
    
    By Notes = By.xpath("//app-customer-manage//textarea[@formcontrolname='notes']"); 
    
    By saveContactBtn = By.xpath("//app-customer-manage//button/span/mat-icon[contains(text(),'check')]");
    
    //By NotesMultiTxt= By Notes.first();
    //*******************Third Panel Address Manage Web Elements **************************************
    
    By contactTypeSel= By.cssSelector("mat-select[formcontrolname='addressTypes']"); 
    String sContactType;
  //  By contactTypeOption= By.xpath("//mat-option/mat-pseudo-checkbox/span[contains(text(),'"+sContactType +"')]");
    
    By contactTypeDoneBtn = By.xpath("//div[@id='cdk-overlay-2']/div/div/span[contains(text(),'Done')]");
    
    By newAddressLabel = By.xpath("//app-address-manage/mat-toolbar/span[contains(text(),'New Address')]");
    
    By countrySel= By.cssSelector("mat-select[formcontrolname='country']"); 
    
    By address1Txt= By.cssSelector("input[formcontrolname='address1']"); 
    By address2Txt= By.cssSelector("input[formcontrolname='address2']"); 
    By address3Txt= By.cssSelector("input[formcontrolname='address3']"); 
    By cityTxt= By.cssSelector("input[formcontrolname='city']"); 
    
    By stateSel= By.cssSelector("mat-select[formcontrolname='stateOrProvince']"); 

    By zipTxt= By.cssSelector("input[formcontrolname='postalCode']"); 

    By contactNameTxt= By.xpath("//app-address-manage//input[@formcontrolname='name']"); 
    By companyNameTxt= By.cssSelector("input[formcontrolname='company']"); 
    By phoneTxt= By.cssSelector("input[formcontrolname='phoneNumber']"); 
    By faxTxt= By.cssSelector("input[formcontrolname='fax']"); 
    By emailTxt= By.cssSelector("input[formcontrolname='email']"); 
    //By addressNotesMultiTxt= By Notes.last();
    //By addressNotesMultiTxt= element.all(by.cssSelector('textarea[formcontrolname="notes"]'));

    By addressNotes = By.xpath("//app-address-manage//textarea[@formcontrolname='notes']");
    By resedentialSel= By.xpath("//mat-slide-toggle[@formcontrolname='isResidential']");
    
  //  By resedentialSel= By.cssSelector("input[type='checkbox']"); 
    
    By saveAddressBtn = By.xpath("//app-address-manage//button/span/mat-icon[contains(text(),'check')]");
    

    public ContactPO(WebDriver driver) {
   	 
   	 this.driver=driver;
    }
	
    public void selectOptionVisibleText(String sOption) {
		By element = By.xpath("//mat-option/span[contains(text(),'"+sOption +"')]");
    	 driver.findElement(element).click();
      }
	
    //**********Contact List First Panel *********************************** 
    
    public void selectContact_InListFP(String sContactName) {
		  By selectContact = By.xpath("//app-customer-list//mat-card//span[contains(text(),'"+ sContactName+"')]");
	    	 driver.findElement(selectContact).click();
	      }
 
    //**********Contact Details Second Panel ***********************************
    
    public String getContactNameSp() {
    	
    	return driver.findElement(contactNameSp).getText();
    }
    
       
    public String getFirstContactAddressSp() {
    	
    	return driver.findElement(addressNameSp).getText();
    }
    
    public  void clickFirstContactAddressSp() {
    	
    	 driver.findElement(addressNameSp).click();
    }
    
    public void clickAddNewAddressBtn() {
    	
    	driver.findElement(addNewAddressBtn).click();
    }
    
    
    //*******************Third Panel Customer Manage Methods **************************************
    
    private void setSearchName(String sSearchContact) {
   	 driver.findElement(serachName).sendKeys(sSearchContact);
   	  
   	  }
    
    public void selectSearchName(String sSearchName) {
  		this.setSearchName(sSearchName);
  		//By element = By.xpath("//mat-option/span[starts-with(text(),' "+sSearchName +"')]");
  		By element = By.xpath("//mat-option/span[contains(text(),' "+sSearchName +"')]");
  		//By element = By.xpath("//mat-option[@id='mat-option-332']"); //working fine 
  		
    	 driver.findElement(element).click();
	
      }
    
    public void setContactName(String sContactName) {
        driver.findElement(contactName).sendKeys(sContactName);       	
   	 	 
    }
    
    
    public void selecContactTaxIDType(String sTaxIdType) {
		
		 driver.findElement(taxIdType).click(); 
		 selectOptionVisibleText(sTaxIdType);
	}
    
    
    public void setTaxNumber(String sTaxNumber) {
        driver.findElement(taxIdTxt).sendKeys(sTaxNumber);       	
   	 	 
    }
    
	
    public void setContactNotes(String sContactNotes) {
           driver.findElement(Notes).sendKeys(sContactNotes);       	
    	 
    	 
     }   
  
    
    public void ClickContactSaveBtn() {
		
		 driver.findElement(saveContactBtn).click(); 
		 
	}
    //*******************Third Panel Address Manage Manage Methods **************************************
 
    public void selectContactType(String sContactType) {
    	driver.findElement(contactTypeSel).click();
       	selectOptionVisibleText(sContactType);
       	//clickNewAddressLebel();
      Actions action =  new Actions(driver);
      action.sendKeys(Keys.ESCAPE).build().perform();
      
     }
    
    public void clickNewAddressLebel() {
    	driver.findElement(newAddressLabel).click();
    }
    
    
    public void setAddress1(String sAddress1Input) {
        driver.findElement(address1Txt).sendKeys(sAddress1Input);       	
   	 	 
    }
  
 public void setAddress2(String sAddress2Input) {
        driver.findElement(address2Txt).sendKeys(sAddress2Input);       	
   	 	 
    }

 public void setAddress3(String sAddress3Input) {
        driver.findElement(address3Txt).sendKeys(sAddress3Input);       	
   	 	 
    }
 
 public void setCity(String sCity) {
        driver.findElement(cityTxt).sendKeys(sCity);       	
   	 	 
    }
 
 public void setZip(String sZip) {
        driver.findElement(zipTxt).sendKeys(sZip);       	
   	 	 
    }
 
 public void setContactAddressName(String sContactName) {
        driver.findElement(contactNameTxt).sendKeys(sContactName);       	
   	 	 
    }
 
 public void setCompanyName(String sCompanyName) {
        driver.findElement(companyNameTxt).sendKeys(sCompanyName);       	
   	 	 
    }
  
 public void setPhoneNumber(String sPhoneNo) {
        driver.findElement(phoneTxt).sendKeys(sPhoneNo);       	
   	 	 
    }
 public void setFaxNumber(String sFaxNo) {
        driver.findElement(faxTxt).sendKeys(sFaxNo);       	
   	 	 
    }
 public void setEmailId(String sEmail) {
        driver.findElement(emailTxt).sendKeys(sEmail);       	
   	 	 
    }
 

 public void setAddressNotes(String sAddNotes) {
	
	    driver.findElement(addressNotes).sendKeys(sAddNotes);
    }
 
    
	public void selectAddressCountry(String sCountryCodeORCountryName) {
		
		 driver.findElement(countrySel).click(); 
		 selectOptionVisibleText(sCountryCodeORCountryName);
	}
	    
	public void selectAddressState(String sStateCodeORStateName) {
		
		 driver.findElement(stateSel).click(); 
		 selectOptionVisibleText(sStateCodeORStateName);
	}
    
	public void selectResidentialToggle(String sClick) {
		if (sClick.equals("TRUE")) 
			driver.findElement(resedentialSel).click(); 
	 }
	public void ClickAddressSaveBtn() {
		
		 driver.findElement(saveAddressBtn).click(); 
		 
	}
	
	public void scrollIntoView(By xpathExp, String  sMoveUpDown) {
    	WebElement element = driver.findElement(xpathExp);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	if (sMoveUpDown.equals("DOWN"))
    		js.executeScript("arguments[0].scrollIntoView(true);", element);	
    	else
    		js.executeScript("arguments[0].scrollIntoView(false);", element);
    }
	
	//******************************************* Business Function of Contact *******************************************
	
	
	public void bfCreateContact(String sContactName,String sTaxIdType, String sTaxNumber, String sContactDescription) throws InterruptedException {
		
		this.setContactName(sContactName);
		this.selecContactTaxIDType(sTaxIdType);
		this.setTaxNumber(sTaxNumber);
		this.setContactNotes(sContactDescription);
		this.ClickContactSaveBtn();
		Thread.sleep(10000);
		
		
	}
	
	public void bfCreateShipToAddressInContactwithDefaultListValues(String sCountryCode,
																	String sAddress1Input,
																	String sAddress2Input, 
																	String sAddress3Input, 
																	String sCity, 
																	String sStateCodeORStateName,
																	String sZip,
																	String sContactName,
																	String sCompanyName,
																	String sPhoneNo,
																	String sFaxNo,
																	String sEmail,
																	String sAddNotes,
																	String sClick) throws InterruptedException {
		
		
		if (sCountryCode.equals(""))
			this.selectAddressCountry("US");  		
		else
			this.selectAddressCountry(sCountryCode);
		this.setAddress1(sAddress1Input);
		this.setAddress2(sAddress2Input);
		this.setAddress3(sAddress3Input);
		this.setCity(sCity);
		this.selectAddressState(sStateCodeORStateName);
		this.setZip(sZip);
		this.setContactAddressName(sContactName);
		this.setCompanyName(sCompanyName);
		this.setPhoneNumber(sPhoneNo);
		this.setFaxNumber(sFaxNo);
		this.setEmailId(sEmail);
		this.setAddressNotes(sAddNotes);
		this.selectResidentialToggle(sClick);
		this.ClickAddressSaveBtn();
		Thread.sleep(10000);
		
		
	}
	
	public void selectMultipleContactType( String sContactType) {
		
		this.selectContactType(sContactType);
		}
	
	
	public void selectMultipleContactTypes( String... sContactTypes) {
		
		for (String sContactType : sContactTypes) {
			this.selectContactType(sContactType);		
		}
		
	}
	
	
}
