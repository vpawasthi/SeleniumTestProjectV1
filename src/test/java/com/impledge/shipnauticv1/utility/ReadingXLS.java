package com.impledge.shipnauticv1.utility;

  import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 
  
  public class ReadingXLS { 
	  
	  public static final String sTEST_DATA_FILE_PATH = System.getProperty("user.dir") +"//src//test//java//com//impledge//shipnauticv1//testdata//";
	  public static String sFile;
	  public static XSSFRow row;
	  public static FileInputStream fis;
	  public static XSSFWorkbook workbook;
	  public static XSSFSheet spreadsheet; 
	  
	
	
	  public static void main(String[] args) throws Exception {
	  
	  sFile = sTEST_DATA_FILE_PATH+"demoWorkSheet.xlsx";
	  
	  ReadingXLS rx= new ReadingXLS(); rx.readWholexls(sFile);
	  
	  
	  // rx.getCellValue(sFile, 1, 2);
	  
	  
	  System.out.println("Column Value :  "+rx.getCellValue(sFile, 1, 2));
	  
	  
	  
	  }
	  
	 
	  
	  
	  public static String getCellValue(String sFile,int iRowIndex, int iColIndex ) throws Exception {
		  
		   String columnData = null;
		   
		   fis = new FileInputStream( new File(sFile));
		   workbook = new XSSFWorkbook(fis); 
		   spreadsheet = workbook.getSheetAt(0); 
		   Iterator < Row > rowIterator = spreadsheet.iterator(); 
		   
		   while (rowIterator.hasNext()) { 
				row = (XSSFRow) rowIterator.next(); 
				Iterator < Cell > cellIterator = row.cellIterator();
					
				while ( cellIterator.hasNext()) { 
					Cell cell = cellIterator.next();
				
					if (row.getRowNum()==iRowIndex) {
						if (cell.getColumnIndex()==iColIndex) {
							
							switch (cell.getCellType()) { 
							
							case NUMERIC: 
								//System.out.print("Numeric "+cell.getNumericCellValue() + " \t\t " ); 
								columnData = Double.toString(cell.getNumericCellValue());
								break; 
							case STRING:
								//System.out.print("String"+ cell.getStringCellValue() + " \t\t " );
								columnData = cell.getStringCellValue();
								break; 
							case _NONE:
								//System.out.print( cell.getStringCellValue() + " \t\t " ); 
								columnData = cell.getStringCellValue();
								break;
							default:
								break; 
							  }	
						}
						 
					}	
						
				}
			System.out.println(); 
		} 	
		workbook.close();
		fis.close(); 
		  
	 return columnData;
		  
		  
	  }
	  
	  
	  
	  public void readWholexls (String sFile) throws IOException {
		  
		   fis = new FileInputStream( new File(sFile));
		   workbook = new XSSFWorkbook(fis); 
		   spreadsheet = workbook.getSheetAt(0); 
		   Iterator < Row > rowIterator = spreadsheet.iterator(); 
		
		while (rowIterator.hasNext()) { 
			row = (XSSFRow) rowIterator.next(); 
			Iterator < Cell > cellIterator = row.cellIterator();
			
			while ( cellIterator.hasNext()) { 
				Cell cell = cellIterator.next();
				
				switch (cell.getCellType()) { 
				
					case NUMERIC: 
						System.out.print("Numeric "+cell.getNumericCellValue() + " \t\t " ); 
						break; 
					case STRING:
						System.out.print("String"+ cell.getStringCellValue() + " \t\t " ); 
						break; 
					case _NONE:
						System.out.print( cell.getStringCellValue() + " \t\t " ); 
						break;
					default:
						break; 
					  } 
				}
			System.out.println(); 
			
			
		} 	
		workbook.close();
		fis.close(); 
	}
	  
	  
}
 