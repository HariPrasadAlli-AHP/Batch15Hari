package com.demo.qaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriverWait wait;
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10)); 
    }

	By firstproduct = By.xpath("//*[text()='Nike react infinity run flyknit']");
	
	
	public AddtoCartPage clickOnNike2() {
		driver.findElement(firstproduct).click();
		return new AddtoCartPage(driver);
		
	}
}
