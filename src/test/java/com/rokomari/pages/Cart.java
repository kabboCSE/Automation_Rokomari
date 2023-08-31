package com.rokomari.pages;

import java.io.IOException;


import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import com.rokomari.drivers.PageDriver;
import com.rokomari.utilities.CommonMethods;
import com.rokomari.utilities.GetScreenShot;

import junit.framework.Assert;

public class Cart extends CommonMethods{
	 
	ExtentTest test;
 public Cart(ExtentTest test) {
	 PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	 this.test=test;
 }
 
 @FindBys({
	 @FindBy(xpath="//body/div[@id='shipping-payment']/div[1]/div[1]")
 })
 WebElement shippingForm;
 
 
// @FindBys({
//	 @FindBy(xpath="//body/div[@id='shipping-payment']/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[2]/fieldset[1]/input[1]")
// })
// WebElement name;
 
 @FindBys({
	 @FindBy(xpath="//select[@id='js--city']")
 })
 WebElement city;
 
 @FindBys({
	 @FindBy(xpath="//select[@id='js--area']")
 })
 WebElement area;
 
 @FindBys({
	 @FindBy(css="#address")
 })
 WebElement detailAddress;
 
 @FindBys({
	 @FindBy(css="#shipping-payment > div > div > div.content__wrapper > form > div.content__wrapper--payment > div > div.card-body.pt-2 > div")
 })
 WebElement paymentDiv;
 @FindBys({
	 @FindBy(xpath="//body/div[@id='shipping-payment']/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/div[1]/label[1]")

 })
 WebElement cod;
 
 @FindBys({
	 @FindBy(xpath="//input[@class='js--primary-phone']")
 })
 WebElement phoneNo;
 
 @FindBys({
	 @FindBy(xpath="//input[@class='js--alternative-phone']")
 })
 WebElement phoneNo2;
 



 
 public void cartOrder() throws IOException {
//	 Actions action = new Actions(driver);
	 
	 try {
		 if(shippingForm.isDisplayed()) {
//				action.keyDown(Keys.CONTROL);
//				action.sendKeys("a");
//				action.keyUp(Keys.CONTROL);
//				action.build().perform();
//	     name.sendKeys("Kabbo");
//		 timeout();
		 
			 
		 phoneNo.click();
		 timeout();
		 phoneNo.sendKeys("012505789456");
		 
		 phoneNo2.click();
		 timeout();
		 phoneNo2.sendKeys("01356484781");
		 timeout();
		 
		 city.click();
		 timeout();
		 
		 Select selectCity = new Select(city);
		 selectCity.selectByIndex(2);
		 timeout();
		 
		 area.click();
		 timeout();
		 Select selectArea = new Select(area);
		 selectArea.selectByIndex(1);
		 timeout();

		 detailAddress.sendKeys("29/h, Abdul high Road\r\n" + "Zigatola, Dhaka\r\n" + "Banani, Dhaka");
		 timeout();
		 
		 System.out.println("Form Filled Up!");
		 
		 if(area.isDisplayed()) {
			 test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>You have successfully filled up form.</b></p>");
				@SuppressWarnings("unused")
				String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "detailAddress");
				String dest = System.getProperty("user.dir") + "\\screenshots\\" + "detailAddress.png";
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		 }
		 
			
		 }
 	}catch(Exception e) {
 		
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Detail Address is not locateable.Please check the error message.</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		@SuppressWarnings("unused")
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "detailAddressLocator");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "detailAddressLocator.png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		Assert.assertTrue(detailAddress.isDisplayed());
		PageDriver.getCurrentDriver().quit();
 		System.out.println(e);
    }
	 
 }
}
