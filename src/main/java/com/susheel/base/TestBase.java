package com.susheel.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.susheel.helper.PropsHelper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public WebDriver driver;
	public ChromeOptions chromeOptions;
	public PropsHelper phelper;
	
	@BeforeTest
	public void openBrowser() throws IOException {
		
		phelper = new PropsHelper();
		launchBrowser(phelper.getBrowserName());
		driver.get(phelper.getUrl());
		driver.manage().window().maximize();
	//	driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void closeBrowser() {
		
		driver.quit();
	}
	
	public void launchBrowser(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver" ,System.getProperty("user.dir")+"/src/test/resources/chromedriver.exe");
//			driver = new ChromeDriver();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")){
//			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/test/resources/geckodriver.exe");
//			driver = new FirefoxDriver();
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("headless")){
			chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless");
			System.setProperty("webdriver.chrome.driver" ,System.getProperty("user.dir")+"/src/test/resources/chromedriver.exe");
			driver = new ChromeDriver(chromeOptions);
		}
	}
}
