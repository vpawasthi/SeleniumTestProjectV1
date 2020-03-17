package com.impledge.shipnauticv1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FreightShipmentPO {
	
	
	  private WebDriver driver =null;
	  
	  
	  //FreightShipment
      WebElement  freightShipmentTab = driver.findElement(By.xpath("//app-shipment-manage//div/mat-icon[contains(text(),'directions_boat')]"));
		 //PackageType
      WebElement packageTypeListBox =  driver.findElement(By.xpath("//mat-select[@formcontrolname='packageType']"));
		 //TotalVale
      WebElement totalValueTxt = driver.findElement(By.xpath("//input[@formcontrolname='value']"));
      //Weight
      WebElement totalWeightTxt = driver.findElement(By.xpath("//input[@formcontrolname='weight']"));
		 //Weight Unit
      WebElement weightUnitListBox = driver.findElement(By.xpath("//mat-select[@formcontrolname='weightUnit']"));

       //Insure
      WebElement insureToggle = driver.findElement(By.xpath("//mat-slide-toggle[@formcontrolname='insure']"));
      WebElement dangerousGoodsToggle = driver.findElement(By.xpath("//mat-slide-toggle[@formcontrolname='dangerousGoods']"));
      WebElement readyTime = driver.findElement(By.xpath("//input[@formcontrolname='readyTime']"));
      WebElement closeTime = driver.findElement(By.xpath("//input[@formcontrolname='closeTime']"));
      WebElement requestedDeliveryTime = driver.findElement(By.xpath("//input[@formcontrolname='requestedDeliveryTime']"));

      WebElement freightCarrierListBox = driver.findElement(By.xpath("//mat-select[@formcontrolname='freightCarrierId']"));
      WebElement freightCarrierContactLB = driver.findElement(By.xpath("//mat-select[@formcontrolname='freightCarrierContactAddressId']"));
      

      WebElement shipmentDescriptionTextArea = driver.findElement(By.xpath("//textarea[@formcontrolname='shipmentDescription']"));

      WebElement additionalInfoTextArea = driver.findElement(By.xpath("//textarea[@formcontrolname='additionalInfo']"));

      WebElement notifyEmailTxt = driver.findElement(By.xpath("//input[@formcontrolname='notify']"));
      
      WebElement bookFreightShipment = driver.findElement(By.xpath("//button/span[contains(text(),'Book Shipment']"));
      
      WebElement setTimeBtn = driver.findElement(By.xpath("//owl-date-time-container//button/span[contains(text(),'Set')]"));

      //PackageDetailsDialog
      
      WebElement noPiecesText = driver.findElement(By.xpath("//input[@formcontrolname='numberOfPieces']"));
      WebElement weightTxt = driver.findElement(By.xpath("//input[@formcontrolname='weight']"));
      WebElement lengthTxt = driver.findElement(By.xpath("//input[@formcontrolname='length']"));

      WebElement widthTxt = driver.findElement(By.xpath("//input[@formcontrolname='width']"));

      WebElement heightTxt = driver.findElement(By.xpath("//input[@formcontrolname='height']"));
      
      
      WebElement addFreightPackageDlgBtn = driver.findElement(By.xpath("//app-package-type-dimension//button/span[contains(text(),'+')]"));
      
      WebElement closeFreightPackageDlgBtn = driver.findElement(By.xpath("//app-package-type-dimension//button/span/mat-icon[contains(text(),'Close')]"));
      
      WebElement closeIconPackageBtn = driver.findElement(By.xpath("//app-package-type-dimension//button/span/mat-icon[contains(text(),'Close')][2]"));

      WebElement applyFreightPackageBtn = driver.findElement(By.xpath("//app-package-type-dimension//button/span[contains(text(),'Apply')]"));

      
      public FreightShipmentPO(WebDriver driver) {
    	   	 
			this.driver=driver;
		}
      
      public void selectOptionVisibleText(String sOption) {
			By element = By.xpath("//mat-option/span[contains(text(),'"+sOption +"']");
	    	 driver.findElement(element).click();
	      }
      
      
      public void freightShipmentBooking () {
    	  
    	  freightShipmentTab.click();
    	  selectFreightPackageType();
    	  readyTime.click();
    	  setTimeBtn.click();
    	  closeTime.click();
    	  setTimeBtn.click();
    	  requestedDeliveryTime.click();
    	  setTimeBtn.click();
    	  insureToggle.click();
    	  dangerousGoodsToggle.click();
    	  
    	  freightCarrierListBox.click();
    	  selectOptionVisibleText("Pacair");
    	  freightCarrierContactLB.click();
    	  selectOptionVisibleText("Pacair");
    	  shipmentDescriptionTextArea.sendKeys("xxxxxxxxxxxxxxxxxxxxxxxxx");
    	  additionalInfoTextArea.sendKeys("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
    	  notifyEmailTxt.click();
    	  notifyEmailTxt.sendKeys("awasthivinit@gmail.com");
    	  bookFreightShipment.click();
    	  
    	  
      }
      
      
      public void selectFreightPackageType() {
    	  packageTypeListBox.click();
    	  noPiecesText.sendKeys("2");
    	  weightTxt.sendKeys("5");
    	  lengthTxt.sendKeys("2");
    	  widthTxt.sendKeys("2");
    	  heightTxt.sendKeys("2");
    	  addFreightPackageDlgBtn.click();
    	  applyFreightPackageBtn.click();
    	  
      }
      
      
      
}
