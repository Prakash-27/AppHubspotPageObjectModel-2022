package com.qa.apphubspot.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.apphubspot.base.BasePage;

public class ContactsPage extends BasePage {

	@FindBy(xpath = "//span[text()='Create contact']")
	WebElement CreateContactBtn;

	@FindBy(id = "UIFormControl-1")
	WebElement email;

	@FindBy(id = "UIFormControl-3")
	WebElement firstName;

	@FindBy(id = "UIFormControl-7")
	WebElement lastName;

	@FindBy(id = "UIFormControl-15")
	WebElement Jobtitle;

	@FindBy(xpath = "//li//span[text()='Create contact']")
	WebElement ContactCreationBtn;
	

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void createNewContact(String emailIDValue, String firstname, String lastname, String jobtitle) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(ContactCreationBtn));
		CreateContactBtn.click();

		wait.until(ExpectedConditions.elementToBeClickable(email));
		email.sendKeys(emailIDValue);

		wait.until(ExpectedConditions.elementToBeClickable(firstName));
		firstName.sendKeys(firstname);

		wait.until(ExpectedConditions.elementToBeClickable(lastName));
		lastName.sendKeys(lastname);

		wait.until(ExpectedConditions.elementToBeClickable(Jobtitle));
		Jobtitle.sendKeys(jobtitle);

		wait.until(ExpectedConditions.elementToBeClickable(ContactCreationBtn));
		ContactCreationBtn.click();

	}

}
