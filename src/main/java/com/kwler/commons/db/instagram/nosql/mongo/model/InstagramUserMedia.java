package com.kwler.commons.db.instagram.nosql.mongo.model;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class InstagramUserMedia {

	private String originalMediaId;
	private String type;
	private String url;
	private long comments;
	private long views;
	private long createdTime;
	private long like;
	
	public String getOriginalMediaId() {
		return originalMediaId;
	}

	public void setOriginalMediaId(String originalMediaId) {
		this.originalMediaId = originalMediaId;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getComments() {
		return comments;
	}
	
	public void setComments(long comments) {
		this.comments = comments;
	}
	
	public long getViews() {
		return views;
	}

	public void setViews(long views) {
		this.views = views;
	}

	public long getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(long createdTime) {
		this.createdTime = createdTime;
	}

	public long getLike() {
		return like;
	}
	
	public void setLike(long like) {
		this.like = like;
	}
	
}
