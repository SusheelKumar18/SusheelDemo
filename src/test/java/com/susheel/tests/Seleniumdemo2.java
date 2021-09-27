//package com.susheel.tests;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import com.susheel.base.TestBase;
//import com.susheel.helper.PropsHelper;
//import com.susheel.helper.XlsReader;
//import com.susheel.pages.HomePage;
//import com.susheel.pages.LoginPage;
//import com.susheel.pages.MyinfoPage;
//
//public class Seleniumdemo2 extends TestBase {
//	
//	LoginPage loginPage;
//	HomePage homePage;
//	MyinfoPage myInfoPage;
//	XlsReader reader;
//	
//	String username;
//	String password;
//	String url;
//	String firstname;
//	String lastname;
//	String expectedTitle;
//	String month;
//	String year;
//	String country;
//	
//	@BeforeClass
//	public void setup() throws IOException {
//		
//		loginPage = new LoginPage(driver);
//		homePage = new HomePage(driver);
//		myInfoPage = new MyinfoPage(driver);
//		reader = new XlsReader("C:\\Users\\kumar\\eclipse-workspace\\SusheelDemo\\src\\test\\resources\\inputData.xlsx");
//		
//		username = reader.getCellData("testData", "username", 2);
//		password = reader.getCellData("testData", "password", 2);
//		url = reader.getCellData("testData", "url", 2);
//		firstname = reader.getCellData("testData", "firstname", 2);
//		lastname = reader.getCellData("testData", "lastname", 2);
//		expectedTitle = reader.getCellData("testData", "expectedTitle", 2);
//		month = reader.getCellData("testData", "month", 2);
//		year = reader.getCellData("testData", "year", 2);
//		country = reader.getCellData("testData", "country", 2);
//		
//	}
//
//	@Test(priority = 0)
//	public void validateTitle() throws InterruptedException {
//	
//		String ActualTitle = driver.getTitle();
//		Assert.assertEquals(ActualTitle, expectedTitle);
//	}
//	
//		@Test(priority = 1)
//		public void login() throws InterruptedException {
//		Thread.sleep(3000);
//		//USERNAME
//		loginPage.enterUserName(username);
//		
//		Thread.sleep(3000);
//		//PASSWORD
//		loginPage.enterPassword(password);
//		
//		//LOGIN
//		loginPage.clickButton();
//		
//		//PRINTING WELCOME
//		String welcome = homePage.retriveUserNameFromHomePage();
//		System.out.println(welcome);
//	//	Assert.assertEquals(welcome, "Welcome Tom");
//		
//		// TO check git hub
//		// and create a pull request
//		
//		}
//
//		@Test(priority = 2)
//		public void myDetails() {
//		//SELECT VIEW DETAILS
//		homePage.clickOnProfileButton();
//		myInfoPage.editMyProfile();
//		
//		//FIRSTNAME
//		myInfoPage.enterFirstName(firstname);
//		}
//		
//		@Test(priority = 3)
//		public void dateSelect() throws InterruptedException {
//		//LASTNAME
//		myInfoPage.enterLastName(lastname);
//		
//		//SELECT DATE
//		myInfoPage.calendarSelect();
//
//		myInfoPage.selectMonth();
//		
//		myInfoPage.selectYear();
//		
//		Thread.sleep(3000);
//		myInfoPage.selectDate();
//		
//		}
//		
//		@Test(priority = 4)
//		public void gender() {
//		//GENDER
//		myInfoPage.selectGender();
//		}
//		
//		@Test(priority = 5)
//		public void nationality() {
//		//NATIONALITY
//		myInfoPage.selectNationality();
//		
//		//SAVE
//		myInfoPage.savePage();
//		
//		}
//		
//		@Test(priority = 6)
//		public void firstNameTest() {
//			
//		String ActFirstName = driver.findElement(By.cssSelector("input#personal_txtEmpFirstName")).getAttribute("value");
//	//	Assert.assertEquals(ActFirstName, "Tom");
//		
//		}
//	
//		@Test(priority = 7)
//		public void lastNameTest() {
//			
//		String ActLastName = driver.findElement(By.id("personal_txtEmpLastName")).getAttribute("value");
//		Assert.assertEquals(ActLastName, "1234.0");
//		System.out.println("Asssert Passed 1");
//		
//		}
//		
//		@Test(dependsOnMethods = "lastNameTest")
//		public void dateTest() {
//			
//			String ActDate = driver.findElement(By.id("personal_txtLicExpDate")).getAttribute("value");
//			Assert.assertEquals(ActDate, "2022-11-10");
//		}
//
//}
