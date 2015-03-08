package com.kagrana.keyword_driven_framework;

import java.io.IOException;
import java.util.List;

import jxl.read.biff.BiffException;

import com.kagrana.keyword_driven_framework.DTO._class;
import com.kagrana.keyword_driven_framework.DTO.suite;
import com.kagrana.keyword_driven_framework.DTO.test;

public class ReadExcelFileTest {
	public static void main(String[] args) throws BiffException, IOException{
		ReadExcelFile file = new ReadExcelFile("data.xls");
		suite _suite = file.getSuite();
		List<test> tests = _suite.getTests();
		for(test _test : tests){
			List<_class> classes = _test.get_classes().get_class();
			for(_class myClass : classes)
				System.out.println(myClass.getName());
		}
	}
	

}
