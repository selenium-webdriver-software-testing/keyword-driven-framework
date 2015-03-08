package com.kagrana.keyword_driven_framework.DTO;

import java.util.ArrayList;
import java.util.List;

public class suite {
	private List<test> tests;
	private List<parameter> parameters;

	public List<test> getTests() {
		return tests;
	}

	public void setTests(List<test> tests) {
		this.tests = tests;
	}
	
	public void addTest(test _test){
		if(this.tests == null)
			this.tests = new ArrayList<test>();
		this.tests.add(_test);
	}

	public List<parameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<parameter> parameters) {
		this.parameters = parameters;
	}
	
	public void setParameter(parameter _parameter){
		if(this.parameters == null)
			this.parameters = new ArrayList<parameter>();
		this.parameters.add(_parameter);
	}
}
