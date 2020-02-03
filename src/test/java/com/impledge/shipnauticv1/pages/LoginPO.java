package com.impledge.shipnauticv1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPO {

     private WebDriver driver =null;
     
     
     By txtUserName = By.cssSelector("input[formcontrolname='email']");
     By txtPassword = By.cssSelector("input[formcontrolname='password']");
     By btnSignIn = By.xpath("//span[text()='Log in']");   
     By labelSubAccountRole = By.cssSelector("span[class='color-neon-green text-sm']");
     
     
     public LoginPO(WebDriver driver) {
    	 
    	 this.driver=driver;
     }
     

	
     public void setTxtUserName(String sUserName) {
       	 driver.findElement(txtUserName).sendKeys(sUserName);
     }
     
     public void setTxtPwd(String sPassword) {
         driver.findElement(txtPassword).sendKeys(sPassword);       	
    	 	 
     }
     
	
     public void clickBtnLogin() {
    	 driver.findElement(btnSignIn).click();
      }
     
     
     public String getSubAccountRoleName() {
    	 return driver.findElement(labelSubAccountRole).getText();
    	 
     }
     
	 	 
	 public void loginLCC(String sUserName,String sPassword) {
		 
		 this.setTxtUserName(sUserName);
		 this.setTxtPwd(sPassword);
		 this.clickBtnLogin();
		 		 	 
	 }
	 
	 
	
}
