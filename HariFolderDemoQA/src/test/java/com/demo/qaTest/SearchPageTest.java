package com.demo.qaTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demo.base.TestBase;
import com.demo.qaPages.HomePage;
import com.demo.qaPages.LoginPage;
import com.demo.qaPages.SearchPage;

public class SearchPageTest extends TestBase {
	public SearchPageTest() throws Exception {
		super();
	}

	LoginPage loginPage;
	SearchPage searchPage;
	public static HomePage homePage;

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage(driver);
		searchPage = new SearchPage(driver);
	}

	@Test
	public void login() throws InterruptedException {
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		Thread.sleep(3000);
		searchPage.enterTextinSearchField();
		Assert.assertTrue(searchPage.isResultsdisplayed(), "Unfortunately Results are displayed");

	}

}
