package com.impledge.shipnauticv1.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPO {

	    private WebDriver driver =null;
	    List <WebElement >  elements;
	
	    By homeHeaderBtn =By.xpath("//text()[.='home']/ancestor::button[1]");
	
	    By contactHeaderBtn = By.xpath("//text()[.='people']/ancestor::button[1]");
	    By productHeaderBtn = By.xpath("//text()[.='unarchive']/ancestor::button[1]");
	    By orderHeaderBtn = By.xpath("//text()[.='description']/ancestor::button[1]");

	    By createNewOrderBtn =By.xpath("//text()[.='add']/ancestor::button[1]"); 

	    By sourceCreateOrderBtn = By.xpath("/html[1]/body[1]/app-root[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/app-header[1]/mat-toolbar[1]/button[2]"); 

	    By leftMenuBtn = By.xpath("//text()[.='menu']/ancestor::button[1]");

	    By selectSource = By.xpath("//span[text()='ManualSource01']");   //wrong xpath

	    By serachName= By.cssSelector("input[placeholder='Search or add contact title']");

	    By taxIdType= By.cssSelector("mat-select[formcontrolname='taxIdType']"); 

	    By taxIdTxt= By.cssSelector("input[formcontrolname='taxIdNumber']"); 
	    
	    By Notes = By.cssSelector("textarea[formcontrolname='notes']"); 
	    
	    //By NotesMultiTxt= By Notes.first();

	    By contactTypeSel= By.cssSelector("mat-select[formcontrolname='addressTypes']"); 

	    By countrySel= By.cssSelector("mat-select[formcontrolname='country']"); 
	    
	    By address1Txt= By.cssSelector("input[formcontrolname='address1']"); 
	    By address2Txt= By.cssSelector("input[formcontrolname='address2']"); 
	    By address3Txt= By.cssSelector("input[formcontrolname='address3']"); 
	    By cityTxt= By.cssSelector("input[formcontrolname='city']"); 
	    
	    By stateSel= By.cssSelector("mat-select[formcontrolname='stateOrProvince']"); 

	    By zipTxt= By.cssSelector("input[formcontrolname='postalCode']"); 

	    By contactNameTxt= By.cssSelector("input[formcontrolname='name']"); 
	    By companyNameTxt= By.cssSelector("input[formcontrolname='company']"); 
	    By phoneTxt= By.cssSelector("input[formcontrolname='phoneNumber']"); 
	    By faxTxt= By.cssSelector("input[formcontrolname='fax']"); 
	    By emailTxt= By.cssSelector("input[formcontrolname='email']"); 
	    //By addressNotesMultiTxt= By Notes.last();
	    //By addressNotesMultiTxt= element.all(by.cssSelector('textarea[formcontrolname="notes"]'));

	    //By resedentialSel= By.cssSelector('mat-slide-toggle[formcontrolname="isResidential"]')); 
	    By resedentialSel= By.cssSelector("input[type='checkbox']"); 
   
	
	
	  public OrderPO(WebDriver driver) {
	    	 
	    	 this.driver=driver;
	     }
	   
	  public void clickHomeHeaderBtn() {
	    	 driver.findElement(homeHeaderBtn).click();
	      }
	   
	  public void clickOrderHeaderBtn() {
	    	 driver.findElement(orderHeaderBtn).click();
	      }
	  
	  public void clickSourceCreateBtn() {
	    	 driver.findElement(sourceCreateOrderBtn).click();
	      }
	  
	  public void selectSource() {
	    	 driver.findElement(selectSource).click();
	      }
	  
	  public void clickLeftMenuBtn() {
	    	 driver.findElement(leftMenuBtn).click();
	      }
	  
	  public void setSearchName(String sSearchContact) {
	         driver.findElement(serachName).sendKeys(sSearchContact);       	
	    	 	 
	     }
	  
	  
	  
	  
	  public void setTaxNumber(String sTaxNumber) {
	         driver.findElement(taxIdTxt).sendKeys(sTaxNumber);       	
	    	 	 
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
	  
	  public void setContactName(String sContactName) {
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
	  
	  public void setContactNotes(String sContactNotes) {
	        // driver.findElements(Notes).indexOf(1).sendKeys(sContactNotes);       	
	    	 elements = 	 driver.findElements(Notes);
	    	 elements.get(0).sendKeys(sContactNotes);
	     }   
	  
	  public void setAddressNotes(String sAddNotes) {
		     elements = driver.findElements(Notes);
	    	 elements.get(1).sendKeys(sAddNotes);
	    	 	 
	     }
	  
}
