package com.kwler.commons.http;

import java.io.InputStream;
import java.util.Properties;

import javax.inject.Inject;

import org.apache.commons.io.IOUtils;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class S3Service {
	
	private final AmazonS3 client;
	
	@Inject
	public S3Service(Properties properties) {		
		String accessKey = properties.getProperty("aws.access.key");
		String secretKey = properties.getProperty("aws.secret.key");
		client = new AmazonS3Client(new BasicAWSCredentials(accessKey, secretKey));		
	}
	
	public byte[] getFile(String bucketName, String objectKey){
		
		S3Object object = client.getObject(new GetObjectRequest(bucketName, objectKey));
		try(InputStream is = object.getObjectContent()) {
			return IOUtils.toByteArray(is);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
