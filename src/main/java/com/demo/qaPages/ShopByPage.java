package com.demo.qaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopByPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	private By priceRange = By.xpath("//*[@class='max']"); // Locator for the slider handle
	private By shopMenu = By.xpath("(//*[contains(text(),'Shop')])[3]");
	private By menMenu = By.xpath("//a[text()='Men']");
	By AccountField = By.xpath("(//*[@fill='none'])[5]");
	
	@FindBy(xpath = "(//*[@viewBox='0 0 24 24'])[5]" )
	WebElement checkbox;
	
	public ShopByPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	
	public void menShoes() throws Exception {
		
		Thread.sleep(3000);
		driver.findElement(shopMenu).click();
		wait.until(ExpectedConditions.elementToBeClickable(menMenu)).click();
	}
	
	
	public void adjustPriceSlider(int xOffset) {
		WebElement slider = driver.findElement(priceRange);

		// Scroll into view if necessary
		((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", slider);

		// Drag the slider
		Actions actions = new Actions(driver);
		actions.clickAndHold(slider).moveByOffset(xOffset, 0) // Move horizontally
				.release().perform();
	}
	
	public boolean clickonCheckBox() {

		if(!checkbox.isSelected()) {
			checkbox.click();
			wait.until(ExpectedConditions.attributeToBe(checkbox, "aria-checked", "true"));
		}
		return checkbox.isSelected();
	}
	
}
