package com.susheel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.susheel.utils.SeleniumUtils;

public class HomePage {

	WebDriver driver;
	SeleniumUtils seleniumUtils;
	
	@FindBy(xpath="//a[@id='welcome']") public WebElement welcome;
	
	@FindBy(css="a#menu_pim_viewMyDetails") public WebElement myProfileView;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		seleniumUtils = new SeleniumUtils();
	}
	
	public String retriveUserNameFromHomePage() {
		return seleniumUtils.retrieveText(welcome);
	}
	
	public void clickOnProfileButton() {
		seleniumUtils.clickOnElement(myProfileView);
	}
	
	
}
