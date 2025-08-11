package com.kwler.commons.db.youtube.nosql.mongo.model;

import java.util.List;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class YoutubeChannel {

	private String id;
	private String title;
	private long viewCount;
	private long commentCount;
	private long subscriberCount;
	private long videoCount;
	private List<YoutubeVideo> videos;
	
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

	public long getViewCount() {
		return viewCount;
	}
	
	public void setViewCount(long viewCount) {
		this.viewCount = viewCount;
	}
	
	public long getCommentCount() {
		return commentCount;
	}
	
	public void setCommentCount(long commentCount) {
		this.commentCount = commentCount;
	}
	
	public long getSubscriberCount() {
		return subscriberCount;
	}
	
	public void setSubscriberCount(long subscriberCount) {
		this.subscriberCount = subscriberCount;
	}
	
	public long getVideoCount() {
		return videoCount;
	}
	
	public void setVideoCount(long videoCount) {
		this.videoCount = videoCount;
	}
	
	public List<YoutubeVideo> getVideos() {
		return videos;
	}
	
	public void setVideos(List<YoutubeVideo> videos) {
		this.videos = videos;
	}
	
}
