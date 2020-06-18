package dataDriven.kohls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testUnit.BaseTest;
import utilies.Helper;

public class LogInJustUsingData extends BaseTest {

	@Test(dataProvider = "login")
	public void EndToEndTestUsingData(Object username, Object password) {

		extentTest = extent.startTest("EndToEndTestUsingData");
		loger.info("extentReport start for logIntest");
		loger = Logger.getLogger(LogInJustUsingData.class);

		driver.get(prop.getProperty("kohlsLogInPageUrl"));
		loger.debug("landed in logIn page");
		driver.findElement(By.id("kiosk_loginEmail")).sendKeys(username.toString());
		loger.info("typed  email on input box ");
		driver.findElement(By.id("kiosk_loginPassword")).sendKeys(password.toString());
		driver.findElement(By.id("kiosk_loginEmail")).sendKeys(username.toString());
		loger.info("typed  pass on input box ");
		driver.findElement(By.id("Profilelogin")).click();
		loger.info("clicked on sign in button");
		// String usertext = driver
		// .findElement(By.xpath("//a[@class='utility-item-link account
		// utility-nav-wallet-svg']/div")).getText();
		// loger.info(usertext);

		// .click();
		Helper.clickOnElement(driver.findElement(By.xpath("//div[@class='is-signed-in']")));
		loger.info("clicked on account in button");
		Helper.clickOnElement(driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")));
		loger.info("clicked on signOut in button");
		// .click();
	}

	@DataProvider(name = "login")
	public Object[][] readXL() throws Exception {
		FileInputStream f = null;
		Object[][] data = null;
		try {
			f = new FileInputStream(new File("/Users/mdmolla/Downloads/KohlsTestData.xlsx"));
			XSSFWorkbook book = new XSSFWorkbook(f);
			XSSFSheet sheet = book.getSheetAt(0);
			// XSSFCell cel=sheet.getRow(1).getCell(0);
			// String v=cel.getStringCellValue();

			int rn = sheet.getLastRowNum();
			int cn = sheet.getRow(0).getLastCellNum();
			data = new Object[rn][cn];
			for (int i = 1; i < rn; i++) {
				for (int j = 0; j < cn; j++) {
					XSSFCell cel = sheet.getRow(i).getCell(j);
					switch (cel.getCellType()) {
					case XSSFCell.CELL_TYPE_NUMERIC: {
						// System.out.println(cel.getNumericCellValue());
						data[i - 1][j] = cel.getNumericCellValue();
					}
					case XSSFCell.CELL_TYPE_STRING: {
						// System.out.println(cel.getStringCellValue());
						data[i - 1][j] = cel.getStringCellValue();
					}
					}
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (f != null) {
				f.close();
			}

		}

		return data;
	}

}
