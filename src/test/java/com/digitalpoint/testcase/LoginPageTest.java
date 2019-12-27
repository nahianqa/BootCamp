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

public class LoginPageTest {
	
	
WebDriver driver;
LoginPage loginpage;
BasePage basepage;
Properties prop;
HomePage homepage;


	@BeforeMethod
	public void browserSetup() {
		basepage= new BasePage();
		prop =basepage.init_properties();
		 driver =basepage.getBrowser(prop);
			loginpage = new LoginPage(driver);


	}
	
	
	@Test
	public void verfyLoginPageTitle() {
		String title=loginpage.getTitle();
		System.out.println("The page title is " + title);
		Assert.assertEquals(title, Constant.Login_Page_title);

	}
	
	@Test
	public void userlogin() {
		loginpage.doLogin(prop.getProperty("username"),prop.getProperty("pwd"));
		LogCollection.debug("logged in Successfully");

	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
