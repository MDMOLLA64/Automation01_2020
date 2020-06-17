package testUnit;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilies.ReadPropFile;

public class BaseTest {

	public static WebDriver driver;
	public static Logger loger;

	public static ExtentReports extent;
	public static ExtentTest extentTest;
	public static Properties prop;

	@BeforeSuite
	public void setExtent() {
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/extentReport.html", true);
		extent.addSystemInfo("Host Name", "Mds-MacBook-Pro.home");
		extent.addSystemInfo("User Name", "mdmolla");
		extent.addSystemInfo("Environment", "QA");
	}

	@BeforeTest
	public void reading_PropertyFile() {
		loger = Logger.getLogger(BaseTest.class);
		DOMConfigurator.configure("log4j.xml");

		try {

			prop = ReadPropFile.ReadFile("/Users/mdmolla/eclipse-workspace/Automation01/config.properties");
			loger.info("property file reading  started ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// log.info("Property file reading");

	}

	@BeforeClass
	public void setUp() {

		String browser = prop.getProperty("Test_ON_Chrome");
		loger.info("got the browser name from Property file ");
		// String browser =System.getProperty("browser");
		// loger.info("got the browser name from Property file ");
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/mdmolla/Downloads/chromedriver");

			driver = new ChromeDriver();
			loger.info("blank chrome browser launched");

		} else if (browser.equals("FireFox")) {
			System.setProperty("webdriver.geko.driver", "");
			driver = new FirefoxDriver();
			loger.info("blank firefox browser launched");

		} else if (browser.equals("IE")) {
			System.setProperty("webdriver.InternetExplorar.driver", "");
			driver = new InternetExplorerDriver();

		} else if (browser.equals("Edge")) {
			System.setProperty("webdriver.Edge.driver", "");
			driver = new EdgeDriver();

		} else if (browser.equals("Opera")) {
			System.setProperty("webdriver.Opera.driver", "");
			driver = new OperaDriver();

		} else if (browser.equals("safari")) {
			System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
			driver = new SafariDriver();
		}
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// log.info("landed into HomePage");
		// driver.manage().window().maximize();

//
//		System.setProperty("webdriver.chrome.driver", "/Users/mdmolla/Downloads/chromedriver");
//		driver = new ChromeDriver();
//		loger.info("Chrome blank browser  open");
//		driver.get("https://www.eshopper24.com/");
//		loger.info("landed homePage");

	}

	@BeforeMethod
	public void getWebSite() {

	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in
																							// extent report
			String screenshotPath = getScreenshot(driver, result.getName());
			loger.info("screen shot has taken");
			// FreeCRMTest.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); // to add screenshot in extent
			loger.info("screen shot has attached to extents reports"); // report
			// extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath));
			// //to add screencast/video in extent report
		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
			loger.info("listed out skipped test cases : " + result.getName());

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getMethod().getMethodName());
			loger.info("test case pass : " + result.getName());
		}

		extent.endTest(extentTest); // ending test and ends the current test and prepare to create html report
		loger.info("extent report ended");

	}

	@AfterClass
	public void testDown() throws InterruptedException {

		if (!(driver == null)) {
			Thread.sleep(3000);
			driver.quit();
		}

		loger.info("browser closed");
	}

	@AfterSuite
	public void endReport() {
		extent.flush();
		extent.close();
	}

	public String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/failTestAttachToExtentReport/" + screenshotName
				+ dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

}
