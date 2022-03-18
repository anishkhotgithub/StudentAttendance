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

import com.example.model.Student;


public class ExcelUtils {

	public static ByteArrayInputStream customersToExcel(List<Student> students) throws IOException {
		
		String[] COLUMNs = {"Id","Rollno", "Name", "Email","batch_batchid"};
		try(
				Workbook workbook = new XSSFWorkbook();
				ByteArrayOutputStream out = new ByteArrayOutputStream();
		){
			CreationHelper createHelper = workbook.getCreationHelper();
	 
			Sheet sheet = workbook.createSheet("Customers");
	 
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
			for (Student student : students) {
				Row row = sheet.createRow(rowIdx++);
	 
				row.createCell(0).setCellValue(student.getId());
				row.createCell(1).setCellValue(student.getRollno());
				row.createCell(2).setCellValue(student.getName());
				row.createCell(3).setCellValue(student.getEmail());
				row.createCell(4).setCellValue(student.getBatch().getBatchid());
//				Cell ageCell = ;
//				ageCell.setCellValue(students.getAge());
//				ageCell.setCellStyle(ageCellStyle);
			}
	 
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}
	
	public static List<Student> parseExcelFile(InputStream is) {
		try {
    		Workbook workbook = new XSSFWorkbook(is);
     
    		Sheet sheet = workbook.getSheet("Students");
    		Iterator<Row> rows = sheet.iterator();
    		
    		List<Student> listStudensts = new ArrayList<Student>();
    		
    		int rowNumber = 0;
    		while (rows.hasNext()) {
    			Row currentRow = rows.next();
    			
    			// skip header
    			if(rowNumber == 0) {
    				rowNumber++;
    				continue;
    			}
    			
    			Iterator<Cell> cellsInRow = currentRow.iterator();

    			Student s = new Student();
    			
    			int cellIndex = 0;
    			while (cellsInRow.hasNext()) {
    				Cell currentCell = cellsInRow.next();
    				
    				if(cellIndex==0) { // ID
    					s.setId((long) currentCell.getNumericCellValue());
    				} else if(cellIndex==1) { // Roll
    					s.setRollno(currentCell.getStringCellValue());
    				} else if(cellIndex==2) { // Name
    					s.setName(currentCell.getStringCellValue());
    				} else if(cellIndex==3) { // Email
    					s.setEmail(currentCell.getStringCellValue());
    				}else if(cellIndex==4) { // Batch
    					s.getBatch().setBatchid((long)currentCell.getNumericCellValue());
    				}
    				
    				cellIndex++;
    			}
    			
    			listStudensts.add(s);
    		}
    		
    		// Close WorkBook
    		workbook.close();
    		
    		return listStudensts;
        } catch (IOException e) {
        	throw new RuntimeException("FAIL! -> message = " + e.getMessage());
        }
	}
}