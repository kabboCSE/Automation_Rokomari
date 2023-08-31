package com.rokomari.pages;

import java.io.IOException;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.rokomari.drivers.PageDriver;
import com.rokomari.utilities.CommonMethods;
import com.rokomari.utilities.GetScreenShot;

import junit.framework.Assert;

public class GoogleSigninBtn extends CommonMethods{
	ExtentTest test;
	public GoogleSigninBtn(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(),this);
		this.test=test;
	}
		
	
//	@FindBys({
//		@FindBy(css="#js--browse-sidebar-form > div:nth-child(6) > div.product-sort__content.filter > div:nth-child(1)")
//		
//	})
//	WebElement categoryBox;
	
	@FindBys({
		@FindBy(xpath="//button[@class='btn btn-social-google']")
	})
	WebElement  GoogleSigninBtnn;
 
	

	public void GoogleClick() throws IOException {
		System.out.println("Method entered book");
		
		try{
			
			if(GoogleSigninBtnn.isDisplayed()) {
				
				GoogleSigninBtnn.click();
				System.out.println("SigninBtn clicked");
				timeout(5000);
				//timeout();
				test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>You have clicked GoogleSigninBtnn.</b></p>");
				@SuppressWarnings("unused")
				String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "GoogleSigninBtnn");
				String dest = System.getProperty("user.dir") + "\\screenshots\\" + "GoogleSigninBtnn.png";
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			}
			
		}catch(Exception e){
			test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>GoogleSigninBtnn is not locateable.Please check the error message.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "GoogleSigninBtnn");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "GoogleSigninBtnn.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(GoogleSigninBtnn.isDisplayed());
			PageDriver.getCurrentDriver().quit();
			
			System.out.println(e);
		}
		
		
	}
}