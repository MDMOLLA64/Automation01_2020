package letsCodeIt.Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import testUnit.BaseTest;
import testUnit.ListenToMyTestCases;

@Listeners(ListenToMyTestCases.class)
public class UiClients_SmokeTest extends BaseTest {
	@Test
	public void mySitewebEle() {

		extentTest = extent.startTest("mySitewebEle");
		loger.info(" extentReport start for mySitewebEle");
		// loger = Logger.getLogger(BaseTest.class);
		driver.get(prop.getProperty("baseUrl_MyFirstWebsite"));

	}

	@Test(retryAnalyzer = MyRetry.class, enabled = false)
	public void problem_staleElementRefarenceExcep() {
		extentTest = extent.startTest("problem_staleElementRefarenceExc");
		loger.info(" extentReport start for problem_staleElementRefarenceExc");
		// loger = Logger.getLogger(BaseTest.class);
		driver.get(prop.getProperty("basUrlFor_letsCodeIt"));
		WebElement element = driver.findElement(By.id("benzcheck"));
		driver.get(driver.getCurrentUrl());
		loger.info("refresh the Page ");
		element.click();
		loger.info("clicked on ckeckBox___ benz");

	}

	@Test(retryAnalyzer = MyRetry.class)
	public void solution_staleElementRefarenceExcep() {
		extentTest = extent.startTest("solution_staleElementRefarenceExcep");
		loger.info(" extentReport start for solution_staleElementRefarenceExcep");
		// loger = Logger.getLogger(BaseTest.class);
		driver.get(prop.getProperty("basUrlFor_letsCodeIt"));

		driver.get(driver.getCurrentUrl());
		loger.info("refresh the Page ");
		WebElement element = driver.findElement(By.id("benzcheck"));
		element.click();
		loger.info("clicked on ckeckBox___ benz");

	}

	@Test(retryAnalyzer = MyRetry.class)
	public void workWithListOfWebelement() throws InterruptedException {
		extentTest = extent.startTest("solution_staleElementRefarenceExcep");
		loger.info(" extentReport start for solution_staleElementRefarenceExcep");
		// loger = Logger.getLogger(BaseTest.class);
		driver.get(prop.getProperty("basUrlFor_letsCodeIt"));
		boolean ischecked = false;
		List<WebElement> radioButton = driver.findElements(By.xpath("//input[@name='cars'and @type='radio']"));
		int radioSize = radioButton.size();
		for (int i = 0; i < radioSize; i++) {

			ischecked = radioButton.get(i).isSelected();
			if (!ischecked) {
				radioButton.get(i).click();
				Thread.sleep(3000);
			}

		}

	}

	
	
}
