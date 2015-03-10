package com.kagrana.keyword_driven_framework.DTO;

import java.util.ArrayList;
import java.util.List;

public class suite {
	private List<test> test;
	private List<parameter> parameters;

	public List<test> getTests() {
		return test;
	}

	public void setTests(List<test> tests) {
		this.test = tests;
	}
	
	public void addTest(test _test){
		if(this.test == null)
			this.test = new ArrayList<test>();
		this.test.add(_test);
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
