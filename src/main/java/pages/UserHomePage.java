package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilies.Helper;

public class UserHomePage {

	WebDriver driver;

	public UserHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='Account']")
	WebElement account;
	@FindBy(xpath = "//a[@title='Sign Out']")
	WebElement signOut;
	@FindBy(xpath = "")
	WebElement title2;
	@FindBy(xpath = "")
	WebElement title3;
	@FindBy(id = "//p[text()='Our stores are now open!']")
	WebElement text;

	public String getText() {
		String actualtext = Helper.getText(text);
		return actualtext;

	}

	public void account() {
		Helper.click_OnElement(driver, account, 5);

	}

	public void clickOn_signOutButton() {
		Helper.click_OnElement(driver, signOut, 5);

	}

}
