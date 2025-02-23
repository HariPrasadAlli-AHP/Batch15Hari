package com.demo.qaTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demo.base.TestBase;
import com.demo.qaPages.HomePage;
import com.demo.qaPages.LoginPage;

public class LoginTest extends TestBase{

	public LoginTest() throws Exception {
		super();
	}
	
	LoginPage loginPage;
	public static HomePage homePage;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage(driver);
	}
	
	@Test
	public void login() {
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		
	}
	
	
	
	

}
