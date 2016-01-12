package com.ericsson.mit.emfpop.util;

import java.lang.System;
import java.util.logging.Logger;

import com.ericsson.mit.emfpop.core.EMFPopulator;

public interface Util {
	
	static final String SPACE = " ";
	static final String DELIMITER = "%";
	static final String outputFileName = "data";
	static final String inputFileName = outputFileName;
	static final String fileExtension = "uppaal";
	static final String rootDirectory = "C:\\Users\\"+System.getProperty("user.name") + "\\";
	static final Logger fileLogger = Logger
			.getLogger(EMFPopulator.class.getPackage().getName());
	static final String NTA = "NTA";
	static final String TEMPLATE = "TEMPLATE";
	static final String LOCATION = "LOCATION";
	static final String LOCATIONTYPECHANGE = "LOCATIONTYPECHANGE";
	static final String INITIAL = "INITIAL";
	static final String G_DECLARATION = "GLOBALDECLARATION";
	static final String L_DECLARATION = "LOCALDECLARATION";
	static final String EDGE = "EDGE";
	static final String SYSTEM = "SYSTEM";
	static final String GENERATE = "GENERATE";
	static final String REARRANGELOCATIONS = "REARRANGELOCATIONS";
	static final String COMPLETEMODEL = "COMPLETEMODEL";
	
	static final String GLOBAL_VAR = "e";
	static final String DEDICATED = "dedicated";
	static final String INITIALIZED = "initialized";
	public enum Section {
		DIV(0),
		STR(1),
		TOP(2);
		
		private final int value;
		Section(final int value) {
			this.value = value;
		}
			
		public int getValue() {
			return value;
		}
			
	}

}
