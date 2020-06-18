package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilies.Helper;

public class LogInPage {

	WebDriver driver;

	public LogInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "kiosk_loginEmail")
	WebElement emailbox;
	@FindBy(id = "kiosk_loginPassword")
	WebElement passwordbox;
	@FindBy(id = "Profilelogin")
	WebElement SignIn;

	// p[text()='Our stores are now open!']
	public void type_In_EmailBox(String values) {
		Helper.sendkeys(driver, emailbox, 5, values);
	}

	public void type_In_passwordBox(String pass) {
		Helper.sendkeys(driver, passwordbox, 5, pass);

	}

	public UserHomePage click_on_SubMittButton() {
		Helper.click_OnElement(driver, SignIn, 5);
		// Helper.clickOnElement(SignIn);
		return new UserHomePage(driver);

	}

}
