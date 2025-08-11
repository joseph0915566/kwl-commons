package com.kwler.commons.cryptography;

/**
 * 
 * @author Joseph Siegar
 *
 */
public enum HMacAlgorithm {

	HMACSHA1("HmacSHA1"),
	HMACSHA256("HmacSHA256");
	
	private String algorithmString;
	
	private HMacAlgorithm(String algorithmString) {
		this.algorithmString = algorithmString;
	}
	
	@Override
	public String toString(){
		return this.algorithmString;
	}
	
}
