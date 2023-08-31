package com.rokomari.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.rokomari.drivers.PageDriver;
import com.rokomari.utilities.CommonMethods;
import com.rokomari.utilities.GetScreenShot;

import junit.framework.Assert;

public class MainPage extends CommonMethods{
	ExtentTest test;
	public MainPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}
	
	@FindBys({
	@FindBy(xpath="//button[@id='js--notification-btn-close']"),
		@FindBy(css="#js--notification-btn-close > img")
	})
	WebElement eliminateOffer1;

	@FindBys({
		@FindBy(xpath="//body/div[@id='js--entry-popup']/div[1]/button[1]/i[1]")
	})
	WebElement eliminateOffer2;
	@FindBys({
		@FindBy(xpath="//a[@id='js--authors']")
	})
	WebElement  writer;
	
	@FindBys({
		@FindBy(xpath="//a[contains(text(),'হুমায়ূন আহমেদ')]")
	})
	WebElement  selectWritter;
	
	public void signin() throws IOException {
		System.out.println("Method entered");
		Actions action = new Actions(PageDriver.getCurrentDriver());
		try{
			if(eliminateOffer1.isDisplayed()) {
				System.out.println("Eliminate Offer1 clicked");
				eliminateOffer1.click();
				timeout(5000);
				//timeout();
			}
		}catch(Exception e){
			System.out.println(e);
		}

		try{

			if(eliminateOffer2.isDisplayed()) {
				System.out.println("Close Offer2 clicked");
				eliminateOffer2.click();
				timeout(5000);
				//timeout();
			}
		}catch(Exception e){
			System.out.println(e);
		}
		try{

			if(writer.isDisplayed()) {		
				
				action.moveToElement(writer).perform();	
				timeout();
				action.moveToElement(selectWritter).perform();	
				//Thread.sleep(5000);
				timeout();
				System.out.println("Hover and click Writter done");
				
				test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>successfully hovered writer.</b></p>");
				@SuppressWarnings("unused")
				String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "writer");
				String dest = System.getProperty("user.dir") + "\\screenshots\\" + "writer.png";
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			}
		}catch(Exception e){
			test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Writer is not locateable.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "writerLocator");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "writerLocator.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(writer.isDisplayed());
			PageDriver.getCurrentDriver().quit();
		}
		
		try{
			if(writer.isDisplayed()) {
				System.out.println("Selection Writer Done");		
				selectWritter.click();
				timeout();
				//timeout();
				
				test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>successfully selection writer.</b></p>");
				@SuppressWarnings("unused")
				String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "selectWritter");
				String dest = System.getProperty("user.dir") + "\\screenshots\\" + "selectWritter.png";
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			}
		}catch(Exception e){
			test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>selectWritter is not locateable.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "selectWritterLocator");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "selectWritterLocator.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(writer.isDisplayed());
			PageDriver.getCurrentDriver().quit();
		}
	}
}

