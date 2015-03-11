package com.kagrana.keyword_driven_framework;

import java.io.FileOutputStream;
import java.io.IOException;

import com.kagrana.keyword_driven_framework.DTO.suite;
import com.thoughtworks.xstream.XStream;

public class XMLFile {
	private String XMLFileName;

	public XMLFile(String XMLFileName) {
		this.XMLFileName = XMLFileName;
	}

	public void makeXMLFile(suite _suite) throws IOException {
		FileOutputStream fos = new FileOutputStream(this.XMLFileName);
		XStream xStream = new XStream();
		xStream.setMode(1001);
		xStream.autodetectAnnotations(true);

		xStream.toXML(_suite, fos);
		fos.close();
	}
}
