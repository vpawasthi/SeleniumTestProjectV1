package com.impledge.shipnauticv1.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Ignore;
//import org.testng.annotations.Test;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.impledge.shipnauticv1.utility.CaptureScreenshot;
import com.impledge.shipnauticv1.utility.readingProperty;

public class BaseTest {

	private static String sBaseURL = "https://lcc-qa.air-quest.com/signin";
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	private WebDriver driver;
	
	@BeforeSuite
	public void setupExtentReport() {

		htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir") +"/ExtentReport/LCCExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") +"/extent-config.xml");
		extent.setSystemInfo("OS", "WINDOWS 10");
		extent.setSystemInfo("Author", "Vinit Awasthi");
		extent.setSystemInfo("Enviornment", "QA");
	}
	
	
	public WebDriver getDriver() {
		
		return driver;
	}
	
	
	@BeforeClass
	public void initializeTestBaseSetup() {
		try {
			setDriver();
			System.out.println("Before Class method in Base Class");

		} catch (Exception e) {
			System.out.println("Error....." + e.getStackTrace());
		}
	}
	
	private void setDriver() {
		
		driver=initDriver();
	}
	
	
	private WebDriver initDriver() {
		
		 String browserDriver = readingProperty.getSingleProperty("browserDriver.Browser");
		 // String browserDriver ="Chrome";
		  
		  System.out.println("Browser driver value: " + browserDriver);
				    
		  switch (browserDriver.toString()) {
		  case  "Chrome" :
		       	//System.setProperty("webdriver.chrome.driver","D:\\Softwares\\browserdrivers\\chromedriver.exe");
			  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"\\browser-driver\\chromedriver.exe");
				driver= new ChromeDriver(); 
				break;
		  case "FF" :
			  System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") +"\\browser-driver\\geckodriver.exe");  
			 // System.setProperty("webdriver.gecko.driver","D:\\Softwares\\browserdrivers\\geckodriver.exe"); 
		  		 driver= new FirefoxDriver();
		  		 break;
	      default :
		       System.out.println("Browser driver is not set");
		       driver=new ChromeDriver();
		  }
		  		 
		  driver.get(sBaseURL);
		  driver.manage().window().maximize();
		  return driver;
	
	}
		
			
	@AfterMethod
	public void getResult(ITestResult result) throws Exception
	{
	    if(result.getStatus() == ITestResult.FAILURE)
	    {
	        test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
	        test.fail(result.getThrowable());
	        String screenshotPath = CaptureScreenshot.getScreenshot(driver, result.getName());
	        //test.log(Status.FAIL,test.addScreenCaptureFromPath(screenshotPath));
	        test.fail(result.getName()).addScreenCaptureFromPath(screenshotPath);    
	       // test.log(Status.FAIL, "Test Case Fail",  MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	        
	    }
	    else if(result.getStatus() == ITestResult.SUCCESS)
	    {
	        test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
	    }
	    else
	    {
	        test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
	        test.skip(result.getThrowable());
	    }
	}

	@Ignore
	public void Test1() {
		test=extent.createTest("Stat Test 1");         
        test.pass("TestPass");
	    test.log(Status.PASS,"TestPASS");
		//extent.removeTest(test);
	
	}
	
	@Ignore 
	public void Test2() {
		
		test=extent.createTest("Stat Test 2");         
        test.pass("TestPass");
	    test.log(Status.FAIL,"TestPASS");
	    
		//extent.removeTest(test);
	
	}
	
	
	
	
	
	@AfterSuite
	public void teardown() {
	 driver.quit(); 	
	 extent.flush();	
	 
	}

		

}


