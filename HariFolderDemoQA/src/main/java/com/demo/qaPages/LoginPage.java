package com.demo.qaPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	
	WebDriverWait wait;
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10)); 
    }

	By userNameField = By.name("email");
	By passwordField = By.name("password");
	By submitButton = By.xpath("//button[@type='submit']");

	public HomePage login(String email, String password) {
		driver.findElement(userNameField).sendKeys(email);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(submitButton).click();
		return new HomePage(driver);

	}

}
