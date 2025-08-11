package com.kwler.commons.io.model;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class SSHCredential {

	private String username;
	private String host;
	private String privateKeyPassphrase;
	private String privateKeyQualifiedName;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getHost() {
		return host;
	}
	
	public void setHost(String host) {
		this.host = host;
	}
	
	public String getPrivateKeyPassphrase() {
		return privateKeyPassphrase;
	}
	
	public void setPrivateKeyPassphrase(String privateKeyPassphrase) {
		this.privateKeyPassphrase = privateKeyPassphrase;
	}

	public String getPrivateKeyQualifiedName() {
		return privateKeyQualifiedName;
	}

	public void setPrivateKeyQualifiedName(String privateKeyQualifiedName) {
		this.privateKeyQualifiedName = privateKeyQualifiedName;
	}
	
}
