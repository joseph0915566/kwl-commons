package com.kwler.commons.io;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class ProcessStream {

	private InputStream resultStream;
	private InputStream errorStream;
	private OutputStream outputStream;
	
	public OutputStream getOutputStream() {
		return outputStream;
	}

	public void setOutputStream(OutputStream outputStream) {
		this.outputStream = outputStream;
	}

	public InputStream getResultStream() {
		return resultStream;
	}
	
	public void setResultStream(InputStream resultStream) {
		this.resultStream = resultStream;
	}
	
	public InputStream getErrorStream() {
		return errorStream;
	}
	
	public void setErrorStream(InputStream errorStream) {
		this.errorStream = errorStream;
	}
	
}
