package com.kwler.commons.db.base.nosql.mongo.exception;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class InvalidIdException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidIdException() {
		super("Id is empty or malformed");
	}
	
	public InvalidIdException(String message) {
		super(message);
	}
	
}
