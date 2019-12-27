package com.digitalpoint.elementlocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.digitalpoint.utlities.BasePage;

public class HomePage extends BasePage {
	WebDriver driver;

	By header = By.xpath("//span[text()='Digital Point Forum']");
	By userBalance = By.xpath("/html/body/div[3]/div[1]/ul/li[3]/a");
	By userBalanceHist = By.xpath("/html/body/div[3]/div[1]/ul/li[4]/a");
	By courseDoc = By.xpath("/html/body/div[3]/div[1]/ul/li[2]/a");
	//By userlogoutDrop = By.xpath("//*[@id='navbar-right']/li/a");
	By userlogout = By.xpath("//*[@id='navbar-right']/li/ul/li/a");

	By logoutdrop = By.xpath("//span[text()='Nahian-Faruqe -5185679997']");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}

	public String getHomePageTitle() {
		 return driver.getTitle();
	}
	
	public boolean verifyHomePageHeader() {
		return driver.findElement(header).isDisplayed();
	}
	 public void clickHomepageElement() {
		 driver.findElement(userBalance).click();
		 driver.findElement(userBalanceHist).click();
		 driver.findElement(courseDoc).click();

}
	
	public void logout() {
		driver.findElement(logoutdrop).click();
		driver.findElement(userlogout).click();
	}
	
}
