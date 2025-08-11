package com.kwler.commons.cryptography;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.inject.Inject;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class HMacService {

	private final Mac SHA1Mac;
	private final Mac SHA256Mac;

	@Inject
	public HMacService(){
		
		try {
			SHA1Mac = Mac.getInstance(HMacAlgorithm.HMACSHA1.name());
			SHA256Mac = Mac.getInstance(HMacAlgorithm.HMACSHA256.name());
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public byte[] getHmac(byte[] data, byte[] key){
		return getHmac(data, key, HMacAlgorithm.HMACSHA256, StandardCharsets.UTF_8);
	}
	
	public byte[] getHmac(byte[] data, byte[] key, HMacAlgorithm hashAlgorithm){
		return getHmac(data, key, hashAlgorithm, StandardCharsets.UTF_8);
	}
	
	public byte[] getHmac(byte[] data, byte[] key, HMacAlgorithm hashAlgorithm, Charset charset){
		
		Mac mac;		
		switch (hashAlgorithm) {
			case HMACSHA1:
				mac = SHA1Mac;
				break;
			default:
				mac = SHA256Mac;
				break;
		}
		
		try {
			mac.init(new SecretKeySpec(key, hashAlgorithm.name()));
			return mac.doFinal(data);
		} catch (InvalidKeyException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
