package com.susheel.tests;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.susheel.base.TestBase;
import com.susheel.helper.PropsHelper;
import com.susheel.pages.HomePage;
import com.susheel.pages.LoginPage;
import com.susheel.pages.MyinfoPage;

@Listeners(com.susheel.listeners.ListenerTest.class)

public class Seleniumdemo extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	MyinfoPage myInfoPage;
	Logger log;
	
	@BeforeClass
	public void setup() throws IOException {
		
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		myInfoPage = new MyinfoPage(driver);
		
		log = Logger.getLogger(Seleniumdemo.class);
		PropertyConfigurator.configure(System.getProperty("user.dir")+"/src/test/resources/log4j.properties");
	}

	@Test(priority = 0)
	public void validateTitle() throws InterruptedException {
	
		String actualTitle = driver.getTitle();
		log.info("Actual Titile is : "+ actualTitle );
		Assert.assertEquals(actualTitle, "OrangeHRM");
		
	}
	
		@Test(priority = 1)
		public void login() throws InterruptedException {
		Thread.sleep(3000);
		//USERNAME
		log.info("Username is : "+ phelper.getUsername() );
		loginPage.enterUserName(phelper.getUsername());
		
		Thread.sleep(3000);
		//PASSWORD
		log.info("Password is : "+ phelper.getPassword() );
		loginPage.enterPassword(phelper.getPassword());
		
		//LOGIN
		log.info("Clicked the Login Button" );
		loginPage.clickButton();
		
		//PRINTING WELCOME
		String welcome = homePage.retriveUserNameFromHomePage();
		log.info("User is on Home Page: " + welcome );
	//	Assert.assertEquals(welcome, "Welcome Tom");
		
		}

		@Test(priority = 2)
		public void myDetails() {
		//SELECT VIEW DETAILS
		log.info("User clicks on My Info Page and Edit Profile" );	
		homePage.clickOnProfileButton();
		myInfoPage.editMyProfile();
		
		//FIRSTNAME
		log.info("User enters Firstname: " + phelper.getFirstname() );
		myInfoPage.enterFirstName(phelper.getFirstname());
		}
		
		@Test(priority = 3)
		public void dateSelect() throws InterruptedException {
		//LASTNAME
		log.info("User enters Lastname: " + phelper.getLastname() );
		myInfoPage.enterLastName(phelper.getLastname());
		
		//SELECT DATE
		log.info("User selects calendar" );
		myInfoPage.calendarSelect();

		log.info("User selects month" );
		myInfoPage.selectMonth();
		
		log.info("User selects year" );
		myInfoPage.selectYear();
		
		log.info("User selects date" );
		Thread.sleep(3000);
		myInfoPage.selectDate();
		
		}
		
		@Test(priority = 4)
		public void gender() {
		//GENDER
		log.info("User selects gender" );
		myInfoPage.selectGender();
		}
		
		@Test(priority = 5)
		public void nationality() {
		//NATIONALITY
		log.info("User selects nationality" );
		myInfoPage.selectNationality();
		
		//SAVE
		log.info("User saves the page" );
		myInfoPage.savePage();
		
		}
		
		@Test(priority = 6)
		public void firstNameTest() {
			
		String ActFirstName = driver.findElement(By.cssSelector("input#personal_txtEmpFirstName")).getAttribute("value");
	//	Assert.assertEquals(ActFirstName, "Tom");
		
		}
	
		@Test(priority = 7)
		public void lastNameTest() {
			
		String ActLastName = driver.findElement(By.id("personal_txtEmpLastName")).getAttribute("value");
		Assert.assertEquals(ActLastName, "1234");
		System.out.println("Asssert Passed 1");
		
		}
		
		@Test(dependsOnMethods = "lastNameTest")
		public void dateTest() {
			
			String ActDate = driver.findElement(By.id("personal_txtLicExpDate")).getAttribute("value");
			Assert.assertEquals(ActDate, "2022-11-10");
		}

}
