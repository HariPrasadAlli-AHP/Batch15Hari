package QspidersPage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckBoxPage {
	
	WebDriverWait wait;
	public static WebDriver driver;
	private Select drpGender;
	
	@FindBy(id = "select2")
	WebElement Genderdropdown;
	
	@FindBy(xpath="//span[text()='WhatsApp']/preceding-sibling::input[@type='checkbox']")
	WebElement WhatsappcheckBox;
	
	@FindBy(xpath = "//*[text()='Check Box']")
	WebElement checkboxNavigation;
	
	
	
	public CheckBoxPage(WebDriver driver) {
		
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10)); 
        PageFactory.initElements(driver, this);
    }

	public static void initialization() {
		ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoapps.qspiders.com/ui/dropdown?sublist=0");
	}

	public void clickonDropdown(String Gender) throws Exception {
		drpGender = new Select(Genderdropdown);
		drpGender.selectByVisibleText(Gender);
		Thread.sleep(2000);
		
		List<WebElement> dropdown = drpGender.getOptions();
		System.out.println("Total Dropdown values:" + dropdown.size());
		
		for(int i =0; i< dropdown.size(); i++) {
			String dropdownValues = dropdown.get(i).getText();
			System.out.println(dropdownValues);
			drpGender.selectByIndex(i);
			Thread.sleep(2000);
		}
//		checkboxNavigation.click();
	}
	
	
	
	
//	
//	public void selectWhatsAppCheckbox() {
//		WhatsappcheckBox.click();
//	}
	
	public String getSelectedDropdownValue() {
        return drpGender.getFirstSelectedOption().getText();
    }
}
