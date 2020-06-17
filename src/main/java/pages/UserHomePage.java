package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage {

	WebDriver driver;

	public UserHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "")
	WebElement title;
	@FindBy(xpath = "")
	WebElement title1;
	@FindBy(xpath = "")
	WebElement title2;
	@FindBy(xpath = "")
	WebElement title3;
}
