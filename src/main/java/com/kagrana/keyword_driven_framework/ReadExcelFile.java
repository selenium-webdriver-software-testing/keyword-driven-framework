package com.kagrana.keyword_driven_framework;

import java.io.File;
import java.io.IOException;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.kagrana.keyword_driven_framework.DTO.parameter;
import com.kagrana.keyword_driven_framework.DTO.suite;

public class ReadExcelFile {
	private String excelFileName;
	public ReadExcelFile(String excelFileName){
		this.excelFileName = excelFileName;
	}
	public suite getSuite() throws BiffException, IOException{
		File file = new File(this.excelFileName);
		return readExcelFile(file);
	}
	private suite readExcelFile(File file) throws BiffException, IOException{
		return readSheet(Workbook.getWorkbook(file));
	}
	private suite readSheet(Workbook workbook){
		Sheet sheet = workbook.getSheet(0);
		return getTable(sheet);
	}
	private suite getTable(Sheet sheet){
		for (int i=1;i<sheet.getRows();i++){
			for (int j=0;j<sheet.getColumns();j++){
				Cell cell=sheet.getCell(j,i);
			}// end for j loop
		}
		return getTests();
	}
	private suite getTests(){
		return null;
	}
	private List<parameter> getParameters(){
		return null;
	}
	
}
