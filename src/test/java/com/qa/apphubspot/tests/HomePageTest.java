package com.qa.apphubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.apphubspot.base.BasePage;
import com.qa.apphubspot.constants.Constants;
import com.qa.apphubspot.pages.ContactsPage;
import com.qa.apphubspot.pages.HomePage;
import com.qa.apphubspot.pages.LoginPage;
import com.qa.apphubspot.util.TestUtil;

public class HomePageTest {

	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	public HomePage homePage;
	public ContactsPage contactsPage;

	@BeforeMethod
	public void setUp() {

		// Without extending BasePage Initialization.

		basePage = new BasePage();
		prop = basePage.init_properties();
		String browser = prop.getProperty("browser");
		driver = basePage.init_driver(browser);
		driver.get(prop.getProperty("url"));
		TestUtil.longWait();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = new ContactsPage(driver);

		// extending BasePage Initialization.
		/*
		 * prop = init_properties(); String BrowserName = prop.getProperty("browser");
		 * driver = init_driver(BrowserName); driver.get(prop.getProperty("url"));
		 * loginPage = new LoginPage(driver); homePage = new HomePage(driver); homePage
		 * = loginPage.login(prop.getProperty("username"),
		 * prop.getProperty("password")); contactsPage = new ContactsPage(driver);
		 */
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String title = homePage.getHomePageTitle();
		System.out.println("Home page title is: " + title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void verifyHomePageHeaderTest() {
		boolean header = homePage.verifyHomePageHeader();
		Assert.assertTrue(header, "Home Page Header is displayed");
	}

	@Test(priority = 3)
	public void goToContactsPageTest() {
		contactsPage = homePage.gotoContactsPage();
		Assert.assertEquals(homePage, contactsPage);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
