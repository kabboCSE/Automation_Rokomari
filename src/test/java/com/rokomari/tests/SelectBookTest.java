package com.rokomari.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.IOException;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.rokomari.drivers.BaseDriver;
import com.rokomari.drivers.PageDriver;
import com.rokomari.pages.SelectBookPage;
import com.rokomari.utilities.ExtentFactory;

public class SelectBookTest extends BaseDriver{
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	@BeforeClass
	public void openUrl() {
		PageDriver.getCurrentDriver().manage().window().maximize();
		//PageDriver.getCurrentDriver().get(url);
		
		
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>BOOK SELECTION PAGE TEST</b></p>").assignAuthor("SelectBookModule").assignDevice("Windows 10");
	}
	
	@Test(priority=0)	
	public void selectbook() throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Book Selection Page Test</b></p>");
		SelectBookPage selectbookpage = new SelectBookPage(childTest);
		selectbookpage.cart();
		
	
	}
	@AfterClass
	public void afterClass() {
		report.flush();
	}

}