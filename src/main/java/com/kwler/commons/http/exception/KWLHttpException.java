package com.kwler.commons.http.exception;

import java.util.Map;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class KWLHttpException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected final int statusCode;
	protected final Map<String, String> headers;
	
	public KWLHttpException(int statusCode, String message, Map<String, String> headers) {
		super(message);
		this.statusCode = statusCode;
		this.headers = headers;
	}
	
	public KWLHttpException(int statusCode, String message, Map<String, String> headers, Throwable throwable) {
		super(message, throwable);
		this.statusCode = statusCode;
		this.headers = headers;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}
	
}
