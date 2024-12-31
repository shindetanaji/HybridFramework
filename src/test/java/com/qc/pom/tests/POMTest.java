package com.qc.pom.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qc.pom.pages.DashboardPage;
import com.qc.pom.pages.LoginPage;
import com.qc.pom.pages.RegisterPage;

public class POMTest extends BaseIntegration {

	@Test(dataProvider = "loginData")
	public void doLogin(String testName, String uName, String uPass) {
		LoginPage login = new LoginPage(driver);
		if (testName.equals("Both are valid")) {
			DashboardPage dash = login.doValidLogin(uName, uPass);
			Assert.assertTrue(dash.verifyHomePageTitle());
			dash.doLogout();
		} else {
			login.doInvalidLogin(uName, uPass);
			Assert.assertTrue(login.verifyLoginPageTitle());
		}
	}

	@Test(dataProvider = "registerData")
	public void doRegiter(String testName, String uName, String uMobile, String uEmail, String uPass) {
		if (driver.getTitle().equals("Queue Codes | Log in")) {
			LoginPage login = new LoginPage(driver);
			login.clickOnRegPageLink();
		}
		RegisterPage register = new RegisterPage(driver);
		register.doRegisterWithDiffData(uName, uMobile, uEmail, uPass);
		if (testName.equals("All are valid")) {
			Assert.assertTrue(register.handleAlert());
		}else {
			Assert.assertTrue(register.verifyRegisterPageTitle());
		}
	}
}
