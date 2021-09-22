package com.susheel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.susheel.utils.SeleniumUtils;

public class LoginPage {

	WebDriver driver;
	SeleniumUtils seleniumUtils;
	
	@FindBy(css="input#txtUsername") public WebElement txtUser;
	
	@FindBy(css="input#txtPassword") public WebElement txtPass;
	
	@FindBy(id="btnLogin") public WebElement btn;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		seleniumUtils = new SeleniumUtils();
	}
	
	public void enterUserName(String username) {
		seleniumUtils.enterText(txtUser, username);
	}

	public void enterPassword(String password) {
		seleniumUtils.enterText(txtPass, password);
	}
	
	public void clickButton() {
		seleniumUtils.clickOnElement(btn);
	}
	
}
