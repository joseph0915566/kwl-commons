package com.kwler.commons.mail.service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.inject.Inject;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.commons.codec.binary.Base64;

import com.kwler.commons.http.HttpClientService;
import com.kwler.commons.http.model.ByteArrayPayload;

/**
 * 
 * @author Joseph Kurniawan Siegar
 *
 */
public class MailgunService implements MailService {

	private final String apiKey;
	private final String domain;
	private final HttpClientService httpClientService; 
	
	@Inject
	public MailgunService(Properties properties, HttpClientService httpClientService) {
		apiKey = properties.getProperty("mailgun.api.key");
		domain = properties.getProperty("mailgun.domain");
		this.httpClientService = httpClientService;
	}
	
	@Override
	public void send(String sender
					, List<String> recipientList
					, String description
					, String subject
					, String textContent
					, String htmlContent
					, List<ByteArrayPayload> attachments
					) {
		
		MultivaluedMap<String, Object> parts = new MultivaluedHashMap<String, Object>();
	    parts.putSingle("from", sender);
	    for(String recipient : recipientList) parts.add("to", recipient);		    
	    parts.putSingle("subject", subject);
	    parts.putSingle("html", (htmlContent == null ? "" : htmlContent));
	    parts.putSingle("text", (textContent == null ? "" : textContent));
	    if(attachments != null && !attachments.isEmpty()){
	    	for(ByteArrayPayload attachment : attachments) parts.add("attachment", attachment);		    	
	    }

	    Map<String, String> headers = new HashMap<>();
    	headers.put(HttpHeaders.AUTHORIZATION, "Basic " + Base64.encodeBase64String(("api:" + apiKey).getBytes(StandardCharsets.UTF_8)));	    
    	httpClientService.doPost("https", "api.mailgun.net", "/v3/" + domain + "/messages", parts, headers, null, 30000, 30000);				
		
	}

	@Override
	public void send(String sender
					, String recipient
					, String description
					, String subject
					, String textContent
					, String htmlContent
					, List<ByteArrayPayload> attachments
					) {
		send(sender, new ArrayList<String>(Arrays.asList(recipient)), description, subject, textContent, htmlContent, attachments);
	}

}
