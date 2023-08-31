package com.rokomari.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;



import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver {
	public static String url = "https://www.rokomari.com/book";
	WebDriver driver = null;
//check
	@BeforeSuite
	public void Start() {
		String browser = System.getProperty("browser", "chrome");
		

		if (browser.contains("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.contains("chrome")) {
			//To use your local chrome session
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\chrome-win64\\chrome.exe");
		options.addArguments("--user-data-dir=C:\\Users\\Kabbo\\AppData\\Local\\Google\\Chrome for Testing\\User Data");			
			driver = new ChromeDriver(options);
		} else {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		PageDriver.getInstance().setDriver(driver);
	}

	@AfterSuite
	public void close() {
		PageDriver.getCurrentDriver().quit();
	}

}
