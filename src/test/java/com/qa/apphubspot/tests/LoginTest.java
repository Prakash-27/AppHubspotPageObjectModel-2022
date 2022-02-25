package com.qa.apphubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.apphubspot.base.BasePage;
import com.qa.apphubspot.constants.Constants;
import com.qa.apphubspot.pages.HomePage;
import com.qa.apphubspot.pages.LoginPage;
import com.qa.apphubspot.util.TestUtil;

public class LoginTest {

	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	public HomePage homePage;

	@BeforeMethod
	public void setUp() {

		// Without extending BasePage Initialization.

		basePage = new BasePage();
		prop = basePage.init_properties();
		String browsername = prop.getProperty("browser");
		driver = basePage.init_driver(browsername);
		driver.get(prop.getProperty("url"));
		TestUtil.longWait();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);

		// extending BasePage Initialization.
		/*
		 * prop = init_properties(); String BrowserName = prop.getProperty("browser");
		 * driver = init_driver(BrowserName); driver.get(prop.getProperty("url"));
		 * loginPage = new LoginPage(driver); homePage = new HomePage(driver);
		 */
	}

	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getLoginPagetitle();
		System.out.println("login page title is: " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, "login page title is not matched");
	}

	@Test(priority = 2)
	public void ForgotPasswordLinkTest() {
		boolean forgetpwdlink = loginPage.verifyForgotPasswordLink();
		System.out.println("ForgetPasswordLink is Displayed: " + forgetpwdlink);
		Assert.assertEquals(forgetpwdlink, "Forgot password link is not displayed");
	}

	@Test(priority = 3)
	public void Login_CorrectData_Test() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(loginPage, homePage);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
