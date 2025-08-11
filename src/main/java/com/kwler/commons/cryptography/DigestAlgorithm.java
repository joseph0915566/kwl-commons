package com.kwler.commons.cryptography;

/**
 * 
 * @author Joseph Siegar
 *
 */
public enum DigestAlgorithm {

	MD5("MD5")
	, SHA_256("SHA-256")
	, SHA_1("SHA-1")
	;
	
	private DigestAlgorithm(String name) {
		this.name = name;
	}
	
	private final String name;
	
	public String getName(){
		return name;
	}
	
}
