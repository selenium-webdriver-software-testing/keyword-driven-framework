package com.kagrana.keyword_driven_framework;

import java.io.IOException;

import jxl.read.biff.BiffException;

public class XMLFileTest {
	public static void main(String[] args) throws BiffException, IOException{
		ExcelFile xlFile = new ExcelFile("data.xls");
		XMLFile xmlFile = new XMLFile("testng.xml");
		xmlFile.makeXMLFile(xlFile.getSuite());
	}
}
