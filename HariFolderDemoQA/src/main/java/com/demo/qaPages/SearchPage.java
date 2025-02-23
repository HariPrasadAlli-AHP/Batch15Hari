package com.demo.qaPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
	
	WebDriverWait wait;
	WebDriver driver;
	Actions act;
	
	public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        this.act = new Actions(driver);
    }
	
	private By SearchBar = By.xpath("(//*[@fill='none'])[3]");
	private By SearchFieldText = By.xpath("//*[@placeholder='Search']");
	By ResultsMessage = By.xpath("//*[text()='There is no product to display']");
	
	
	public void enterTextinSearchField() {
		driver.findElement(SearchBar).click();
		driver.findElement(SearchFieldText).click();
		WebElement searchField = driver.findElement(SearchFieldText);
        searchField.click();
		searchField.sendKeys("wwwwwwwwwwwwwwww");
		act.sendKeys(searchField, Keys.ENTER).build().perform();
		
	}
	
	public boolean isResultsdisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(ResultsMessage)).isDisplayed();
		} catch (TimeoutException e) {
			return false; // Return false if the popup is not found within 10 seconds
		}
	}
	
	

}
