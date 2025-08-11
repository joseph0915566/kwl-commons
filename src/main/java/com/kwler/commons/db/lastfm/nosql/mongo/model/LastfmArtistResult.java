package com.kwler.commons.db.lastfm.nosql.mongo.model;

import org.mongodb.morphia.annotations.Entity;

import com.kwler.commons.db.scheduler.job.nosql.mongo.model.HarvestingResult;

/**
 * 
 * @author Joseph Siegar
 *
 */
@Entity(value = "lastfmArtistResult", noClassnameStored = true)
public class LastfmArtistResult extends HarvestingResult {

	private String artistId;
	private long listeners;
	private long playcount;
	
	public String getArtistId() {
		return artistId;
	}
	
	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}
	
	public long getListeners() {
		return listeners;
	}
	
	public void setListeners(long listeners) {
		this.listeners = listeners;
	}
	
	public long getPlaycount() {
		return playcount;
	}
	
	public void setPlaycount(long playcount) {
		this.playcount = playcount;
	}
	
}
