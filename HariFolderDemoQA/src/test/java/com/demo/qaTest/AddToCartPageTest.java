package com.demo.qaTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.demo.base.TestBase;
import com.demo.qaPages.AddressBookPage;
import com.demo.qaPages.AddtoCartPage;
import com.demo.qaPages.HomePage;
import com.demo.qaPages.LoginPage;
import com.demo.qaPages.ShopByPage;
import com.demo.qaPages.ViewCartPage;



public class AddToCartPageTest extends TestBase {

	public AddToCartPageTest() throws Exception {
		super();
	}
	
	LoginPage loginPage;
	HomePage homePage;
	AddtoCartPage addToCartPage;
	ViewCartPage viewCartPage;
	AddressBookPage addressBookPage;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage(driver);
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		addToCartPage = new AddtoCartPage(driver);
		viewCartPage = new ViewCartPage(driver);
		addressBookPage = new AddressBookPage(driver);
		
	}
	
	
	@Test(priority = 2)
	public void ClickonProduct() throws Exception {
		homePage.clickOnNike2();
		addToCartPage.chooseSpecification();
		addToCartPage.clickAddtoCart();
		Assert.assertTrue(addToCartPage.isCartPopupDisplayed() , "Cart popup is not displayed!");
		viewCartPage.ViewCartDetails();
		viewCartPage.GoCheckOut();
		Assert.assertTrue(viewCartPage.isloggedinEmaildisplayed() , "abc1998@gmail.com");
		addressBookPage.enterDetails();
		Assert.assertTrue(viewCartPage.iserrorsaveisDisplayed() , "Failed to save note");
		System.out.println("Success");
		
		
	}
		

}
