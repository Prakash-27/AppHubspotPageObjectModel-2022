package com.qa.apphubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.apphubspot.base.BasePage;
import com.qa.apphubspot.pages.ContactsPage;
import com.qa.apphubspot.pages.HomePage;
import com.qa.apphubspot.pages.LoginPage;
import com.qa.apphubspot.util.ContactsCreationUserDataUtil;
import com.qa.apphubspot.util.TestUtil;

public class ContactsPageTest {

	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	public HomePage homePage;
	public ContactsPage contactsPage;
	public ContactsCreationUserDataUtil userDataUtil;
	public String ContactsCredentials;
	public String ContactsCredentialsInfo[];

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
		contactsPage = homePage.gotoContactsPage();

		// extending BasePage Initialization.
		/*
		 * prop = init_properties(); String BrowserName = prop.getProperty("browser");
		 * driver = init_driver(BrowserName); driver.get(prop.getProperty("url"));
		 * loginPage = new LoginPage(driver); homePage = new HomePage(driver); homePage
		 * = loginPage.login(prop.getProperty("username"),
		 * prop.getProperty("password")); contactsPage = new ContactsPage(driver);
		 * contactsPage = homePage.gotoContactsPage();
		 */
	}

	@Test(priority = 1)
	public void createContactTest() {

		userDataUtil = new ContactsCreationUserDataUtil();
		ContactsCredentials = userDataUtil.getUserContactsInfo().get("CreateContactsData");
		ContactsCredentialsInfo = ContactsCredentials.split("_");

		contactsPage.createNewContact(ContactsCredentialsInfo[0], ContactsCredentialsInfo[1],
				ContactsCredentialsInfo[2], ContactsCredentialsInfo[3]);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
