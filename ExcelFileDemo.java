package selenium.WebAssignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileDemo {

	public static void main(String[] args) throws IOException {
		//Reading Data from Excel Sheet : File->File Input Stream->Workbook->Sheet->Row->Cell->getCellValue
		
		 File file = new File("D:\\Goldy\\Selenium Practice\\WebAssignment\\Testdata.xlsx");
		 FileInputStream fis = new FileInputStream(file);
		 XSSFWorkbook workbook = new XSSFWorkbook(fis);
		 XSSFSheet sheet = workbook.getSheet("Login");
		 int TotalRows = sheet.getLastRowNum();
		 int TotalColumns = sheet.getRow(0).getLastCellNum();
		 
		 System.out.println("Total Rows in Login sheet: "+TotalRows);
		 System.out.println("Total Columns in Login sheet: "+TotalColumns);
		 
		 for(int r=0;r<=TotalRows;r++) {
			 XSSFRow CurrentRow = sheet.getRow(r);
				 for(int c=0;c<TotalColumns;c++) {
					 String data = CurrentRow.getCell(c).getStringCellValue();
					 System.out.print(data + " ");
				 }
			 System.out.println();
		 }
         workbook.close();
         fis.close();
	}

}
