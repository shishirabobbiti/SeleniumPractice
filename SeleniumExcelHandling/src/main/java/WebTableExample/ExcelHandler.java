package WebTableExample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHandler {

	public static void main(String[] args) throws IOException {
		
		//File
		//FineInputStream
		//XLSSFWorkbook
		//XSSFSheet
		//Row
		//Cell
		File file = new File("src\\main\\resources\\selenium.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		// workbook.getSheetAt(0);
		XSSFSheet sheet = workbook.getSheet("webtable");
		int rowCount = sheet.getLastRowNum();
		System.out.println(rowCount);
		for (int i = 0; i < rowCount; i++) {
			Row row=sheet.getRow(i);
			int cells=row.getPhysicalNumberOfCells();
			for (int j = 0; j < cells; j++) {
				Cell cell = row.getCell(j);
				System.out.print(cell+"\t");
			}
			System.out.println();
		}
		
		 Sheet s = workbook.createSheet("Employee Data");
		 
		 
		
	}

}
