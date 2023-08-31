package com.rokomari.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
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

public class WriterPage extends CommonMethods{
	ExtentTest test;
	public WriterPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(),this);
		this.test=test;
	}
		
	
//	@FindBys({
//		@FindBy(css="#js--browse-sidebar-form > div:nth-child(6) > div.product-sort__content.filter > div:nth-child(1)")
//		
//	})
//	WebElement categoryBox;
	
	@FindBys({
		@FindBy(css="div[data-search-key=\"সমকালীন উপন্যাস Contemporary Novel \"]")		
	})
	WebElement uponnash;
	
	@FindBys({
//		@FindBy(css="div[data-search-key=\"শিশু-কিশোর উপন্যাস Novel: Children and Teens\"]")	
		@FindBy(css="div[data-search-key=\"সায়েন্স ফিকশন কালেকশন Science Fiction Collection\"]")	
	})
	WebElement sciencef;
	
	@FindBys({
		@FindBy(css="body > div.browse-page > div > div > div > section.browse__content > div.pagination > a:nth-child(3)")		
	})
	WebElement next;
	public void book() throws IOException {
		System.out.println("Method entered book");
		JavascriptExecutor js = (JavascriptExecutor) (PageDriver.getCurrentDriver());
		try{
			    System.out.println("Before scroll done");
			    js.executeScript("window.scrollBy(0,500)");
			    //Thread.sleep(3000);
			    timeout();			    
				System.out.println("After scroll done");
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		try {
			    System.out.println("Before rochona category scroll");
				sciencef.click();
				System.out.println("sciencef clicked");
				timeout();
				
				js.executeScript("window.scrollBy(0,500)");
				timeout();
				uponnash.click();
		        System.out.println("uponnash clicked");
				timeout();
				System.out.println("After category scroll");	
				
				test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>You have clicked Science Fiction and somokalin uponnash.</b></p>");
				@SuppressWarnings("unused")
				String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "uponnash");
				String dest = System.getProperty("user.dir") + "\\screenshots\\" + "uponnash.png";
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		}catch(Exception e) {
			test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Uponnash is not locateable.Please check the error message.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "uponnashLocator");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "uponnashLocator.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(uponnash.isDisplayed());
			PageDriver.getCurrentDriver().quit();
			System.out.println(e);
		}
		
		try {			
			js.executeScript("window.scrollBy(0,5100)");
			System.out.println("Next scroll done");
			timeout();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		try {			
			next.click();
			System.out.println("Next page click done");
			
			test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>You have clicked next.</b></p>");
			@SuppressWarnings("unused")
			String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "next");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "next.png";
			test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			timeout();
		}catch(Exception e) {
			test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Next is not locateable.Please check the error message.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "nextLocator");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "nextLocator.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(uponnash.isDisplayed());
			PageDriver.getCurrentDriver().quit();
			
			System.out.println(e);
		}
	}
}