package testUnit;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataProviderUtility.TestUtil;

public class LogInValidationTest extends BaseTest {

	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = TestUtil.getDataFromExel();
		return testData.iterator();
	}

	@Test(dataProvider = "getTestData")
	public void LogInTest(String user, String pass) {
		extentTest = extent.startTest("LogInTest");
		loger.info("captured in extent report");

		driver.get(prop.getProperty("kohlsLogInPageUrl"));
		loger.info("landed into kohlsLogInPageUrl");

		// driver.findElement(By.id("kiosk_loginEmail")).clear();
		driver.findElement(By.id("kiosk_loginEmail")).sendKeys(user);
		loger.info("typed Email id in Email box");
		// driver.findElement(By.id("kiosk_loginPassword")).clear();
		driver.findElement(By.id("kiosk_loginPassword")).sendKeys(pass);
		loger.info("typed password in inPut Field");
		driver.findElement(By.id("Profilelogin")).click();
		loger.info("clicked on Submitt Button");

//		driver.findElement(By.xpath("//ul[@class='utility-nav-group']")).click();
//		driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();

	}
}
