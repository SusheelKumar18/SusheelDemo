package com.susheel.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SeleniumUtils {

	public void enterText(WebElement element, String txtToEnter) {
		clearElementText(element);
		element.sendKeys(txtToEnter);
	}
	
	public void clearElementText(WebElement element) {
		element.clear();
	}
	
	public void clickOnElement(WebElement element) {
		element.click();
	}
	
	public void selectDropDownValue(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByVisibleText(value);
	}
	
	public String retrieveText(WebElement element) {
		
		return element.getText();
	}
}
