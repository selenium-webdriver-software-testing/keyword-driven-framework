package com.kagrana.keyword_driven_framework;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.kagrana.keyword_driven_framework.DTO._class;
import com.kagrana.keyword_driven_framework.DTO.parameter;
import com.kagrana.keyword_driven_framework.DTO.suite;
import com.kagrana.keyword_driven_framework.DTO.test;

public class ExcelFile {
	private String excelFileName;

	public ExcelFile(String excelFileName) {
		this.excelFileName = excelFileName;
	}

	public suite getSuite() throws BiffException, IOException {
		File file = new File(this.excelFileName);
		if (!file.exists())
			throw new IOException("File " + file.getAbsolutePath()
					+ " does not exist");
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
				String[] parametersCommaSeperated = data[i][2].split(",");
				for (int paramCount = 0; paramCount < parametersCommaSeperated.length; paramCount++) {
					String[] parameters = parametersCommaSeperated[paramCount]
							.split(":");
					parameter param_platform = new parameter();
					param_platform.setName("OS");
					param_platform.setValue(parameters[0]);
					parameter param_browser = new parameter();
					param_browser.setName("browser");
					param_browser.setValue(parameters[1]);
					parameter param_browserVersion = null;
					if (parameters.length >= 3) {
						param_browserVersion = new parameter();
						param_browserVersion.setName("version");
						param_browserVersion.setValue(parameters[2]);
					}
					_class myClass = new _class();
					myClass.setName(data[i][0]);
					test _test = new test();
					_test.setName(getTestName(data[i][0], parameters));
					_test.addClass(myClass);
					_test.addParameter(param_platform);
					_test.addParameter(param_browser);
					if (param_browserVersion != null)
						_test.addParameter(param_browserVersion);
					_suite.addTest(_test);
				}
			}
		}
		return _suite;
	}

	private String getTestName(String testName, String[] browserConfig) {
		testName += "_" + browserConfig[0] + "_" + browserConfig[1];
		if (browserConfig.length >= 3)
			testName += "_" + browserConfig[2];
		else
			testName += "_*";
		return testName.replace(" ", "_");
	}

}
