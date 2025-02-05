package WebTableExample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriting {

	public static void main(String[] args) throws IOException {
		
		// Load Excel file
        File file = new File("src\\main\\resources\\selenium.xlsx");
        FileInputStream fis = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.createSheet("excelwriting");
//        Row row = sheet.createRow(0);
//        Cell cell = row.createCell(0);
        //cell.setCellValue("Shishira");
        String[][] data = {
	            {"ID", "Name", "Role"},
	            {"101", "Alice", "Manager"},
	            {"102", "Bob", "Developer"},
	            {"103", "Charlie", "Tester"}
	        };
      for(int i=0;i<data.length;i++) {
    	  Row row = sheet.createRow(i);
    	  for(int j=0;j<data[i].length;j++) {
    		  row.createCell(j).setCellValue(data[i][j]);
    	  }
      }
        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);
	}

}
