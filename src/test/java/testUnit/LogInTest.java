package testUnit;

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

import letsCodeIt.Practice.MyRetry;

public class LogInTest extends BaseTest {

	@Test(retryAnalyzer = MyRetry.class, enabled = false) // @Test(priority = 1) // url=kohls
	public void logIntest_IntoKohls() {

		extentTest = extent.startTest("logIntest");
		// loger = Logger.getLogger(BaseTest.class);
		loger.info("extentReport start for logIntest");
		driver.get(prop.getProperty("kohlsLogInPageUrl"));
		loger.info("landed into kohls login page");
		driver.findElement(By.id("kiosk_loginEmail")).clear();
		driver.findElement(By.id("kiosk_loginEmail")).sendKeys("mollamd715@gmail.com");
		loger.info("Email typed in Email box");
		driver.findElement(By.id("kiosk_loginPassword")).sendKeys("Ruhulamin64");
		loger.info("password typed in password box");
		driver.findElement(By.id("Profilelogin")).click();
		loger.info("clicked on submitt button");

		// Profilelogin
	}

// this working fine so you can use this code read exel sheet
	@Test(dataProvider = "login", retryAnalyzer = MyRetry.class)
	public void logIntest_In_toKohls(Object userId, Object Password) {

		extentTest = extent.startTest("logIntest");
		loger = Logger.getLogger(LogInTest.class);
		loger.info("extentReport start for logIntest");
		driver.get(prop.getProperty("kohlsLogInPageUrl"));
		loger.info("landed into kohls login page");
		driver.findElement(By.id("kiosk_loginEmail")).clear();
		driver.findElement(By.id("kiosk_loginEmail")).sendKeys(userId.toString());
		loger.info("Email typed in Email box");
		driver.findElement(By.id("kiosk_loginPassword")).sendKeys(Password.toString());
		loger.info("password typed in password box");
		driver.findElement(By.id("Profilelogin")).click();
		loger.info("clicked on submitt button");

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
