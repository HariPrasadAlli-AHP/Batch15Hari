package QspidersTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import QspidersPage.CheckBoxPage;

public class DropdownTest {

	WebDriver driver;

	public DropdownTest() throws Exception {
		super();
	}

	CheckBoxPage checkboxPage;

	@BeforeMethod
	public void setUp() {

		checkboxPage.initialization();
		checkboxPage = new CheckBoxPage(CheckBoxPage.driver);
		
	}

	@Test(priority = 1)
	public void dropdownclickandChoose() throws Exception {
		checkboxPage.clickonDropdown("Male");
		String SelectedOption = checkboxPage.getSelectedDropdownValue();
		Assert.assertEquals(SelectedOption, "Male", "Dropdown selection is incorrect!");
		Thread.sleep(2000);
		
//		checkboxPage.selectWhatsAppCheckbox();
		
	}
	
	

}
