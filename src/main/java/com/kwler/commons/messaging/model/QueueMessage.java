package com.kwler.commons.messaging.model;

import java.util.Map;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class QueueMessage {

	private String id;
	private String messageBody;
	private String receiptHandle;
	private Map<String, String> metadata;
	private Map<String, String> attributes;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getMessageBody() {
		return messageBody;
	}
	
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
	
	public String getReceiptHandle() {
		return receiptHandle;
	}

	public void setReceiptHandle(String receiptHandle) {
		this.receiptHandle = receiptHandle;
	}

	public Map<String, String> getMetadata() {
		return metadata;
	}
	
	public void setMetadata(Map<String, String> metadata) {
		this.metadata = metadata;
	}
	
	public Map<String, String> getAttributes() {
		return attributes;
	}
	
	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
	
}
