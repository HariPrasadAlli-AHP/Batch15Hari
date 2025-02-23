package com.demo.qaPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewCartPage {
	
	WebDriverWait wait;
	WebDriver driver;
	
	By viewCart = By.xpath("//a[contains(text(), 'VIEW CART ')]");
	By checkout = By.xpath("//*[text()='CHECKOUT']");
	By loggedinemail = By.xpath("//*[text()='abc1998@gmail.com']");
	By errortosave = By.xpath("//*[text()='Failed to save note']");
	
	
	public ViewCartPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
	}
	
	public void ViewCartDetails() throws Exception {
		driver.findElement(viewCart).click();
		Thread.sleep(2000);
	}
	
	public void GoCheckOut() throws Exception {
		driver.findElement(checkout).click();
		Thread.sleep(2000);
		
		
	}
	
	public boolean isloggedinEmaildisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(loggedinemail)).isDisplayed();
		} catch (TimeoutException e) {
			return false; // Return false if the popup is not found within 10 seconds
		}
	}
	
	public boolean iserrorsaveisDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(errortosave)).isDisplayed();
		} catch (TimeoutException e) {
			return false; // Return false if the popup is not found within 10 seconds
		}
	}
	
	
	

}
