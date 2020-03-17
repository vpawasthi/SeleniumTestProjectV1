package com.impledge.shipnauticv1.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ParcelShipmentPO {
	
	
	  private WebDriver driver =null;
	  //  List <WebElement >  elements;

	
	    //ParcelShipment
        By parcelShipmentTab = By.xpath("//app-shipment-manage//mat-icon[contains(text(),'flight_takeoff')]");
		 //PackageType
        By packageTypeListBox =  By.xpath("//mat-select[@formcontrolname='packageType']");
		 //TotalVale
        By totalValueTxt = By.xpath("//input[@formcontrolname='value']");
        //Signature
        By signatureListBox= By.xpath("//mat-select[@formcontrolname='signature']");
	    //Weight
        By totalWeightTxt = By.xpath("//input[@formcontrolname='weight']");
		 //Weight Unit
        By weightUnitListBox = By.xpath("//mat-select[@formcontrolname='weightUnit']");
	    //Residential
        By residentialToggle = By.xpath("//mat-slide-toggle[@formcontrolname='residential']");
      //Insure
        By insureToggle = By.xpath("//mat-slide-toggle[@formcontrolname='insure']");
      //Saturday Delivery
        By saturdayDeliveryToggle = By.xpath("//mat-slide-toggle[@formcontrolname='saturdayDelivery']/label/div/input");
      //Additional Handling
        By additionalHandlingToggle = By.xpath("//mat-slide-toggle[@formcontrolname='additionalHandling']");
      // //Machinable
        By machinableToggle = By.xpath("//mat-slide-toggle[@formcontrolname='machinable']/label/div/input");
      //Test Label
        By testLabelToggle = By.xpath("//mat-slide-toggle[@formcontrolname='isTest']");
        /*
        
		 //Test Label
		 driver.findElement(By.xpath("//mat-slide-toggle[@id='mat-slide-toggle-8']//div[@class='mat-slide-toggle-bar']")).click();
		*/ 	  
		 //Calculate Rate
        By calculateRateBtn= By.xpath("//button/span/span[contains(text(),'Calculate Rate')]");
        
        //Customs Declaration
        By customDeclrationBtn = By.xpath("//button/span/span[contains(text(),'Customs Declaration')]");
	
		 //driver.findElement(By.xpath("//span[@class='mat-select-placeholder ng-tns-c14-562 ng-star-inserted']")).click();
		 //Service Box
		//By  serviceListBox = By.xpath("//mat-select[starts-with(@id,'mat-select-12')]");
		//By  serviceListBox = By.xpath("//*[@class='col-6']//mat-select[starts-with(@id,'mat-select-')]");
        By  serviceListBox = By.xpath("//*[@class='col-6']//descendant::mat-select[5]");
		String sServiceName="FEDEX_2_DAY (FEDEX)" ; //"Priority (USPS)";
		//Select Service Type
	//	 driver.findElement(By.xpath("//mat-option/span[text()=' "+sServiceName +" ']")).click(); 
		 
		 
		 //FedEx Refrence Option
		 By refFieldOneListbox = By.xpath("//mat-select[@formcontrolname='referenceOne']");
		 By refFieldTwoListbox = By.xpath("//mat-select[@formcontrolname='referenceTwo']");
		 By refFieldThreeListbox = By.xpath("//mat-select[@formcontrolname='referenceThree']");
		 
/*		 String sRefFieldOption="Customer Reference";
		 driver.findElement(By.xpath("//mat-option/span[text()=' "+sRefFieldOption +" ']")).click();
		 String sRefFieldOption1="Department Number";
		 driver.findElement(By.xpath("//mat-option/span[text()=' "+sRefFieldOption1 +" ']")).click();
		 String sRefFieldOption2="Purchase Order Number";
		 driver.findElement(By.xpath("//mat-option/span[text()=' "+sRefFieldOption2 +" ']")).click();
*/		
		 //FedEx RefrenceValue option	 
		 By refFieldValueOneTxt = By.xpath("//input[@formcontrolname='referenceOneValue']");
		 By refFieldValueTwoTxt = By.xpath("//input[@formcontrolname='referenceTwoValue']");
		 By refFieldValueThreeTxt = By.xpath("//input[@formcontrolname='referenceThreeValue']");

		 
		 //Ship For button
		 
		 By shipForBtn = By.xpath("//button/span/span[contains(text(),' Ship ')]");
		 
		 //Customs Declaration Dialog
		 
		 By applyBtn = By.xpath("//app-shipment-custom-declaration//button/span[contains(text(),'Apply')]");
				 
	   public ParcelShipmentPO(WebDriver driver) {
   	 
			this.driver=driver;
		}
	
		public void selectOptionVisibleText(String sOption) {
			By element = By.xpath("//mat-option/span[contains(text(),'"+sOption +"')]");
	    	 driver.findElement(element).click();
	      }
	
		public Boolean isParcelShipmentTab() {
			
			 String sLabel = driver.findElement(parcelShipmentTab).getText();
			 
			 System.out.println("Parcel Shipment Tab: "+sLabel);
			  
			  if (sLabel.equals("flight_takeoff") == true )
				  return true; 
			  else
				  return false;
			
		}
		
		
		public void selectPackageType(String sPackageName) {
	  		driver.findElement(packageTypeListBox).click();  
			//By element = By.xpath("//mat-option/span[text()=' "+sPackageName +" ']");
	    	 //driver.findElement(element).click();
	  		selectOptionVisibleText(sPackageName);
	      }

		public void setTotalShipmentValue(String sTotalValue) {
	  		driver.findElement(totalValueTxt).click();  
	  		driver.findElement(totalValueTxt).clear();
	  		driver.findElement(totalValueTxt).sendKeys(sTotalValue);
		      }
	  
		public void selectSignature(String sOption) {
			driver.findElement(signatureListBox).click(); 
			selectOptionVisibleText(sOption);
			}
	 
		public void setTotalWeightValue(String sTotalWeight) {
	  		driver.findElement(totalWeightTxt).click();  
	  		driver.findElement(totalWeightTxt).clear();
	  		driver.findElement(totalWeightTxt).sendKeys(sTotalWeight);
		      }
	
		public void selectWeightUnit(String sOption) {
			 driver.findElement(weightUnitListBox).click(); 
			 selectOptionVisibleText(sOption);
		 }
	  
		public void selectResidentialToggle() {
			 driver.findElement(residentialToggle).click(); 
		 }
	  
		public void selectInsureToggle() {
			 driver.findElement(insureToggle).click(); 
		 }
	  
		public void selectSaturdayDeliveryToggle() {
			 driver.findElement(saturdayDeliveryToggle).click(); 
		 }
	  
		public void selectAdditonalHandlingToggle() {
			 driver.findElement(additionalHandlingToggle).click(); 
		 }
	  
		public void selectMachinableToggle() {
			 driver.findElement(machinableToggle).click(); 
		 }
	  
		public void selectTestLabelToggle() {
			String value =driver.findElement(By.xpath("//mat-slide-toggle[@formcontrolname='isTest']/label/div/input")).getAttribute("aria-checked");
			if (value.equals("false")) {
				driver.findElement(testLabelToggle).click(); 
				}
			}
			

		public void selectRefFieldListBox(Integer iListBoxNo,String sOption) {
            String sSelectedText;
            
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            
	            switch (iListBoxNo) {
	            case 1 :
	    			driver.findElement(refFieldOneListbox).click();  
	    			break;	
	            case 2 :
	    			driver.findElement(refFieldTwoListbox).click();  
	    			break;
	            case 3 :
	    			driver.findElement(refFieldThreeListbox).click();  
	    			break;
	            default:
	    			driver.findElement(refFieldOneListbox).click();  
	    			break;
	            }
	            
	            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	            
	            switch (sOption) {
	            case "CR" :
	            	sSelectedText="Customer Reference";  
	            	break;
	            case "DN" :
	            	sSelectedText="Department Number";  
	            	break;
	            case "PON" :
	            	sSelectedText="Purchase Order Number";  
	            	break;
	            case "RMA" :
	            	sSelectedText="Return Merchandise Authorization";
	            	break;
	            default:
	            	sSelectedText="";  
	            	break;
	            }
            selectOptionVisibleText(sSelectedText);
			
			}
		
		public void setRefFieldValueOne(String sValue) {
	  		driver.findElement(refFieldValueOneTxt).click();  
	  		driver.findElement(refFieldValueOneTxt).clear();
	  		driver.findElement(refFieldValueOneTxt).sendKeys(sValue);
		      }
		
		public void setRefFieldValueTwo(String sValue) {
	  		driver.findElement(refFieldValueTwoTxt).click();  
	  		driver.findElement(refFieldValueTwoTxt).clear();
	  		driver.findElement(refFieldValueTwoTxt).sendKeys(sValue);
		      }
		
		public void setRefFieldValueThree(String sValue) {
	  		driver.findElement(refFieldValueThreeTxt).click();  
	  		driver.findElement(refFieldValueThreeTxt).clear();
	  		driver.findElement(refFieldValueThreeTxt).sendKeys(sValue);
		      }
		
		public void clickCalcualteRate() {
	  		driver.findElement(calculateRateBtn).click();  
	  		  }
	
		public void clickCustomDeclaration() {
	  		driver.findElement(customDeclrationBtn).click();  
	  		  }
	
		public void applyCustomDeclarationDlg() {
	  		driver.findElement(applyBtn).click();  
	  		  }
	
		
		public void clickShipForBtn() {
	  		driver.findElement(shipForBtn).click();  
	  		
	  		  }
		
		public void selectCarrierServiceName(String sServiceName) {
			 driver.findElement(serviceListBox).click(); 
			 selectOptionVisibleText(sServiceName);
		 }
}
