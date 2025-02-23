package com.demo.qaPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddtoCartPage {

	WebDriver driver;
	WebDriverWait wait;

	By sizeChoose = By.xpath("//a[text()='M']");
	By colorChoose = By.xpath("//a[text()='Black']");
	By addToCartButton = By.xpath("//*[@class='button primary outline']");
	By popUpMessageCart = By.xpath("//*[text()='JUST ADDED TO YOUR CART']");
	By countOfProducts = By.xpath("//*[@name='qty']");
	

	public AddtoCartPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
	}

	public void chooseSpecification() throws Exception {
		driver.findElement(sizeChoose).click();
		Thread.sleep(3000);
		driver.findElement(colorChoose).click();
		Thread.sleep(3000);

	}

	public ViewCartPage clickAddtoCart() throws Exception {

		driver.findElement(addToCartButton).click();
		Thread.sleep(3000);
		return new ViewCartPage(driver);
	}

	public void enterCountofProducts() throws Exception {
		driver.findElement(countOfProducts).click();
		driver.findElement(countOfProducts).sendKeys("1000");
		Thread.sleep(3000);

	}

	public boolean isCartPopupDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(popUpMessageCart)).isDisplayed();
		} catch (TimeoutException e) {
			return false; // Return false if the popup is not found within 10 seconds
		}
	}
}
