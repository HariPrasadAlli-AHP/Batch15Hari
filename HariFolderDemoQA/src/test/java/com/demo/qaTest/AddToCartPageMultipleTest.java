package com.demo.qaTest;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.demo.base.TestBase;
import com.demo.qaPages.AddtoCartPage;
import com.demo.qaPages.HomePage;
import com.demo.qaPages.LoginPage;



public class AddToCartPageMultipleTest extends TestBase {

	public AddToCartPageMultipleTest() throws Exception {
		super();
	}
	
	LoginPage loginPage;
	HomePage homePage;
	AddtoCartPage addToCartPage;
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage(driver);
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		addToCartPage = new AddtoCartPage(driver);
		
	}
	
	
	@Test(priority = 2)
	public void ClickonProduct() throws Exception {
		homePage.clickOnNike2();
		addToCartPage.chooseSpecification();
		addToCartPage.enterCountofProducts();
		addToCartPage.clickAddtoCart();
		Assert.assertFalse(addToCartPage.isCartPopupDisplayed() , "Cart popup is displayed!");
	}
	
	
	
	
	
	

}
