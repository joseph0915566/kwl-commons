package com.kwler.commons.io.exception;

import java.util.List;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class ProcessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String errorMessage;
	
	public ProcessException(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public ProcessException(List<String> errorMessages) {
		
		String errorLines = "";
		for(String errorMessage : errorMessages) errorLines += errorMessage + System.lineSeparator();
		
		this.errorMessage = errorLines;
		
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
