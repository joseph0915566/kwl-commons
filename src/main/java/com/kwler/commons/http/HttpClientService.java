package com.kwler.commons.http;

import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

/**
 * 
 * @author Joseph Siegar
 *
 */
public interface HttpClientService {

	//with payload
	String doPost(String scheme, String host, String path, MultivaluedMap<String, Object> payload, Map<String, String> headers, Map<String, String> parameters, int connectTimeout, int requestTimeout);
	String doPost(String scheme, String host, String path, Map<String, String> formData, Map<String, String> headers, Map<String, String> parameters, int connectTimeout, int requestTimeout);
	String doPost(String scheme, String host, String path, String payload, MediaType mediaType, Map<String, String> headers, Map<String, String> parameters, int connectTimeout, int requestTimeout);
	String doPut(String scheme, String host, String path, String payload, MediaType mediaType, Map<String, String> headers, Map<String, String> parameters, int connectTimeout, int requestTimeout);

	//without payload
	String doGet(String scheme, String host, String path, Map<String, String> headers, Map<String, String> parameters, int connectTimeout, int requestTimeout);
	String doDelete(String scheme, String host, String path, Map<String, String> headers, Map<String, String> parameters, int connectTimeout, int requestTimeout);
	String doGet(String scheme, String host, String path, MultivaluedMap<String, String> headers, MultivaluedMap<String, String> parameters, int connectTimeout, int requestTimeout);	
}
