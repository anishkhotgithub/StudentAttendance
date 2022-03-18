package com.example.utilfile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.model.Batch;
public class ExcelUtilsBatch 
{
public static ByteArrayInputStream customersToExcel(List<Batch> batch) throws IOException {
		
		String[] COLUMNs = {"BatchName"};
		try(
				Workbook workbook = new XSSFWorkbook();
				ByteArrayOutputStream out = new ByteArrayOutputStream();
		){
			CreationHelper createHelper = workbook.getCreationHelper();
	 
			Sheet sheet = workbook.createSheet("Batchs");
	 
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());
	 
			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);
	 
			// Row for Header
			Row headerRow = sheet.createRow(0);
	 
			// Header
			for (int col = 0; col < COLUMNs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(COLUMNs[col]);
				cell.setCellStyle(headerCellStyle);
			}
	 
			// CellStyle for Age
			CellStyle ageCellStyle = workbook.createCellStyle();
			ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));
	 
			int rowIdx = 1;
			for (Batch batchs : batch) {
				Row row = sheet.createRow(rowIdx++);
	 
				row.createCell(0).setCellValue(batchs.getBatchname());
				/* row.createCell(4).setCellValue(student.getBatch()); */
//				Cell ageCell = ;
//				ageCell.setCellValue(students.getAge());
//				ageCell.setCellStyle(ageCellStyle);
			}
	 
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}
	
	public static List<Batch> parseExcelFile(InputStream is) {
		try {
    		Workbook workbook = new XSSFWorkbook(is);
     
    		Sheet sheet = workbook.getSheet("Batchs");
    		Iterator<Row> rows = sheet.iterator();
    		
    		List<Batch> BatchStudensts = new ArrayList<Batch>();
    		
    		int rowNumber = 0;
    		while (rows.hasNext()) {
    			Row currentRow = rows.next();
    			
    			// skip header
    			if(rowNumber == 0) {
    				rowNumber++;
    				continue;
    			}
    			
    			Iterator<Cell> cellsInRow = currentRow.iterator();

    			Batch b = new Batch();
    			
    			int cellIndex = 0;
    			while (cellsInRow.hasNext()) {
    				Cell currentCell = cellsInRow.next();
    				
    				if(cellIndex==0) { // ID
    					b.setBatchname(currentCell.getStringCellValue());
    				} 
    				
    				cellIndex++;
    			}
    			
    			BatchStudensts.add(b);
    		}
    		
    		// Close WorkBook
    		workbook.close();
    		
    		return BatchStudensts;
        } catch (IOException e) {
        	throw new RuntimeException("FAIL! -> message = " + e.getMessage());
        }
	}
}
