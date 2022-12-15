package marathon_3;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataProvider {

	public static String[][] readData(String excelName) throws IOException {
		
		XSSFWorkbook Workbook = new XSSFWorkbook("Data/"+excelName+".xlsx");
		
		XSSFSheet sheet =  Workbook.getSheetAt(0);
		
		int row = sheet.getLastRowNum();
		
		short col = sheet.getRow(0).getLastCellNum();
		
		String[][] data = new String[row][col];
		
		for (int i = 1; i <= row; i++) {
			XSSFRow row1 = sheet.getRow(i);
			for (int j = 0; j < col; j++) {
				XSSFCell col1 = row1.getCell(j);
				data[i-1][j] = col1.getStringCellValue();
			}
		}
		Workbook.close();
		return data;	
	}

}
