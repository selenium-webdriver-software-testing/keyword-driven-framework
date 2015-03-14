package com.kagrana.keyword_driven_framework;

import java.io.IOException;
import java.util.List;

import com.kagrana.keyword_driven_framework.DTO._class;
import com.kagrana.keyword_driven_framework.DTO.parameter;
import com.kagrana.keyword_driven_framework.DTO.suite;
import com.kagrana.keyword_driven_framework.DTO.test;
import com.kagrana.util.PropertyFileManager;

public class SuiteConfiguration {
	private String fileName;
	private suite _suite;

	public SuiteConfiguration(suite _suite, String fileName) {
		this.fileName = fileName;
		this._suite = _suite;
	}

	public void set(String propertyName, String propertyAlias)
			throws IOException {
		PropertyFileManager pfm = new PropertyFileManager(this.fileName);
		try {
			parameter param = new parameter();
			param.setName(propertyAlias);
			param.setValue(pfm.getProperty(propertyName));
			this._suite.addParameter(param);
		} catch (Exception ignore) {

		}
	}

	public suite getSuite() {
		return this._suite;
	}
	public void setClassPackage(String propName) throws IOException{
		PropertyFileManager pfm = new PropertyFileManager(fileName);
		List<test> tests = this._suite.getTests();
		for(test _test : tests){
			List<_class> classes = _test.getClasses();
			for(_class myClass : classes){
				myClass.setName(pfm.getProperty(propName)+"."+myClass.getName());
			}
		}
	}
	public void setThread_Count(String paramName) throws IOException{
		PropertyFileManager pfm = new PropertyFileManager(fileName);
		this._suite.setThread_count(pfm.getProperty(paramName));
	}
	public void setParallel(String paramName) throws IOException{
		PropertyFileManager pfm = new PropertyFileManager(fileName);
		this._suite.setParallel(pfm.getProperty(paramName));
	}
	public void setSuiteName(String paramName) throws IOException{
		PropertyFileManager pfm = new PropertyFileManager(fileName);
		this._suite.setName(pfm.getProperty(paramName));
	}
	
}
