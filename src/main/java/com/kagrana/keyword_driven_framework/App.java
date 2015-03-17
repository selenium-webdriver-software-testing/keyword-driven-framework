package com.kagrana.keyword_driven_framework;

import java.util.HashMap;

/**
 * This library helps in automating Selenium tests and makes keyword driven
 * framework to execute TestNG tests.
 * 
 * @author mayur
 *
 */
public class App {

	public static void main(String[] args) throws Exception {
		HashMap<String, String> arguments = new HashMap<String, String>();
		for (int i = 0; i < args.length; i++) {
			if (!args[i].startsWith("-"))
				throw new Exception("Invalid argument" + args[i]);
			if (!args[i].contains("="))
				throw new Exception("Argument " + args[i]
						+ " does not have any value");
			String[] splittedArgs = args[i].split("=");
			if (!(splittedArgs.length == 2))
				throw new Exception(
						"Argument "
								+ args[i]
								+ " does not have any value.\nFormat:\n\t-argument=value");
			arguments.put(splittedArgs[0].replace("-", ""), splittedArgs[1]);
		}
		ExcelFile xlFile = new ExcelFile(
				arguments.get("excelfilename") != null ? arguments
						.get("excelfilename") : "input.xls");
		XMLFile xmlFile = new XMLFile(
				arguments.get("testngfilename") != null ? arguments
						.get("testngfilename") : "testng.xml");
		SuiteConfiguration sp = new SuiteConfiguration(xlFile.getSuite(),
				arguments.get("configfilename") != null ? arguments
						.get("configfilename") : "config.properties");
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
