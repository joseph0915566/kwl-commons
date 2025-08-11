package com.kwler.commons.mail.service;

import java.util.List;

import com.kwler.commons.http.model.ByteArrayPayload;

/**
 * 
 * @author Joseph Siegar
 *
 */
public interface MailService {

	void send(String sender, String recipient, String description, String subject, String textContent, String htmlContent, List<ByteArrayPayload> attachments);
	void send(String sender, List<String> recipientList, String description, String subject, String textContent, String htmlContent, List<ByteArrayPayload> attachments);

}
