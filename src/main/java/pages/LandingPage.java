package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilies.Helper;

public class LandingPage {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"utility-nav\"]/ul/div")
	WebElement account;
	@FindBy(xpath = "//div[text()=' SIGN IN ']")
	WebElement signUp;

	public void getWebSite() {
		driver.get("https://www.kohls.com/");

	}

	public void clickOnaccount() {

		Helper.clickOnElement(account);

	}

	// //div[text()=' SIGN IN ']

	public LogInPage clickOn_SIGNUPButton() {
		Helper.clickOnElement(signUp);
		// Helper.click_OnElement(driver, signUp, 5);
		return new LogInPage(driver);

	}

	public void ElementVerify_account() {
		Helper.verifyElement(account);
		Assert.assertTrue(account.isDisplayed());

	}
}
