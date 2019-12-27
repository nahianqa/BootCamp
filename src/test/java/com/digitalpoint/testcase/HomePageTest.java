package com.digitalpoint.testcase;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.digitalpoint.elementlocator.HomePage;
import com.digitalpoint.elementlocator.LoginPage;
import com.digitalpoint.logdata.LogCollection;
import com.digitalpoint.utlities.BasePage;
import com.digitalpoint.utlities.Constant;

public class HomePageTest {
	WebDriver driver;
	LoginPage loginpage;
	BasePage basepage;
	Properties prop;
	HomePage homepage;

	@BeforeMethod
	public void browserSetup() {
		basepage = new BasePage();
		prop = basepage.init_properties();
		driver = basepage.getBrowser(prop);
		loginpage = new LoginPage(driver);
		homepage=loginpage.doLogin(prop.getProperty("username"),prop.getProperty("pwd"));
		LogCollection.debug("HomePage Log in successfull");

	}

	@Test
	public void verfyHomePageTitle() {
		String title=homepage.getHomePageTitle();
		System.out.println("The page title is " + title);
		Assert.assertEquals(title, Constant.Home_Page_title);
		LogCollection.debug("Verified  Home page Title");

	}
	@Test
	public void checkElement() {
		homepage.clickHomepageElement();
		LogCollection.debug("All tab on Hope page function properly");

	}
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
