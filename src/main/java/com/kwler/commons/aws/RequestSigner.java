package com.kwler.commons.aws;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.inject.Inject;

import com.kwler.commons.cryptography.DigestService;
import com.kwler.commons.cryptography.HMacService;
import com.kwler.commons.encoding.EncoderService;
import com.kwler.commons.http.model.HTTPMethod;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.utils.http.SdkHttpUtils;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class RequestSigner {

	private static final String NEWLINE = "\n";
	
	private final EncoderService encoderService; 
	private final HMacService hMacService;
	private final String awsAccessKey;
	private final String awsSecretKey;
	private final DigestService digestService;
	
	@Inject
	public RequestSigner(
							HMacService hMacService
							, DigestService digestService
							, EncoderService encoderService
							, Properties properties
						) {
		this.hMacService = hMacService;
		this.digestService = digestService;
		this.encoderService = encoderService;
		this.awsAccessKey = properties.getProperty("aws.access.key");
		this.awsSecretKey = properties.getProperty("aws.secret.key");
	}
	
	public RequestSigner(
							HMacService hMacService
							, DigestService digestService
							, EncoderService encoderService
							, String awsAccessKey
							, String awsSecretKey
						) {
		this.hMacService = hMacService;
		this.digestService = digestService;
		this.encoderService = encoderService;
		this.awsAccessKey = awsAccessKey;
		this.awsSecretKey = awsSecretKey;
	}
	
	public String getSignature(
								HTTPMethod method
								, String uri
								, Map<String, String> queryParams
								, Map<String, String> headers
								, byte[] payload
								, Region region
								, String awsServiceName
								){
		
		String datetimeString = headers.get("x-amz-date");
		String dateString = datetimeString.substring(0, 8);        
        String credentialScope = dateString + "/" + region + "/" + awsServiceName + "/aws4_request";
        
    	String baseString = method + NEWLINE + SdkHttpUtils.urlEncodeIgnoreSlashes(uri) + NEWLINE;
    	
    	//query params processing
    	if(queryParams != null && !queryParams.isEmpty()){
        	boolean first = true;
        	Map<String, String> orderedMap = orderMap(queryParams);
            for (Map.Entry<String, String> param : orderedMap.entrySet()){
            	if(!first) baseString += "&";
            	else first = false;
            	baseString += encoderService.encodeUrlSafe(param.getKey()) + '=' + encoderService.encodeUrlSafe(param.getValue());
            }    		
    	}
    	baseString += NEWLINE;
    	
        //header processing
    	Map<String, String> orderedMap = orderMap(headers);
        for (Map.Entry<String, String> entry : orderedMap.entrySet()) baseString += entry.getKey().toLowerCase() + ':' + entry.getValue() + NEWLINE;
    	baseString += NEWLINE;
        
        boolean first = true;
        String signedHeaderKeys = "";
        for (Map.Entry<String, String> entry : orderedMap.entrySet()){
        	if(!first) signedHeaderKeys += ";";
        	else first = false;
        	signedHeaderKeys += entry.getKey().toLowerCase();
        }
        baseString += signedHeaderKeys + NEWLINE;
        
        //payload processing
        baseString += encoderService.encodeBase16String(digestService.getDigest(payload), true);
        baseString = 	"AWS4-HMAC-SHA256" + NEWLINE 
        				+ datetimeString + NEWLINE 
        				+ credentialScope + NEWLINE 
        				+ encoderService.encodeBase16String(digestService.getDigest(baseString.getBytes(StandardCharsets.UTF_8)), true);
        
        //constructing signature key
        byte[] signatureKey =  hMacService.getHmac(dateString.getBytes(StandardCharsets.UTF_8), ("AWS4" + awsSecretKey).getBytes(StandardCharsets.UTF_8));
        signatureKey = hMacService.getHmac(region.toString().getBytes(StandardCharsets.UTF_8), signatureKey);
        signatureKey = hMacService.getHmac(awsServiceName.getBytes(StandardCharsets.UTF_8), signatureKey);
        signatureKey = hMacService.getHmac("aws4_request".getBytes(StandardCharsets.UTF_8), signatureKey);
        
        String signature = encoderService.encodeBase16String(hMacService.getHmac(baseString.getBytes(StandardCharsets.UTF_8), signatureKey), true);
        return 	"AWS4-HMAC-SHA256 Credential=" + awsAccessKey
				+ "/" + credentialScope
        		+ ", SignedHeaders=" + signedHeaderKeys
        		+ ", Signature=" + signature;
		
	}
	
	public Map<String, String> orderMap(Map<String, String> map){
		
		if(map == null || map.isEmpty()) return map;
		
		List<String> orderedKeys = new ArrayList<>(map.keySet()); 
		Collections.sort(orderedKeys, String.CASE_INSENSITIVE_ORDER);
		
		Map<String, String> orderedMap = new LinkedHashMap<>();
		for(String key : orderedKeys) orderedMap.put(key, map.get(key));
		return orderedMap;
		
	}
	
}
