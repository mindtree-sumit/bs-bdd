package com.bdd.stepdefinition;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.bdd.utilities.BrowserFactory;
import com.bdd.utilities.ConfigDataProvider;
import com.bdd.utilities.ExcelDataProvider;
import com.bdd.utilities.SSTaker;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;

public class BaseClass {

	public static WebDriver driver;
	public static Actions action;
	public static ExcelDataProvider excel;
	public static ConfigDataProvider config;
	public static ExtentReports report;
	public static ExtentTest logger;
	public static ExtentSparkReporter extent;
	
	

//	@BeforeSuite
//	public void setUpSuite() {
//		excel = new ExcelDataProvider();
//		config = new ConfigDataProvider();

//		extent = new ExtentSparkReporter(
//				new File(System.getProperty("user.dir") + "/Reports/BS" + SSTaker.getCurrentDateTime() + ".html"));
//		report = new ExtentReports();
//		report.attachReporter(extent);
//	}

//	@BeforeTest
//	public WebDriver setup() {
//		driver = BrowserFactory.startApp(driver, config.getBrowser(), config.getStagingURl());
//		action = new Actions(driver);
//		return driver;
//	}
	
//	@BeforeMethod
	public WebDriver setup() {
		driver = BrowserFactory.startApp(driver, "Chrome", "https://www.bigsmall.in/");
		action = new Actions(driver);
		return driver;
	}

//	@AfterMethod()
//	public void teardown() {
//		BrowserFactory.quitBrowser(driver);
//	}
	
//	@AfterMethod
//	public void endBrowser() {
//		BrowserFactory.quitBrowser(driver);
//	}
	
	@AfterMethod(enabled = true)
	public void tearDownMethod(ITestResult result) {
		logger=report.createTest(result.getName());
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.fail("Test Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(SSTaker.captureScreenShot(driver)).build());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.pass("Test Passed",
					MediaEntityBuilder.createScreenCaptureFromPath(SSTaker.captureScreenShot(driver)).build());
		}
		report.flush();
		BrowserFactory.quitBrowser(driver);
	}
	
//	@AfterStep
//	public void tearDownMethod1(ITestResult result) {
//		logger=report.createTest(result.getName());
//		if (result.getStatus() == ITestResult.FAILURE) {
//			logger.fail("Test Failed",
//					MediaEntityBuilder.createScreenCaptureFromPath(SSTaker.captureScreenShot(driver)).build());
//		} else if (result.getStatus() == ITestResult.SUCCESS) {
//			logger.pass("Test Passed",
//					MediaEntityBuilder.createScreenCaptureFromPath(SSTaker.captureScreenShot(driver)).build());
//		}
//		report.flush();
//	}
	
}
