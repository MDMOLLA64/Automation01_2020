package letsCodeIt.Practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleGrid {

	@Test
	public void test1() throws MalformedURLException {

		DesiredCapabilities cap = DesiredCapabilities.chrome();

		cap.setBrowserName("chrome");

		cap.setPlatform(Platform.MAC);

		WebDriver dr = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		dr.get("http://www.google.com");
	}

	@Test
	public void test2() throws MalformedURLException {

		DesiredCapabilities cap = DesiredCapabilities.chrome();

		cap.setBrowserName("chrome");

		cap.setPlatform(Platform.MAC);
		cap.setPlatform(Platform.getCurrent());

		WebDriver dr = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		dr.get("http://www.yahoo.com");
	}

	@Test(enabled = false)
	public void test3() throws MalformedURLException {

		DesiredCapabilities cap = DesiredCapabilities.chrome();

		cap.setBrowserName("chrome");

		cap.setPlatform(Platform.WIN10);
		WebDriver dr = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		dr.get("http://www.facebook.com");
	}
}
