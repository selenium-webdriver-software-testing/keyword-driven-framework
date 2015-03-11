package com.kagrana.keyword_driven_framework;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.kagrana.keyword_driven_framework.DTO._class;
import com.kagrana.keyword_driven_framework.DTO.suite;
import com.kagrana.keyword_driven_framework.DTO.test;

public class ExcelFile {
	private String excelFileName;

	public ExcelFile(String excelFileName) {
		this.excelFileName = excelFileName;
	}

	public suite getSuite() throws BiffException, IOException {
		File file = new File(this.excelFileName);
		return readExcelFile(file);
	}

	private suite readExcelFile(File file) throws BiffException, IOException {
		return readSheet(Workbook.getWorkbook(file));
	}

	private suite readSheet(Workbook workbook) {
		suite _suite = getTable(workbook.getSheet(0));
		workbook.close();
		return _suite;
	}

	private suite getTable(Sheet sheet) {
		String[][] data = new String[sheet.getRows()][sheet.getColumns()];
		for (int i = 0; i < sheet.getRows(); i++) {
			for (int j = 0; j < sheet.getColumns(); j++) {
				data[i][j] = sheet.getCell(j, i).getContents();
			}
		}
		return getTests(data, sheet.getRows(), sheet.getColumns());
	}

	private suite getTests(String[][] data, int rows, int column) {
		suite _suite = new suite();
		for (int i = 0; i < rows; i++) {
			if (data[i][1].toUpperCase().equals("Y")
					|| data[i][1].toUpperCase().equals("YES")) {
				_class myClass = new _class();
				myClass.setName(data[i][0]);
				test _test = new test();
				_test.addClass(myClass);
				_suite.addTest(_test);
			}
		}
		return _suite;
	}

}
