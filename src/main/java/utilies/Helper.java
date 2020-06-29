package utilies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {

	public static void sendkeys(WebDriver driver, WebElement element, int timeout, String value) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}

	public static void click_OnElement(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public static void mouseOver(WebDriver driver, WebElement target) {
		Actions a = new Actions(driver);
		a.moveToElement(target).build().perform();
	}

	public static void clickOnElement(WebElement element) {
		waitForElement(element).click();
		// element.click();

	}

	public static boolean verifyElement(WebElement element) {
		boolean result = waitForElement(element).isDisplayed();
		return result;
	}

	public static WebElement waitForElement(WebElement element) {
		ExpectedConditions.invisibilityOf(element);
		return element;
	}

	public static void selectElement(WebElement element, String text) {
		new Select(element).selectByVisibleText(text);

	}
	
	public static void typeToinPutBox(WebElement ele, String value) {
	waitForElement(ele).clear();
	waitForElement(ele).sendKeys(value);
	}

	public static void myType(WebElement ele, String value) {
		ele.sendKeys(value);
	}

	public static String getText(WebElement ele) {
		String actualText = ele.getText();
		System.out.println(actualText);
		return actualText;

	}
}
