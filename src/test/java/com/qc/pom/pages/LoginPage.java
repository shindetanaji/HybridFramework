package com.qc.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "email")
	WebElement emailLoc;
	
	@FindBy(id = "password")
	WebElement passLoc;
	
	@FindBy(id = "submit")
	WebElement signinBtn;
	
	@FindBy(linkText = "Register a new membership")
	WebElement regPageLink;
	
	public void enterEmail(String uName) {
		emailLoc.clear();
		emailLoc.sendKeys(uName);
	}
	
	public void enterPass(String uPass) {
		passLoc.clear();
		passLoc.sendKeys(uPass);
	}
	
	public void clickOnSubmit() {
		signinBtn.click();
	}
	
	public void clickOnRegPageLink() {
		regPageLink.click();
	}
	
	public boolean verifyLoginPageTitle() {
		String actTitle = driver.getTitle();
		String expTitle = "Queue Codes | Log in";
		return actTitle.equals(expTitle);
	}
	
	public DashboardPage doValidLogin(String uName, String uPass) {
		enterEmail(uName);
		enterPass(uPass);
		clickOnSubmit();
		return new DashboardPage(driver);
	}
	
	public void doInvalidLogin(String uName, String uPass) {
		enterEmail(uName);
		enterPass(uPass);
		clickOnSubmit();
	}
}
