package com.demo.qaTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.demo.base.TestBase;
import com.demo.qaPages.AddtoCartPage;
import com.demo.qaPages.HomePage;
import com.demo.qaPages.LoginPage;
import com.demo.qaPages.ShopByPage;



public class AddToCartPageTest extends TestBase {

	public AddToCartPageTest() throws Exception {
		super();
	}
	
	LoginPage loginPage;
	HomePage homePage;
	AddtoCartPage addToCartPage;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage(driver);
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		addToCartPage = new AddtoCartPage(driver);
	}
	
	
	@Test(priority = 2)
	public void ClickonProduct() throws Exception {
		homePage.clickOnNike2();
		addToCartPage.chooseSpecification();
		addToCartPage.clickAddtoCart();
		Assert.assertTrue(addToCartPage.isCartPopupDisplayed() , "Cart popup is not displayed!");
	}
	
	
	
	
	
	

}
