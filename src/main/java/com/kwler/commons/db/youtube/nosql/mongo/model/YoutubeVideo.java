package com.kwler.commons.db.youtube.nosql.mongo.model;

import java.util.List;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class YoutubeVideo {

	private String id;
	private String title;
	private int duration;
	private long viewCount;
	private long likeCount;
	private long dislikeCount;
	private long favoriteCount;
	private long commentCount;
	private String publishedAt;
	private List<String> tags;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public long getViewCount() {
		return viewCount;
	}
	
	public void setViewCount(long viewCount) {
		this.viewCount = viewCount;
	}
	
	public long getLikeCount() {
		return likeCount;
	}
	
	public void setLikeCount(long likeCount) {
		this.likeCount = likeCount;
	}
	
	public long getDislikeCount() {
		return dislikeCount;
	}
	
	public void setDislikeCount(long dislikeCount) {
		this.dislikeCount = dislikeCount;
	}
	
	public long getFavoriteCount() {
		return favoriteCount;
	}
	
	public void setFavoriteCount(long favoriteCount) {
		this.favoriteCount = favoriteCount;
	}
	
	public long getCommentCount() {
		return commentCount;
	}
	
	public void setCommentCount(long commentCount) {
		this.commentCount = commentCount;
	}

	public String getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(String publishedAt) {
		this.publishedAt = publishedAt;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
}
