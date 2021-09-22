package com.susheel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.susheel.utils.SeleniumUtils;

public class MyinfoPage {
	
	WebDriver driver;
	
	SeleniumUtils seleniumUtils;

	@FindBy(css="input#btnSave") public WebElement edit;
	
	@FindBy(css="input#personal_txtEmpFirstName") public WebElement firstName;
	
	@FindBy(id="personal_txtEmpLastName") public WebElement lastName;
	
	@FindBy(id="personal_txtLicExpDate") public WebElement calendar;
	
	@FindBy(css="select[data-handler='selectMonth']") public WebElement month;
	
	@FindBy(css="select[data-handler='selectYear']") public WebElement year;
	
	@FindBy(xpath="//a[text()='10']") public WebElement date;
	
	@FindBy(id="personal_optGender_2") public WebElement gender;
	
	@FindBy(id="personal_cmbNation") public WebElement nationality;
	
	@FindBy(id="btnSave") public WebElement save;
	
	public MyinfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		seleniumUtils = new SeleniumUtils();
	}
	
	public void editMyProfile() {
		seleniumUtils.clickOnElement(edit);
	}
	
	public void enterFirstName(String firstname) {
		seleniumUtils.enterText(firstName, firstname);
	}
	
	public void enterLastName(String lastname) {
		seleniumUtils.enterText(lastName, lastname);
	}
	
	public void calendarSelect() {
		seleniumUtils.clickOnElement(calendar);
	}
	
	public void selectMonth() {
		seleniumUtils.selectDropDownValue(month, "Nov");
	}
	
	public void selectYear() {
		seleniumUtils.selectDropDownValue(year, "2022");
	}
	
	public void selectDate() {
		seleniumUtils.clickOnElement(date);
	}
	
	public void selectGender() {
		seleniumUtils.clickOnElement(gender);
	}
	
	public void selectNationality() {
		seleniumUtils.selectDropDownValue(nationality, "Belarusian");
	}
	
	public void savePage() {
		seleniumUtils.clickOnElement(save);
	}
}
