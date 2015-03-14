package com.kagrana.keyword_driven_framework;

import java.io.IOException;

import jxl.read.biff.BiffException;

public class XMLFileTest {
	public static void main(String[] args) throws BiffException, IOException{
		ExcelFile xlFile = new ExcelFile("C:\\Users\\mayur\\Dropbox\\mayur-trushar-sagar-share\\data.xls");
		XMLFile xmlFile = new XMLFile("testng.xml");
		SuiteConfiguration sp = new SuiteConfiguration(xlFile.getSuite(), "config.properties");
		sp.set("gridURL", "gridURL");
		sp.set("ReportLocation", "ReportLocation");
		sp.set("baseURL", "baseURL");
		sp.set("internal", "internal");
		sp.setSuiteName("suite_name");
		sp.setParallel("parallel");
		sp.setThread_Count("thread_count");
		sp.setClassPackage("tests_package");
		xmlFile.makeXMLFile(sp.getSuite());
	}
}
