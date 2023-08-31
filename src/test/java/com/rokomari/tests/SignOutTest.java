package com.rokomari.tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.rokomari.drivers.BaseDriver;
import com.rokomari.drivers.PageDriver;
import com.rokomari.pages.SignOut;
import com.rokomari.utilities.ExtentFactory;

public class SignOutTest extends BaseDriver{
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	@BeforeClass
	public void OpenUrl() {
		PageDriver.getCurrentDriver().manage().window().maximize();
		
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>SIGNOUT PAGE TEST</b></p>").assignAuthor("SignOutModule").assignDevice("Windows 10");
	}
	@Test(priority=0)	
	public void signOutPageTest() throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Sign Out Page Test</b></p>");
		SignOut signout = new SignOut(childTest);
//		SignOutPage signOutPage = new SignOutPage();

		signout.signOut();
	}
	@AfterClass
	public void afterClass() {
		report.flush();
	}
}