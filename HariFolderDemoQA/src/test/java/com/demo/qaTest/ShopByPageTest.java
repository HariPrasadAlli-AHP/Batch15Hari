package com.demo.qaTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demo.base.TestBase;
import com.demo.qaPages.AddtoCartPage;
import com.demo.qaPages.HomePage;
import com.demo.qaPages.LoginPage;
import com.demo.qaPages.ShopByPage;

public class ShopByPageTest extends TestBase {

	public ShopByPageTest() throws Exception {
		super();
	}

	LoginPage loginPage;
	public static HomePage homePage;
	ShopByPage shopByPage;

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage(driver);
		shopByPage = new ShopByPage(driver);
	}

	@Test
	public void login() throws Exception {
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		shopByPage.menShoes();
		shopByPage.adjustPriceSlider(20);
		shopByPage.clickonCheckBox();
		Assert.assertTrue(shopByPage.clickonCheckBox(), "Checkbox is not selected!");

	}

}
