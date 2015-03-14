package com.kagrana.keyword_driven_framework.DTO;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("test")
public class test {
	@XStreamImplicit
	private List<parameter> parameters;
	private List<_class> classes;
	@XStreamAsAttribute
	private String name;

	public List<_class> getClasses() {
		return classes;
	}

	public void setClasses(List<_class> classes) {
		this.classes = classes;
	}

	public void addClass(_class myClass) {
		if (classes == null)
			classes = new ArrayList<_class>();
		this.classes.add(myClass);
	}

	public List<parameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<parameter> parameters) {
		this.parameters = parameters;
	}

	public void addParameter(parameter _parameter) {
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
}
