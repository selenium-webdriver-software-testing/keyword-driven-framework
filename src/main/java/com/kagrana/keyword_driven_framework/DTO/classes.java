package com.kagrana.keyword_driven_framework.DTO;

import java.util.ArrayList;
import java.util.List;

public class classes {
	private List<_class> _class;
	private List<parameter> parameters;

	public List<_class> get_class() {
		return _class;
	}

	public void set_class(List<_class> _class) {
		this._class = _class;
	}

	public void addClass(_class myClass) {
		if (this._class == null)
			this._class = new ArrayList<_class>();
		this._class.add(myClass);
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
}
