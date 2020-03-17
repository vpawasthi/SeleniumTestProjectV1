/**
 * 
 */
package com.impledge.shipnauticv1.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author vinit.awasthi
 *
 */
public class OrderTPShipmentPO {
	
	 private WebDriver driver =null;
	    List <WebElement >  elements;
	    
	//Order Third panel Shipment Overflow menu options

		//Tracking Overflow Menu  
	    	By shipmentTPOverflowMenuOption = By.xpath("//app-shipment-track/mat-toolbar/button/span/mat-icon[contains(text(),'more_vert')]");
	    //Regenerate label
	    	By btnRegenrateLabel = By.xpath("//div[@class='cdk-overlay-pane']/div/div/button/span[contains(text(),'Regenerate Label')]");
	    //Reprint Carrier Document
	    	By btnReprintCarrierDocument = By.xpath("//div[@class='cdk-overlay-pane']/div/div/button/span[contains(text(),'Reprint Carrier Document')]");
		//Cancel/Refund
	        By btnCancelRefund = By.xpath("//div[@class='cdk-overlay-pane']/div/div/button[@dialogicon='cancel']");
		//Packing Slip
		    By btnPackingSlip = By.xpath("//div[@class='cdk-overlay-pane']/div/div/button[contains(.,'Packing Slip ')]");
		//Commercial Invoice 
		    By btnCommercialInvoice = By.xpath("//div[@class='cdk-overlay-pane']/div/div/button[contains(.,'Commercial Invoice ')]");
        //Cancel Booking		
		    By btnCancelBooking = By.xpath("//div[@class='cdk-overlay-pane']/div/div/button[contains(.,'Cancel Booking ')]");
		//Revise Booking
		    By btnReviseBooking = By.xpath("//div[@class='cdk-overlay-pane']/div/div/button[contains(.,' Revise Booking ')]");
		 //Close Shipment
		    By btnCloseShipment = By.xpath("//div[@class='cdk-overlay-pane']/div/div/button[contains(.,' Close Shipment ')]");
	    
	    public OrderTPShipmentPO(WebDriver driver) {
	    	 
	    	 this.driver=driver;
	     }
	
	    public void openOrderShipmentOverflowMenu() {
	    	driver.findElement(shipmentTPOverflowMenuOption).click();
	    }
	    
	    public void regenrateLabel() {
	    	openOrderShipmentOverflowMenu();
	    	driver.findElement(btnRegenrateLabel).click();
	    }
	    
	    public void reprintCarrierDocument() {
	    	openOrderShipmentOverflowMenu();
	    	driver.findElement(btnReprintCarrierDocument).click();
	    }
	    
	    public void openCancelRefundDlg() {
	    	openOrderShipmentOverflowMenu();
	    	driver.findElement(btnCancelRefund).click();
	    }
	    
	    public void oepnPackingSlipDlg() {
	    	openOrderShipmentOverflowMenu();
	    	driver.findElement(btnPackingSlip).click();
	    }
	    
	    public void openCommercialInvoiceDlg() {
	    	openOrderShipmentOverflowMenu();
	    	driver.findElement(btnCommercialInvoice).click();
	    }
	    
	    public void openFreightCancelBookingDlg() {
	    	openOrderShipmentOverflowMenu();
	    	driver.findElement(btnCancelBooking).click();
	    }
	    
	    public void openFreightReviseBookingDlg() {
	    	openOrderShipmentOverflowMenu();
	    	driver.findElement(btnReviseBooking).click();
	    }
	    
	    public void openCloseShipmentDlg() {
	    	openOrderShipmentOverflowMenu();
	    	driver.findElement(btnCloseShipment).click();
	    }
	    
}
