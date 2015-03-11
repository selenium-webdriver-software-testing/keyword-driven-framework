package com.kagrana.keyword_driven_framework.DTO;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicitCollection;

@SuppressWarnings("deprecation")
@XStreamAlias("suite")
@XStreamImplicitCollection(value = "tests")
public class suite {
	private List<test> tests;
	private List<parameter> parameters;
	@XStreamAsAttribute
	private String name = "test-suite";
	@XStreamAsAttribute
	private String parallel = "tests";
	@XStreamAlias("thread-count")
	@XStreamAsAttribute
	private String thread_count = "5";
	private int testsCounter;
	public suite(){
		this.testsCounter = 0;
	}

	public List<test> getTests() {
		return tests;
	}

	public void setTests(List<test> tests) {
		this.tests = tests;
	}

	public void addTest(test _test) {
		if (this.tests == null)
			this.tests = new ArrayList<test>();
		if(_test.getName() == null)
			_test.setName("test"+ ++testsCounter);
		if(_test.getName().equals(""))
			_test.setName("test"+ ++testsCounter);	
		this.tests.add(_test);
	}

	public List<parameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<parameter> parameters) {
		this.parameters = parameters;
	}

	public void setParameter(parameter _parameter) {
		if (this.parameters == null)
			this.parameters = new ArrayList<parameter>();
		this.parameters.add(_parameter);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParallel() {
		return parallel;
	}

	public void setParallel(String parallel) {
		this.parallel = parallel;
	}

	public String getThread_count() {
		return thread_count;
	}

	public void setThread_count(String thread_count) {
		this.thread_count = thread_count;
	}
}
