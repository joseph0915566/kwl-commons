package com.kwler.commons.encoding;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class EncoderService {
	
	public String encodeUrlSafe(String text){
		return encodeUrlSafe(text, StandardCharsets.UTF_8);
	}

	public String encodeUrlSafe(String text, Charset charset){
		try {
			return URLEncoder.encode(text, charset.name());
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public String encodeBase16String(byte[] bytes, boolean toLowerCase){
        return new String(encodeBase16(bytes, toLowerCase));
	}
	
	public char[] encodeBase16(byte[] bytes, boolean toLowerCase){
        return Hex.encodeHex(bytes, toLowerCase);
	}
	
	public String encodeBase64String(byte[] bytes){
        return Base64.encodeBase64String(bytes);
	}
	
	public String decodeUrlSafe(String text){
		return decodeUrlSafe(text, StandardCharsets.UTF_8);
	}	
	public String decodeUrlSafe(String text, Charset charset){
		try {
			return URLDecoder.decode(text, charset.name());
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}		
	}
	
}
