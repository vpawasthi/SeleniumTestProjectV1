package com.impledge.shipnauticv1.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

//import org.apache.commons.io.FileUtils;
//import org.testng.reporters.Files;

public class CaptureScreenshot {

	
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
		 
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		                //after execution, you could see a folder "FailedTestsScreenshots" under src folder
		
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
		
		File finalDestination = new File(destination);
		
		//FileUtils.copyFile(source, finalDestination);
		
		
		Files.copy(source, finalDestination);
		
		return destination;
		
	}
}
