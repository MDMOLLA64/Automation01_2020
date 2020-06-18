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

import pages.LandingPage;
import pages.LogInPage;
import pages.UserHomePage;
import testUnit.BaseTest;
import utilies.Helper;

public class UiValidation extends BaseTest {



	

	LandingPage landingpage;

	LogInPage loginpage;

	UserHomePage userhomepage;

	@Test(dataProvider = "login")
	public void EndToEndTest(Object username, Object password) {

		extentTest = extent.startTest("EndToEndTest");
		loger.info("extentReport start for logIntest");
		loger = Logger.getLogger(UiValidation.class);

		driver.get("https://www.kohls.com/");
		loger.debug("landed in landing page");

		landingpage = new LandingPage(driver);
		loger.info("inctance got created of LandingPage");

		landingpage.ElementVerify_account();
		loger.info("account element present");

		landingpage.clickOnaccount();
		loger.info("clicked  on  account   <>");

		loginpage = landingpage.clickOn_SIGNUPButton();
		loger.info("clicked  on _SIGNUPButton   <> and new logeInPage create and landed");

		// loginpage.type_In_EmailBox(username.toString());

		loginpage.type_In_EmailBox(username.toString());
		loger.info("username typed in input box ");

		loginpage.type_In_passwordBox(password.toString());
		loginpage.type_In_passwordBox(password.toString());
		loger.info("pssword typed in input box ");

		userhomepage = loginpage.click_on_SubMittButton();
		loger.info("clicked on SignIn Button in LogINPAGE");

		userhomepage.account();
		loger.info("action perform on account button");
		userhomepage.clickOn_signOutButton();
		loger.info("action perform on clickOn_signOutButton ");
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

	@Test(dataProvider = "singleData" ,enabled = false)
	public void NnumberIndexfromxl(Object username, Object password) {

//		extentTest = extent.startTest("NnumberIndexfromxl");
//		loger.info("extentReport start for logIntest");
//		loger = Logger.getLogger(UiValidation.class);
		driver.get("https://www.kohls.com/myaccount/kohls_login.jsp");
		Helper.sendkeys(driver, driver.findElement(By.id("kiosk_loginEmail")), 5, username.toString());
		Helper.sendkeys(driver, driver.findElement(By.id("kiosk_loginPassword")), 5, password.toString());

	}

	@DataProvider(name = "singleData")
	public Object[][] readXLNmun() throws Exception {
		FileInputStream f = null;
		Object[][] data = null;
		try {
			f = new FileInputStream(new File("/Users/mdmolla/Downloads/KohlsTestData.xlsx"));
			XSSFWorkbook book = new XSSFWorkbook(f);
			XSSFSheet sheet = book.getSheetAt(0);
			XSSFCell cel = sheet.getRow(9).getCell(0);
			// String v=cel.getStringCellValue();
//
//			int rn = sheet.getLastRowNum();
//			int cn = sheet.getRow(0).getLastCellNum();
			data = new Object[9][5];
			// for (int i = 1; i < rn; i++) {
			// for (int j = 0; j < cn; j++) {
			// XSSFCell cel = sheet.getRow(i).getCell(j);
			switch (cel.getCellType()) {
			case XSSFCell.CELL_TYPE_NUMERIC: {
				// System.out.println(cel.getNumericCellValue());
				data[10 - 1][5] = cel.getNumericCellValue();
			}
			case XSSFCell.CELL_TYPE_STRING: {
				// System.out.println(cel.getStringCellValue());
				data[0 - 1][5] = cel.getStringCellValue();
				// }
				// }
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
