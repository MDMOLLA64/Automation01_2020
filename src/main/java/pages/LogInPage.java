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
	WebElement SignUp;

	public void type_In_EmailBox(String values) {
		Helper.myType(emailbox, values);

	}

	public void type_In_passwordBox(String values) {
		Helper.myType(passwordbox, values);

	}

	public UserHomePage click_on_SubMittButton() {
		Helper.clickOnElement(SignUp);
		return new UserHomePage(driver);

	}
}
