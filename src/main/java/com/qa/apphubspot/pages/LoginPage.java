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

public class LoginPage extends BasePage {
	
	//1. Page objects with the help of: PageFactory
	@FindBy(id = "username")
	WebElement emailId;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "loginBtn")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a/i18n-string[contains(text(),'Forgot my password')]")
	WebElement forgotPwdLink;
	
	
	//2. create a constructor of page class and initialize page elements
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//3. Methods/Actions of page:
	public String getLoginPagetitle() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains(Constants.LOGIN_PAGE_TITLE));
		 return driver.getTitle();
	
	}

	public boolean verifyForgotPasswordLink() {
		return forgotPwdLink.isDisplayed();
	}
	
	public HomePage login(String un, String pwd ) {
		emailId.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage(driver);
		

		
	}

}
