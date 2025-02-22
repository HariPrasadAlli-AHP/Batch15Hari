package com.demo.qaTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demo.base.TestBase;
import com.demo.qaPages.AddressBookPage;
import com.demo.qaPages.HomePage;
import com.demo.qaPages.LoginPage;

public class AddressBookPageTest extends TestBase {

	public AddressBookPageTest() throws Exception {
		super();
	}

	LoginPage loginPage;
	AddressBookPage addressBookPage;
	public static HomePage homePage;

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage(driver);
		addressBookPage = new AddressBookPage(driver);

	}

	@Test
	public void login() throws Exception {
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		addressBookPage.AddressBookNavigate();
		addressBookPage.enterDetails();
		String actualMessage = addressBookPage.getSuccessMessage();
	    Assert.assertEquals(actualMessage, "Address has been saved successfully!", "Success message mismatch!");


	}
}
