package com.kwler.commons.db.soundcloud.nosql.mongo.model;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class SoundcloudTrack {

	private String uri;
	private String artworkUrl;
	private String title;
	private long playbackCount;
	private long downloadCount;
	private long favoritingsCount;
	private long commentCount;
	private String trackId;
	private String uploadedDate;

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getArtworkUrl() {
		return artworkUrl;
	}

	public void setArtworkUrl(String artworkUrl) {
		this.artworkUrl = artworkUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getPlaybackCount() {
		return playbackCount;
	}
	
	public void setPlaybackCount(long playbackCount) {
		this.playbackCount = playbackCount;
	}
	
	public long getDownloadCount() {
		return downloadCount;
	}
	
	public void setDownloadCount(long downloadCount) {
		this.downloadCount = downloadCount;
	}
	
	public long getFavoritingsCount() {
		return favoritingsCount;
	}
	
	public void setFavoritingsCount(long favoritingsCount) {
		this.favoritingsCount = favoritingsCount;
	}
	
	public long getCommentCount() {
		return commentCount;
	}
	
	public void setCommentCount(long commentCount) {
		this.commentCount = commentCount;
	}

	public String getTrackId() {
		return trackId;
	}

	public void setTrackId(String trackId) {
		this.trackId = trackId;
	}

	public String getUploadedDate() {
		return uploadedDate;
	}

	public void setUploadedDate(String uploadedDate) {
		this.uploadedDate = uploadedDate;
	}	
	
}
