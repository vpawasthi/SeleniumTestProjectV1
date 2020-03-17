package com.impledge.shipnauticv1.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Platform;
import org.apache.poi.xssf.usermodel.XSSFCell;


//import static com.impledge.shipnauticv1.tests.BaseTest.testDataExcelFileName;

  
  public class XLSXUtility { 
	  
	 // public static final String sTEST_DATA_FILE_PATH = System.getProperty("user.dir") +"//src//test//java//com//impledge//shipnauticv1//testdata//";
	  
		  
	    //Main Directory of the project
	    public static final String currentDir = System.getProperty("user.dir");
	 
	    //Location of Test data excel file
	    //public static String testDataExcelPath = currentDir+"//src//test//java//com//impledge//shipnauticv1//testdata//";
	    
	    public static String testDataExcelPath = null;
	    
	    //Excels Testdata File Name
	    public static String testDataExcelFileName=null;
	 
	    //Excel WorkBook
	    private static XSSFWorkbook excelWBook;
	 
	    //Excel Sheet
	    private static XSSFSheet excelspreadsheet;
	 
	    //Excel cell
	    private static XSSFCell cell;
	    
	    //FileInput object fis
	    private static FileInputStream fis;
	 
	    //Excel row
	    private static XSSFRow row;
	 
	    //Row Number
	    public static int rowNumber;
	 
	    //Column Number
	    public static int columnNumber;
	 
	    //Setter and Getters of row and columns
	    public static void setRowNumber(int pRowNumber) {
	        rowNumber = pRowNumber;
	    }
	 
	    public static int getRowNumber() {
	        return rowNumber;
	    }
	 
	    public static void setColumnNumber(int pColumnNumber) {
	        columnNumber = pColumnNumber;
	    }
	 
	    public static int getColumnNumber() {
	        return columnNumber;
	    }
	    
	   public static int getTotalRowNumber() {
	 
		    return excelspreadsheet.getLastRowNum();
	   }
	    
	    
	    public static String getTestDataExcelpath() {
	    	
	    	//MAC or Windows Selection for excel path
	        if (Platform.getCurrent().toString().equalsIgnoreCase("MAC")) {
	            testDataExcelPath = currentDir + "//src//test//java//resources//";
	        } else if (Platform.getCurrent().toString().contains("WIN")) {
	            //testDataExcelPath = currentDir + "\\src\\test\\java\\resources\\";
	        	testDataExcelPath = currentDir+"\\src\\test\\java\\com\\impledge\\shipnauticv1\\testdata\\";
	            
	        }
	    	
	        return testDataExcelPath;
	    }
	    
	 
	   
	    // It creates FileInputStream and set excel file and excel sheet to excelWBook and excelWSheet variables.
	    public static void setExcelFileSheet(String sheetName) {
	        //MAC or Windows Selection for excel path
	        if (Platform.getCurrent().toString().equalsIgnoreCase("MAC")) {
	            testDataExcelPath = currentDir + "//src//test//java//resources//";
	        } else if (Platform.getCurrent().toString().contains("WIN")) {
	            //testDataExcelPath = currentDir + "\\src\\test\\java\\resources\\";
	        	testDataExcelPath = currentDir+"\\src\\test\\java\\com\\impledge\\shipnauticv1\\testdata\\";
	            
	        }
	        try {
	            // Open the Excel file
	            FileInputStream ExcelFile = new FileInputStream(testDataExcelPath + testDataExcelFileName);
	            excelWBook = new XSSFWorkbook(ExcelFile);
	            excelspreadsheet = excelWBook.getSheet(sheetName);
	        } catch (Exception e) {
	            try {
	                throw (e);
	            } catch (IOException e1) {
	                e1.printStackTrace();
	            }
	        }
	    }
	 
	    // This method has two parameters: "Test data excel file name" and "Excel sheet name"
	    public static void setExcelFileSheet(String sExcelFileName, String sheetName) {
	        //MAC or Windows Selection for excel path
	        if (Platform.getCurrent().toString().equalsIgnoreCase("MAC")) {
	            testDataExcelPath = currentDir + "//src//test//java//resources//";
	        } else if (Platform.getCurrent().toString().contains("WIN")) {
	            //testDataExcelPath = currentDir + "\\src\\test\\java\\resources\\";
	        	testDataExcelPath = currentDir+"\\src\\test\\java\\com\\impledge\\shipnauticv1\\testdata\\";
	            
	        }
	        try {
	            // Open the Excel file
	        	testDataExcelFileName=sExcelFileName;
	            FileInputStream ExcelFile = new FileInputStream(testDataExcelPath + testDataExcelFileName);
	            excelWBook = new XSSFWorkbook(ExcelFile);
	            excelspreadsheet = excelWBook.getSheet(sheetName);
	        } catch (Exception e) {
	            try {
	                throw (e);
	            } catch (IOException e1) {
	                e1.printStackTrace();
	            }
	        }
	    }

	    
	    
	    
	    //This method reads the test data from the Excel cell.
	    //We are passing row number and column number as parameters.
	    public static String getCellData(int RowNum, int ColNum) {
	        try {
	            cell = excelspreadsheet.getRow(RowNum).getCell(ColNum);
	            DataFormatter formatter = new DataFormatter();
	            String cellData = formatter.formatCellValue(cell);
	            return cellData;
	        } catch (Exception e) {
	            throw (e);
	        }
	    }
	 
	    //This method takes row number as a parameter and returns the data of given row number.
	    public static XSSFRow getRowData(int RowNum) {
	        try {
	            row = excelspreadsheet.getRow(RowNum);
	            return row;
	        } catch (Exception e) {
	            throw (e);
	        }
	    }
	 
	    //This method gets excel file, row and column number and set a value to the that cell.
	    public static void setCellData(String value, int RowNum, int ColNum) {
	        try {
	            row = excelspreadsheet.getRow(RowNum);
	            cell = row.getCell(ColNum);
	            if (cell == null) {
	                cell = row.createCell(ColNum);
	                cell.setCellValue(value);
	            } else {
	                cell.setCellValue(value);
	            }
	            // Constant variables Test Data path and Test Data file name
	            FileOutputStream fileOut = new FileOutputStream(testDataExcelPath + testDataExcelFileName);
	            excelWBook.write(fileOut);
	            fileOut.flush();
	            fileOut.close();
	        //    excelWBook.close();  // added for workbook closing
	        } catch (Exception e) {
	            try {
	                throw (e);
	            } catch (IOException e1) {
	                e1.printStackTrace();
	            }
	        }
	    }
	  
	   public static String getCellValue(String sTestDataFile,int iRowIndex, int iColIndex ) throws Exception {
		  
		   String columnData = null;
		   
		   fis = new FileInputStream( new File(sTestDataFile));
		   excelWBook = new XSSFWorkbook(fis); 
		   excelspreadsheet = excelWBook.getSheetAt(0); 
		   Iterator < Row > rowIterator = excelspreadsheet.iterator(); 
		   
		   while (rowIterator.hasNext()) { 
				row = (XSSFRow) rowIterator.next(); 
				//Iterator < Cell > cellIterator = row.cellIterator();
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
							case BOOLEAN:
								columnData = Boolean.toString(cell.getBooleanCellValue());
								break;
							default:
								break; 
							  }	
						}
						 
					}	
						
				}
			System.out.println(); 
		} 	
		   excelWBook.close();
		fis.close(); 
		  
	 return columnData;
		  
		  
	  }
	  
	  
	  
	  public void readWholexls (String sTestDataFile) throws IOException {
		  
		   fis = new FileInputStream( new File(sTestDataFile));
		   excelWBook = new XSSFWorkbook(fis); 
		   excelspreadsheet = excelWBook.getSheetAt(0); 
		   Iterator < Row > rowIterator = excelspreadsheet.iterator(); 
		
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
		excelWBook.close();
		fis.close(); 
	}
	  
	  
	  // To testing xls utility methods 
	  
	  
	  public static void main(String[] args) throws Exception {
		  
		  	  
	     XLSXUtility rx= new XLSXUtility();
	     testDataExcelFileName=XLSXUtility.getTestDataExcelpath()+testDataExcelFileName;
	     rx.readWholexls(testDataExcelFileName);
	  	  
	  // rx.getCellValue(sFile, 1, 2);
	  	  
	  System.out.println("Column Value :  "+XLSXUtility.getCellValue(testDataExcelFileName, 1, 2));
	  
	  
	  }
	  
	  
}
 