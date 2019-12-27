package com.digitalpoint.elementlocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.digitalpoint.utlities.BasePage;

public class LoginPage extends BasePage {
	
	WebDriver driver;
// page object/By locator
	By email = By.name("email");
	By password = By.name("password");
	By loginBtn = By.xpath("//button[@class='btn btn-primary pull-right']");
	By rememberme =By.className("styled");

	
	//login class constructor
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public String getTitle() {
		 return driver.getTitle();
	}
	
	
	
	public HomePage doLogin(String username, String pwd) {
		driver.findElement(email).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(rememberme).click();
		driver.findElement(loginBtn).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new HomePage(driver);
	}
}
