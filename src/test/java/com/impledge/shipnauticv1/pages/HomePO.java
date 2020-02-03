package com.impledge.shipnauticv1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePO {
	
	private WebDriver driver =null;
    
	 By menuitemLogout = By.xpath("//mat-icon[text()='power_settings_new']");

	 By menuItemsVerticalOpener = By.xpath("//mat-icon[text()='more_vert']");
	   
	 By labelSubAccountRole = By.cssSelector("span[class='color-neon-green text-sm']");
	
	  public HomePO(WebDriver driver) {
   	 
   	   this.driver=driver;
      }
   
	  public String getSubAccountRoleName() {
	    	 return driver.findElement(labelSubAccountRole).getText();
	    	 
	     }
	   
	 public void openVerticalMenuItems() {
		 
		 driver.findElement(menuItemsVerticalOpener).click();
	 }
	
	
	public void logOutBtn() {
		driver.findElement(menuitemLogout).click();
	}

	public void LogOutApp() {
		this.openVerticalMenuItems();
        this.logOutBtn(); 		
	}
	
}
