package com.qa.apphubspot.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.apphubspot.base.BasePage;
import com.qa.apphubspot.constants.Constants;
import com.qa.apphubspot.util.TestUtil;

public class HomePage extends BasePage {

	@FindBy(xpath = "//h1[text()='User Guide']")
	WebElement homePageHeader;

	@FindBy(id = "nav-secondary-contacts")
	WebElement contactsTab;

	@FindBy(id = "nav-secondary-contacts")
	WebElement contactsLink;


	public HomePage(WebDriver driver) {
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}


	public String getHomePageTitle() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains(Constants.HOME_PAGE_TITLE));
		return driver.getTitle();
	}

	
	public boolean verifyHomePageHeader() {
		return homePageHeader.isDisplayed();
	}
	
	
	public ContactsPage gotoContactsPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(contactsTab));
		contactsTab.click();
		TestUtil.shortWait();
		contactsLink.click();
		return new ContactsPage(driver); 
		
	}

	





}
