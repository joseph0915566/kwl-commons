package com.kwler.commons.http;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.glassfish.hk2.api.PreDestroy;

import com.kwler.commons.http.exception.KWLHttpException;
import com.kwler.commons.http.model.ByteArrayPayload;
import com.kwler.commons.http.model.HTTPMethod;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class ApacheHTTPClientService implements PreDestroy, HttpClientService {
	
	private static final PoolingHttpClientConnectionManager CONNECTION_MANAGER;
	private static final CloseableHttpClient CLOSEABLE_HTTP_CLIENT;
	
	static{		
		
		CONNECTION_MANAGER = new PoolingHttpClientConnectionManager();
		CONNECTION_MANAGER.setMaxTotal(500);
		CONNECTION_MANAGER.setDefaultMaxPerRoute(500);
		
		CLOSEABLE_HTTP_CLIENT = HttpClients.custom().setConnectionManager(CONNECTION_MANAGER).build();
		
	}

	@Override
	public String doPost(
							String scheme
							, String host
							, String path
							, MultivaluedMap<String, Object> payload
							, Map<String, String> headers
							, Map<String, String> parameters
							, int connectTimeout
							, int requestTimeout
						) {
		
		HttpEntity entity = null;		
		if(payload != null && !payload.isEmpty()){
			
			MultipartEntityBuilder builder = MultipartEntityBuilder.create().setCharset(StandardCharsets.UTF_8);
			for(Map.Entry<String, List<Object>> entry : payload.entrySet()){

				for(Object o : entry.getValue()){
					
					if(o instanceof String) builder.addTextBody(entry.getKey(), o.toString(), ContentType.TEXT_PLAIN);
					else if(o instanceof ByteArrayPayload){
						ByteArrayPayload data = (ByteArrayPayload) o;
						builder.addBinaryBody(entry.getKey(), data.getData(), ContentType.APPLICATION_OCTET_STREAM, data.getDataName());					
					}
					else throw new RuntimeException(o.getClass() + " not supported yet, only String and " + ByteArrayPayload.class.getCanonicalName());
				
				}
				
			}
			
			entity = builder.build();
			
		}

		return doRequestWithPayload(HTTPMethod.POST, scheme, host, path, entity, headers, parameters, requestTimeout, connectTimeout);
		
	}

	@Override
	public String doPost(
							String scheme
							, String host
							, String path
							, Map<String, String> formData
							, Map<String, String> headers
							, Map<String, String> parameters
							, int connectTimeout
							, int requestTimeout
							) {

		
		List<NameValuePair> data = new ArrayList<NameValuePair>();
		if(formData != null && !formData.isEmpty()){			
			for(Map.Entry<String, String> entry : formData.entrySet()) data.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));				
		}
		
		return doRequestWithPayload(HTTPMethod.POST, scheme, host, path, new UrlEncodedFormEntity(data, StandardCharsets.UTF_8), headers, parameters, requestTimeout, connectTimeout);
		
	}

	@Override
	public String doGet(
						String scheme
						, String host
						, String path
						, Map<String, String> headers
						, Map<String, String> parameters
						, int connectTimeout
						, int requestTimeout
						){
		return doRequestWithoutPayload(HTTPMethod.GET, scheme, host, path, headers, parameters, requestTimeout, connectTimeout);		
	}

	@Override
	public String doGet(
						String scheme
						, String host
						, String path
						, MultivaluedMap<String, String> header
						, MultivaluedMap<String, String> parameters
						, int connectTimeout
						, int requestTimeout
						){
		return doRequestWithoutPayload(HTTPMethod.GET, scheme, host, path, header, parameters, requestTimeout, connectTimeout);		
	}

	@Override
	public String doDelete(
							String scheme
							, String host
							, String path
							, Map<String, String> headers
							, Map<String, String> parameters
							, int connectTimeout
							, int requestTimeout
							){
		return doRequestWithoutPayload(HTTPMethod.DELETE, scheme, host, path, headers, parameters, requestTimeout, connectTimeout);		
	}

	@Override
	public String doPut(
						String scheme
						, String host
						, String path
						, String payload
						, MediaType mediaType
						, Map<String, String> headers
						, Map<String, String> parameters
						, int connectTimeout
						, int requestTimeout
						) {

		StringEntity payloadEntity = new StringEntity(payload, StandardCharsets.UTF_8);
		payloadEntity.setContentType(mediaType.getType() + "/" + mediaType.getSubtype());

		return doRequestWithPayload(HTTPMethod.PUT, scheme, host, path, payloadEntity, headers, parameters, requestTimeout, connectTimeout);
		
	}

	@Override
	public String doPost(
							String scheme
							, String host
							, String path
							, String payload
							, MediaType mediaType
							, Map<String, String> headers
							, Map<String, String> parameters
							, int connectTimeout
							, int requestTimeout
							) {

		StringEntity payloadEntity = new StringEntity(payload, StandardCharsets.UTF_8);
		payloadEntity.setContentType(mediaType.getType() + "/" + mediaType.getSubtype());
		
		return doRequestWithPayload(HTTPMethod.POST, scheme, host, path, payloadEntity, headers, parameters, requestTimeout, connectTimeout);
		
	}
	
	private String doRequestWithPayload(
										HTTPMethod method
										, String scheme
										, String host
										, String path
										, HttpEntity httpEntity
										, Map<String, String> headers
										, Map<String, String> parameters
										, int requestTimeout
										, int connectTimeout
										){
		
		HttpEntityEnclosingRequestBase request;
		if(method.equals(HTTPMethod.POST)) request = new HttpPost();
		else if(method.equals(HTTPMethod.PUT)) request = new HttpPut();
		else if(method.equals(HTTPMethod.PATCH)) request = new HttpPatch();
		else throw new RuntimeException(method + " HTTP method can't have payload");
		
		try {

			URIBuilder uriBuilder = new URIBuilder();
			uriBuilder.setScheme(scheme).setHost(host).setPath(path);			
			if(parameters != null){
				for(Map.Entry<String, String> entry : parameters.entrySet()) uriBuilder.addParameter(entry.getKey(), entry.getValue()); 
			}

			if(headers != null){
				for(Map.Entry<String, String> entry : headers.entrySet()) request.setHeader(entry.getKey(), entry.getValue()); 
			}
			
			request.setURI(uriBuilder.build());
			request.setConfig(
								RequestConfig
											.custom()
											.setConnectTimeout(connectTimeout)
											.setSocketTimeout(requestTimeout)
											.build()
								);
			if(httpEntity != null) request.setEntity(httpEntity);
			
			return CLOSEABLE_HTTP_CLIENT.execute(request, responseHandler);
			
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		} finally {
			if(request != null) request.releaseConnection();
		}
		
	}
	
	private String doRequestWithoutPayload(
											HTTPMethod method
											, String scheme
											, String host
											, String path
											, MultivaluedMap<String, String> headers
											, MultivaluedMap<String, String> parameters
											, int requestTimeout
											, int connectTimeout
											){
		
		HttpRequestBase request;
		if(method.equals(HTTPMethod.GET)) request = new HttpGet();
		else if(method.equals(HTTPMethod.HEAD)) request = new HttpHead();
		else if(method.equals(HTTPMethod.DELETE)) request = new HttpDelete();
		else if(method.equals(HTTPMethod.POST)) request = new HttpPost();
		else if(method.equals(HTTPMethod.PUT)) request = new HttpPut();
		else if(method.equals(HTTPMethod.PATCH)) request = new HttpPatch();
		else throw new RuntimeException(method + " HTTP method not supported");
		
		try {

			URIBuilder uriBuilder = new URIBuilder();
			uriBuilder.setScheme(scheme).setHost(host).setPath(path);
			
			if(parameters != null){
				for(Map.Entry<String, List<String>> entry : parameters.entrySet()){
					for(String s : entry.getValue()) uriBuilder.addParameter(entry.getKey(), s); 
				}
			}

			if(headers != null){
				for(Map.Entry<String, List<String>> entry : headers.entrySet()){
					for(String s : entry.getValue()) request.addHeader(entry.getKey(), s); 
				}
			}
			
			request.setURI(uriBuilder.build());
			request.setConfig(
								RequestConfig
											.custom()
											.setConnectTimeout(connectTimeout)
											.setSocketTimeout(requestTimeout)
											.build()
								);
			
			return CLOSEABLE_HTTP_CLIENT.execute(request, responseHandler);
			
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		} finally {
			if(request != null) request.releaseConnection();
		}
		
	}

	private String doRequestWithoutPayload(
											HTTPMethod method
											, String scheme
											, String host
											, String path
											, Map<String, String> headers
											, Map<String, String> parameters
											, int requestTimeout
											, int connectTimeout
											){
		
		HttpRequestBase request;
		if(method.equals(HTTPMethod.GET)) request = new HttpGet();
		else if(method.equals(HTTPMethod.HEAD)) request = new HttpHead();
		else if(method.equals(HTTPMethod.DELETE)) request = new HttpDelete();
		else if(method.equals(HTTPMethod.POST)) request = new HttpPost();
		else if(method.equals(HTTPMethod.PUT)) request = new HttpPut();
		else if(method.equals(HTTPMethod.PATCH)) request = new HttpPatch();
		else throw new RuntimeException(method + " HTTP method not supported");
		
		try {

			URIBuilder uriBuilder = new URIBuilder();
			uriBuilder.setScheme(scheme).setHost(host).setPath(path);			
			if(parameters != null){
				for(Map.Entry<String, String> entry : parameters.entrySet()) uriBuilder.addParameter(entry.getKey(), entry.getValue()); 
			}

			if(headers != null){
				for(Map.Entry<String, String> entry : headers.entrySet()) request.setHeader(entry.getKey(), entry.getValue()); 
			}
			
			request.setURI(uriBuilder.build());
			request.setConfig(
								RequestConfig
											.custom()
											.setConnectTimeout(connectTimeout)
											.setSocketTimeout(requestTimeout)
											.build()
								);
			
			return CLOSEABLE_HTTP_CLIENT.execute(request, responseHandler);
			
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		} finally {
			if(request != null) request.releaseConnection();
		}
		
	}
	
	private static final ResponseHandler<String> responseHandler = response -> {
		
		int status = response.getStatusLine().getStatusCode();			
        if (status >= 200 && status < 300) return response.getEntity() != null ? EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8) : null;
        else{
        	
        	Map<String, String> headers = new HashMap<>();
            for(Header header : response.getAllHeaders()) headers.put(header.getName(), header.getValue());
            
            throw new KWLHttpException(status, (response.getEntity() != null ? EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8) : ""), headers);
            
        }
		
	};

	@Override
	public void preDestroy() {
		try {
			CLOSEABLE_HTTP_CLIENT.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
