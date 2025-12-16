package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static Object[][] getSheetData(String excelPath,String sheetName) throws IOException{
		
		Object[][] data = null;
		
		try {
			FileInputStream file = new FileInputStream(excelPath);
			
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            
            XSSFSheet sheet = 	workbook.getSheet(sheetName);
            
            int rowCount  = sheet.getPhysicalNumberOfRows();
            int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
            
            data = new Object[rowCount-1][columnCount];
            
            for(int i= 1; i< rowCount; i++) {
            	
            	XSSFRow row = sheet.getRow(i);
            	
            	
                for (int j = 0; j < columnCount; j++) {
                	
                	XSSFCell cell = row.getCell(j);
                	
                	
               if(cell.getCellType() == CellType.STRING)
            	   data[i-1][j] = cell.getStringCellValue();
                
                
                else if(cell.getCellType()== CellType.BOOLEAN)
                	data[i-1][j]  = cell.getBooleanCellValue();
               
                else if(cell.getCellType()==CellType.NUMERIC)
            	data[i-1][j]  = cell.getNumericCellValue();


            }
            
		}
            
            workbook.close();
            file.close();
		}  
            
            catch (FileNotFoundException e) {
                System.out.println("❌ Failed to read Excel: " + e.getMessage());
		}
		
		
		
		return data;
		
	
	}
}
