package logInPage;

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
	WebElement passbox;
	@FindBy(id = "Profilelogin")
	WebElement signInButton;
	@FindBy(id = "//*[@id=\"tr_phase2_ShoppingBg\"]/span[4]")
	WebElement cartText;
	// *[@id="tr_phase2_ShoppingBg"]/span[4]

	public void getBaseURL() {
		driver.get("https://www.kohls.com/myaccount/kohls_login.jsp");

	}

	public void typeEmail(String value) {
		Helper.typeToinPutBox(emailbox, value);

	}

	public void typePasword(String value) {
		Helper.typeToinPutBox(passbox, value);

	}

	public void clickONSignInButton() {
		Helper.clickOnElement(signInButton);

	}

	public void getCartText() {
		Helper.getText(cartText);

	}

}
