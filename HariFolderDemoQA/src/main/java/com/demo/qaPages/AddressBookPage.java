package com.demo.qaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AddressBookPage {
	
	WebDriverWait wait;
	WebDriver driver;
	WebElement countryDropdown;
	WebElement countryOption;
	
	WebElement provinceDropdown;
	WebElement provinceOption;
	
	public AddressBookPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10)); 
    }
	
	private By AccountField = By.xpath("(//*[@fill='none'])[5]");
	private By addressBookclick = By.xpath("//*[text()='Add new address']");
	private By firstName = By.xpath("//*[@name='address[full_name]']");
	private By telePhone = By.xpath("//*[@name='address[telephone]']");
	private By address = By.xpath("//*[@name='address[address_1]']");
	private By city = By.xpath("//*[@name='address[city]']");
	private By country = By.xpath("//*[@name='address[country]']");
	private By province = By.xpath("//*[@name='address[province]']");
	private By postCode = By.xpath("//*[@name='address[postcode]']");
	private By submitButton = By.xpath("//*[text()='Save']");
	private By successMessage = By.xpath("//*[contains(text(),'Address has been saved successfully!')]");

	public void AddressBookNavigate() throws Exception {
		Thread.sleep(3000);
		driver.findElement(AccountField).click();
		Thread.sleep(3000);
		driver.findElement(addressBookclick).click();
	}
	 
	
	public void selectCountry(String countryName) {
	    countryDropdown = driver.findElement(country);
	    countryOption = driver.findElement(By.xpath("//option[text()='" + countryName + "']"));
	}
	
	public void selectProvince(String provinceName) {
		provinceDropdown = driver.findElement(province);
	    provinceOption = driver.findElement(By.xpath("//option[text()='" + provinceName + "']"));
	}
	
	public String getSuccessMessage() {
	    WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
	}
	
	public void enterDetails() throws Exception {
		Thread.sleep(1000);
		driver.findElement(firstName).click();
		driver.findElement(firstName).sendKeys("s");
		
		Thread.sleep(1000);
		driver.findElement(telePhone).click();
		driver.findElement(telePhone).sendKeys("s");
		
		Thread.sleep(1000);
		driver.findElement(address).click();
		driver.findElement(address).sendKeys("s");
		
		Thread.sleep(1000);
		driver.findElement(city).click();
		Thread.sleep(1000);
		driver.findElement(city).sendKeys("s");
		
		Thread.sleep(1000);
		selectCountry("India");
		countryDropdown.click();
		Thread.sleep(1000);
		countryOption.click();
		
		
		Thread.sleep(1000);
		selectProvince("Delhi");
		provinceDropdown.click();
		Thread.sleep(1000);
		provinceOption.click();
		
		
		
		Thread.sleep(1000);
		driver.findElement(postCode).click();
		driver.findElement(postCode).sendKeys("s");
		Thread.sleep(1000);
		
		driver.findElement(submitButton).click();
		
		
		
	}
	
}
