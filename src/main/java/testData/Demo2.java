package testData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Demo2 {

	public static void main(String[] args) {
		 
		try {
			FileInputStream	fis = new FileInputStream(new File ("./Data/excelInput.xlsx"));
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("Sheet1");
			Row r = sh.getRow(1);
			Cell c = r.getCell(0);
			Cell c2 = r.getCell(1);
			String un = c.getStringCellValue();
			String pw = c2.getStringCellValue();
			System.out.println("Username: "+un);
			System.out.println("Password: "+pw);
		} 
		
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			
		} 
		
		catch (EncryptedDocumentException e) 
		{
			e.printStackTrace();
		} 
		
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}

}
