package com.DemoHubspotWebsiteLaunch;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebPageLaunch {
	
  static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prakash\\eclipse-workspace\\AppHubspot_PoMProject\\drivers\\chromedriver.exe"); 
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Prakash\\eclipse-workspace\\AppHubspot_PoMProject\\drivers\\geckodriver.exe"); 

		  driver = new ChromeDriver();
		  
		  //driver = new FirefoxDriver();
		  
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		 driver.get("https://app.hubspot.com/login");
		 
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.urlToBe("https://app.hubspot.com/login"));
		 
		 try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 
		 driver.findElement(By.xpath("//input[@id='username' and @type='email']")).sendKeys("prakashs23007@gmail.com");
		 
		 driver.findElement(By.id("password")).sendKeys("Prakash@27041999");
		 
		 driver.findElement(By.id("loginBtn")).click();
		 
	}

}
