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

public class loginAfterSignOut extends CommonMethods {
	ExtentTest test;
	 public loginAfterSignOut(ExtentTest test) {
		 PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		 this.test=test;
	 }
 
	 @FindBys({
			@FindBy(xpath="//a[@id='js--authors']")
		})
		WebElement  writer;
	 
	 @FindBys({
			@FindBy(xpath="//button[@id='js--notification-btn-close']"),
				@FindBy(css="#js--notification-btn-close > img")
			})
			WebElement eliminateOfferFinal; 
	 
	 @FindBys({
			@FindBy(xpath="//a[@class='logged-out-user-menu-btn btn btn-secondary']")
		})
		WebElement  SigninBtn;
	 
	 @FindBys({
			@FindBy(xpath="//button[@class='btn btn-social-google']")
		})
		WebElement  GoogleSigninBtn;
	 
	 public void signingout() throws IOException {
			
//			Actions action = new Actions(PageDriver.getCurrentDriver());
					try{
						if(eliminateOfferFinal.isDisplayed()) {
							System.out.println("eliminateOfferFinal clicked");
							eliminateOfferFinal.click();
							timeout(5000);
							//timeout();							
						}						
					}			
					catch(Exception e){
						System.out.println(e);
			            }	 
	
			try{
				if(SigninBtn.isDisplayed()) {
					
					SigninBtn.click();
					System.out.println("SigninBtn clicked");
					//timeout();
					test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>You have clicked SigninBtn</b></p>");
					@SuppressWarnings("unused")
					String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "Signin");
					String dest = System.getProperty("user.dir") + "\\screenshots\\" + "Signin.png";
					test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
					timeout();
				}
			}
			catch(Exception e){
				test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>SigninBtn Not Found.</b></p>");
				Throwable t = new InterruptedException("Exception");
				test.fail(t);
				@SuppressWarnings("unused")
				String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "Signin");
				String dest = System.getProperty("user.dir") + "\\screenshots\\" + "Signin.png";
				test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
				Assert.assertTrue(SigninBtn.isDisplayed());
				PageDriver.getCurrentDriver().quit();
				
				System.out.println(e);
			}
			
	 }
			
 }	
			
			

	 

