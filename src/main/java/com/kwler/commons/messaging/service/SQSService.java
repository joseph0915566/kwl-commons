package com.kwler.commons.messaging.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.inject.Inject;

import org.glassfish.hk2.api.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazon.sqs.javamessaging.AmazonSQSExtendedClient;
import com.amazon.sqs.javamessaging.ExtendedClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.http.IdleConnectionReaper;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchRequest;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchRequestEntry;
import com.amazonaws.services.sqs.model.DeleteMessageBatchRequest;
import com.amazonaws.services.sqs.model.DeleteMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.GetQueueAttributesRequest;
import com.amazonaws.services.sqs.model.GetQueueAttributesResult;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import com.amazonaws.services.sqs.model.QueueAttributeName;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageBatchRequest;
import com.amazonaws.services.sqs.model.SendMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.kwler.commons.messaging.model.QueueMessage;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class SQSService implements PreDestroy {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SQSService.class);

	private final AmazonSQS sqsClient;
	private final AmazonS3 amazonS3Client;
	private final Map<QueueName, String> queueUrlMap;
	private final String queueBaseURL;
	
	@Inject
	public SQSService(Properties properties) {

		AWSCredentials credentials = new BasicAWSCredentials(properties.getProperty("aws.access.key"), properties.getProperty("aws.secret.key"));
		this.amazonS3Client = new AmazonS3Client(credentials);
		
		ExtendedClientConfiguration config = new ExtendedClientConfiguration().withLargePayloadSupportEnabled(amazonS3Client, properties.getProperty("sqs.s3.bucket.name", "kwl-rest-dev-templates"));
		this.sqsClient = new AmazonSQSExtendedClient(new AmazonSQSClient(credentials), config);

		queueUrlMap = new HashMap<>();
		for(QueueName queueName : QueueName.values()){
			String queue = properties.getProperty(queueName.getQueuePropertyName());
			if(queue != null && !queue.equalsIgnoreCase("N/A"))	queueUrlMap.put(queueName, queue);			
		}
		
		this.queueBaseURL = properties.getProperty("sqs.queue.url");
		
	}
	
	public static enum QueueName{
		
		FACEBOOK("sqs.facebook.queue.name")
		, INSTAGRAM("sqs.instagram.queue.name")
		, TWITTER("sqs.twitter.queue.name")
		, TWITTER_USERNAME("sqs.twitter.username.queue.name")
		, SOUNDCLOUD("sqs.soundcloud.queue.name")
		, YOUTUBE("sqs.youtube.queue.name")
		, LASTFM("sqs.lastfm.queue.name")
		, ITUNES("sqs.itunes.queue.name")
		, SCREENSCRAPER("sqs.screenscraper.queue.name")
		, WIKIPEDIA("sqs.wikipedia.queue.name")
		, SEARCH("sqs.search.queue.name")
		, SEARCHRESULT("sqs.search-result.queue.name")
		, BANDSINTOWN("sqs.bandsintown.queue.name")
		, SPOTIFY("sqs.spotify.queue.name")
		, GNIP("sqs.gnip.queue.name")
		, DATABASE("sqs.database.queue.name")
		, DATAPROC("sqs.dataproc.queue.name")
		, SOUNDCLOUD_US("sqs.soundcloud.queue.us.name")
		, SOUNDCLOUD_IN("sqs.soundcloud.queue.in.name")
		, SOUNDCLOUD_KR("sqs.soundcloud.queue.kr.name")
		, SOUNDCLOUD_SG("sqs.soundcloud.queue.sg.name")
		, SOUNDCLOUD_AU("sqs.soundcloud.queue.au.name")
		, SOUNDCLOUD_JP("sqs.soundcloud.queue.jp.name")
		, SOUNDCLOUD_CA("sqs.soundcloud.queue.ca.name")
		, SOUNDCLOUD_CN("sqs.soundcloud.queue.cn.name")
		, SOUNDCLOUD_DE("sqs.soundcloud.queue.de.name")
		, SOUNDCLOUD_GB("sqs.soundcloud.queue.gb.name")
		, SOUNDCLOUD_BR("sqs.soundcloud.queue.br.name")
		, MARKETRANKING("sqs.marketranking.queue.name")
		, PLAYLIST("sqs.playlist.queue.name")
		, VENUE("sqs.ar.venue.queue.name")
		, BLOG("sqs.ar.blog.queue.name")
		, NLU("sqs.ar.nlu.queue.name")
		;
		
		private String queuePropertyName;
		
		private QueueName(String queuePropertyName) {
			this.queuePropertyName = queuePropertyName;
		}
		
		public String getQueuePropertyName(){
			return this.queuePropertyName;
		}
		
	}
	
	public boolean isQueueExist(QueueName queueName) {
		return queueUrlMap.containsKey(queueName);
	}

	public void sendMessageBatch(QueueName queueName, List<QueueMessage> messages){
		
		List<SendMessageBatchRequestEntry> entries = new ArrayList<>();
		int count = 0;
		for(QueueMessage message : messages){
			
			SendMessageBatchRequestEntry entry = new SendMessageBatchRequestEntry(count++ + "", message.getMessageBody());			
			if(message.getAttributes() != null){
				for(Map.Entry<String, String> attribute : message.getAttributes().entrySet()){
					MessageAttributeValue messageAttributeValue = new MessageAttributeValue();
					messageAttributeValue.setDataType("String");
					messageAttributeValue.setStringValue(attribute.getValue());
					entry.addMessageAttributesEntry(attribute.getKey(), messageAttributeValue);				
				}					
			}
			
			entries.add(entry);
			
		}
		
		SendMessageBatchRequest sendMessageBatchRequest = new SendMessageBatchRequest(getQueueURL(queueName), entries);		
		sqsClient.sendMessageBatch(sendMessageBatchRequest);		
		
	}
	
	public void sendMessage(QueueName queueName, QueueMessage message){
		
		SendMessageRequest request = new SendMessageRequest(getQueueURL(queueName), message.getMessageBody());
		if(message.getAttributes() != null){
			for(Map.Entry<String, String> attribute : message.getAttributes().entrySet()){
				MessageAttributeValue messageAttributeValue = new MessageAttributeValue();
				messageAttributeValue.setDataType("String");
				messageAttributeValue.setStringValue(attribute.getValue());
				request.addMessageAttributesEntry(attribute.getKey(), messageAttributeValue);				
			}								
		}
		
		sqsClient.sendMessage(request);
		
	}
	
	public List<QueueMessage> getMessages(QueueName queueName, int messageCount){
		
		ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(getQueueURL(queueName));
		receiveMessageRequest.setAttributeNames(Arrays.asList("All"));
		receiveMessageRequest.setMaxNumberOfMessages(messageCount);
		receiveMessageRequest.setMessageAttributeNames(Arrays.asList("*"));
		List<Message> messages = sqsClient.receiveMessage(receiveMessageRequest).getMessages();

		List<QueueMessage> sqsMessages = new ArrayList<>();
		if(messages != null && !messages.isEmpty()){
			
			for(Message message : messages){

				QueueMessage sqsMessage = new QueueMessage();
				sqsMessage.setId(message.getMessageId());
				sqsMessage.setMessageBody(message.getBody());
				sqsMessage.setReceiptHandle(message.getReceiptHandle());
				sqsMessage.setMetadata(message.getAttributes());
				sqsMessage.setAttributes(convertMessageAttribute(message.getMessageAttributes()));
				sqsMessages.add(sqsMessage);
				
			}
			
		}
		
		return sqsMessages;
		
	}
	
	public void returnMessages(QueueName queueName, String...receiptHandles){
		
		if(receiptHandles.length == 0) return;		

		List<ChangeMessageVisibilityBatchRequestEntry> entries = new ArrayList<>();
		int count = 0;
		for(String receiptHandle : receiptHandles){
			ChangeMessageVisibilityBatchRequestEntry entry = new ChangeMessageVisibilityBatchRequestEntry(count++ + "", receiptHandle);
			entry.setVisibilityTimeout(0);
			entries.add(entry);
		}
		
		ChangeMessageVisibilityBatchRequest batchRequest = new ChangeMessageVisibilityBatchRequest(getQueueURL(queueName), entries);		
		sqsClient.changeMessageVisibilityBatch(batchRequest);
		
	}
	
	public void deleteMessages(QueueName queueName, String... receiptHandles){
		
		if(receiptHandles.length == 0) return;		
		
		List<DeleteMessageBatchRequestEntry> entries = new ArrayList<>();
		int count = 0;
		for(String receiptHandle : receiptHandles) entries.add(new DeleteMessageBatchRequestEntry(count++ + "", receiptHandle));
				
		DeleteMessageBatchRequest batchRequest = new DeleteMessageBatchRequest(getQueueURL(queueName), entries);
		sqsClient.deleteMessageBatch(batchRequest);
		
	}
	
	public Map<String, String> getQueueAttributes(QueueName queueName, QueueAttributeName...attributeNames){
		
		if(attributeNames.length == 0) return null;		
		
		GetQueueAttributesRequest request = new GetQueueAttributesRequest(getQueueURL(queueName));
		List<String> attributes = new ArrayList<>();
		for(QueueAttributeName attributeName : attributeNames) attributes.add(attributeName.toString());
		request.setAttributeNames(attributes);
		
		GetQueueAttributesResult result = sqsClient.getQueueAttributes(request);
		
		return result.getAttributes();
		
	}
	
	public boolean isQueueEmpty(QueueName queueName){
		
		QueueAttributeName visibleMessage = QueueAttributeName.ApproximateNumberOfMessages;
		QueueAttributeName inFlightMessage = QueueAttributeName.ApproximateNumberOfMessagesNotVisible;			
		Map<String, String> queueAttributes = getQueueAttributes(queueName, visibleMessage, inFlightMessage);
		
		int visibleMessageCount = Integer.parseInt(queueAttributes.get(visibleMessage.toString()));
		int InFlightMessageCount = Integer.parseInt(queueAttributes.get(inFlightMessage.toString()));
		
		return visibleMessageCount + InFlightMessageCount == 0;
		
	}
	
	private Map<String, String> convertMessageAttribute(Map<String, MessageAttributeValue> messageAttributes){
		
		if(messageAttributes != null){
			
			Map<String, String> stringAttributes = new HashMap<>();
			for(Map.Entry<String, MessageAttributeValue> entry : messageAttributes.entrySet()) stringAttributes.put(entry.getKey(), entry.getValue().getStringValue());
			
			return stringAttributes;
			
		}
		
		return new HashMap<>();
		
	}
	
	private String getQueueURL(QueueName queueName){
		LOGGER.info(queueBaseURL + "/" + queueUrlMap.get(queueName) + " selected");
		return queueBaseURL + "/" + queueUrlMap.get(queueName);
	}

	@Override
	public void preDestroy() {
		
		LOGGER.info("Attempting to shut down AWS Idle Connection Reaper");
		
		try {
			IdleConnectionReaper.shutdown();
		} catch (Throwable e) {
			LOGGER.error("Failed to shut down AWS Idle Connection Reaper", e);
		}
		
		LOGGER.info("AWS Idle Connection Reaper successfully shut down");
		
	}
	
}
