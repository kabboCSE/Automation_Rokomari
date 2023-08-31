package com.rokomari.tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.rokomari.drivers.BaseDriver;
import com.rokomari.drivers.PageDriver;
import com.rokomari.pages.MainPage;
import com.rokomari.utilities.ExtentFactory;

public class MainPageTest extends BaseDriver{
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	@BeforeClass
	public void openUrl() {
		PageDriver.getCurrentDriver().manage().window().maximize();
		PageDriver.getCurrentDriver().get(url);
		
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>MAIN PAGE TEST</b></p>").assignAuthor("MainPageModule").assignDevice("Windows 10");
	}

	@Test(priority=0)	
	public void homePageTest() throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Main Page Test</b></p>");
		MainPage mainpage = new MainPage(childTest);
		//HomePage homePage = new HomePage();
		mainpage.signin();	
		
	}
	@AfterClass
	public void afterClass() {
		report.flush();
	}

	

}
