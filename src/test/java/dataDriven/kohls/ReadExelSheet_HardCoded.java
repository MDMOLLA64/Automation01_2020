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

public class ReadExelSheet_HardCoded extends BaseTest {

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

	@Test(dataProvider = "login")
	public void Log_InTest_GetDATA_From_Exel(Object username, Object password) {
		int num=0;
		
		extentTest = extent.startTest("Log_InTest_GetDATA_From_Exel");
		loger.info("extentReport start for##########      HELLO    ######### Log_InTest_GetDATA_From_Exel");
		loger = Logger.getLogger(ReadExelSheet_HardCoded.class);
		loger.info(" EXECUTION OF ReadExelSheet_HardCoded CLASS STARTED #####hello##### ");

		driver.get(prop.getProperty("kohlsLogInPageUrl"));
		loger.info("applicatin url kohlsLogInPageUrl is right ### hello ##### ");
		driver.findElement(By.id("")).sendKeys(username.toString());
		loger.info("sent email ");
		loger.info("execution time :  "+num++);
		driver.findElement(By.id("")).sendKeys(password.toString());
		loger.info("sent password ");
		loger.info("execution time :  "+num++);
		driver.findElement(By.id("")).click();
		loger.info("clicked on **** sign IN ****** button");

	}
}
