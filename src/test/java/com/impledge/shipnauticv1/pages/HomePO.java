package com.impledge.shipnauticv1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.impledge.shipnauticv1.tests.BaseTest;

public class HomePO {
	
	private WebDriver driver =null;
    
	 By menuitemLogout = By.xpath("//mat-icon[text()='power_settings_new']");

	 By menuItemsVerticalOpener = By.xpath("//mat-icon[text()='more_vert']");
	   
	 By labelSubAccountRole = By.cssSelector("span[class='color-neon-green text-sm']");
	 
	 By homeHeaderBtn = By.xpath("//text()[.='home']/ancestor::button[1]");
	 
	 By orderHeaderBtn =  By.xpath("//text()[.='description']/ancestor::button[1]");
	 
	 By contactHeaderBtn = By.xpath("//text()[.='people']/ancestor::button[1]");
	 
	 By productHeaderBtn = By.xpath("//text()[.='unarchive']/ancestor::button[1]");
	 
	  By leftMenuBtn = By.xpath("//text()[.='menu']/ancestor::button[1]");
	  
	  By sourceCreateOrderBtn = By.xpath("//app-header/mat-toolbar/button[2]"); 
	 
	 By createNewBtn  = By.xpath("//button/span/mat-icon[contains(text(),'add')]");
	 
	 By searchHeaderText = By.xpath("//app-header/mat-toolbar/mat-form-field//div[@class='mat-form-field-infix']/input");
	 
	 By progressBar = By.xpath("//app-header/ng-progress/div[@class='ng-progress-bar ng-star-inserted']");
	
	  public HomePO(WebDriver driver) {
   	 
   	   this.driver=driver;
      }
   
	  
	  public void waitProgressBarComplete() {
		  
		  
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(progressBar));
		  
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
	
	public void clickContactHeaderBtn() {
	   driver.findElement(contactHeaderBtn).click();
	
	}
	
	public void clickHomeHeaderBtn() {
		   driver.findElement(homeHeaderBtn).click();
		}

	public boolean isLoggedInLCC() {

		try {
			
			if (driver.findElement(homeHeaderBtn).isDisplayed() == true)
				return true;
			
		}
		catch (NoSuchElementException e )
		{
			LoginPO LoginPage = new LoginPO(driver); 
			LoginPage.loginLCC(BaseTest.sUserName, BaseTest.sPassword);
			return true;
			//e.printStackTrace();
		}
		return false;
	}
	
	public void clickCreateNewBtn() {
		   driver.findElement(createNewBtn).click();
		
		}
	
	public void clickOrderHeaderBtn() {
		  driver.findElement(orderHeaderBtn).click();
		  
	}
		  
	
    public void ClickProductHeaderBtn() {
		
		driver.findElement(productHeaderBtn).click();
	}
    
    public void clickLeftMenuBtn() {
   	 driver.findElement(leftMenuBtn).click();
     }

    public void clickSourceCreateOrderBtn() {
   	 driver.findElement(sourceCreateOrderBtn).click();
     }
 
    public void selectSource(String sSourceName) {
		  By selectSource = By.xpath("//span[text()='"+sSourceName+"']");
	    	 driver.findElement(selectSource).click();
	      }
    
    public void scrollIntoView(By xpathExp ) {
    	WebElement element = driver.findElement(xpathExp);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
       	js.executeScript("arguments[0].scrollIntoView(true);", element);	
    }
    
    public void setHeaderSearchText(String sSearchedText) {
    	
    	driver.findElement(searchHeaderText).sendKeys(sSearchedText);
    }
    
}
