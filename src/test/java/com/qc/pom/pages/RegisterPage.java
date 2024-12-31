package com.qc.pom.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "name")
	WebElement rNameLoc;
	
	@FindBy(id = "mobile")
	WebElement rMobileLoc;
	
	@FindBy(id = "email")
	WebElement rEmailLoc;
	
	@FindBy(id = "password")
	WebElement rPassLoc;
	
	@FindBy(tagName = "button")
	WebElement rSubmitBtn;
	
	public void enterName(String uName) {
		rNameLoc.clear();
		rNameLoc.sendKeys(uName);
	}
	
	public void enterMobile(String uMobile) {
		rMobileLoc.clear();
		rMobileLoc.sendKeys(uMobile);
	}
	
	public void enterEmail(String uEmail) {
		rEmailLoc.clear();
		rEmailLoc.sendKeys(uEmail);
	}
	
	public void enterPassword(String uPass) {
		rPassLoc.clear();
		rPassLoc.sendKeys(uPass);
	}
	
	public void clickOnSubmit() {
		rSubmitBtn.click();
	}
	
	public boolean handleAlert() {
		Alert alt = driver.switchTo().alert();
		String actResult = alt.getText();
		alt.accept();
		String expResult = "User registered successfully.";
		return actResult.equals(expResult);
	}
	
	public boolean verifyRegisterPageTitle() {
		String actTitle = driver.getTitle();
		String expTitle = "Queue Codes | Registration Page";
		return actTitle.equals(expTitle);
	}
	
	public void doRegisterWithDiffData(String uName, String uMobile, String uEmail, String uPass) {
		enterName(uName);
		enterMobile(uMobile);
		enterEmail(uEmail);
		enterPassword(uPass);
		clickOnSubmit();
	}
}
