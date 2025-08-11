package com.kwler.commons.db.instagram.nosql.mongo.model;

import java.util.List;

import org.mongodb.morphia.annotations.Entity;

import com.kwler.commons.db.scheduler.job.nosql.mongo.model.HarvestingResult;

/**
 * 
 * @author Joseph Siegar
 *
 */
@Entity(value = "instagramResult", noClassnameStored = true)
public class InstagramResult extends HarvestingResult {

	private String artistId;
	private long followers;
	private long totalMediaCount;
	private List<InstagramUserMedia> medias;
	
	public String getArtistId() {
		return artistId;
	}
	
	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}
	
	public long getFollowers() {
		return followers;
	}
	
	public void setFollowers(long followers) {
		this.followers = followers;
	}
	
	public long getTotalMediaCount() {
		return totalMediaCount;
	}

	public void setTotalMediaCount(long totalMediaCount) {
		this.totalMediaCount = totalMediaCount;
	}

	public List<InstagramUserMedia> getMedias() {
		return medias;
	}
	
	public void setMedias(List<InstagramUserMedia> medias) {
		this.medias = medias;
	}
	
}
