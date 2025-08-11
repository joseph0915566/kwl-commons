package com.kwler.commons.http.model;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class ByteArrayPayload {

	private byte[] data;
	private String dataName;
	
	public byte[] getData() {
		return data;
	}
	
	public void setData(byte[] data) {
		this.data = data;
	}
	
	public String getDataName() {
		return dataName;
	}
	
	public void setDataName(String dataName) {
		this.dataName = dataName;
	}
	
}
