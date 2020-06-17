package testUnit;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenToMyTestCases.class)
public class SmokeTest extends BaseTest {

	@Test(priority=3)//url=kohls
	public void logIntest() {

		extentTest = extent.startTest("logIntest");
		// loger = Logger.getLogger(BaseTest.class);
		loger.info("extentReport start for logIntest");
		driver.get(prop.getProperty("url"));

	}

	@Test(priority=2)//basUrlFor_letsCodeIt=lets code it
	public void logIntest01() {

		extentTest = extent.startTest("logIntest01");
		loger.info(" extentReport start for logIntest01");
		// loger = Logger.getLogger(BaseTest.class);
		driver.get(prop.getProperty("basUrlFor_letsCodeIt"));

	}

	@Test(priority=1)//eshoper
	public void logIntest02() {

		extentTest = extent.startTest("logIntest02");
		loger.info("extentReport start for logIntest02");
		// loger = Logger.getLogger(BaseTest.class);
		driver.get(prop.getProperty("base_Url_Eshopper24"));
		//Assert.assertEquals(true, false);
	}
}
