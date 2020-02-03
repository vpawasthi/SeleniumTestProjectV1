package com.impledge.shipnauticv1.reports;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportDemo {

		public static ExtentHtmlReporter htmlReporter;
		public static ExtentReports extent;
		public static ExtentTest test;

		
		@BeforeSuite
		public void setup() {
	
			htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir") +"/ExtentReport/LCCExtentReport.html");
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			htmlReporter.loadXMLConfig(System.getProperty("user.dir") +"/extent-config.xml");
		}
		
		
		@AfterMethod
		public void getResult(ITestResult result)
		{
		    if(result.getStatus() == ITestResult.FAILURE)
		    {
		        test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
		        test.fail(result.getThrowable());
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
	
		@Test(priority=1) 
		public void Test1() {
			test=extent.createTest("Stat Test 1");         
	        test.pass("TestPass");
		    test.log(Status.PASS,"TestPASS");
			//extent.removeTest(test);
		
		}
		
		@Test (priority=2)
		public void Test2() {
			
			test=extent.createTest("Stat Test 2");         
	        test.pass("TestPass");
		    test.log(Status.FAIL,"TestPASS");
		    
			//extent.removeTest(test);
		
		}
		
		@AfterSuite
		public void teardown() {
		
		 extent.flush();	
		}


	
		

	}


