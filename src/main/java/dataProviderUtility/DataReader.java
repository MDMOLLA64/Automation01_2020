package dataProviderUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataReader {
	
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
