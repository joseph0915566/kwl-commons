package com.kwler.commons.db.facebook.nosql.mongo.model;

import java.util.List;

import org.mongodb.morphia.annotations.Entity;

import com.kwler.commons.db.scheduler.job.nosql.mongo.model.HarvestingResult;

/**
 * 
 * @author Joseph Siegar
 *
 */
@Entity(value = "facebookResult", noClassnameStored = true)
public class FacebookResult extends HarvestingResult {

	private String artistId;
	private long globalFans;
	private long globalStorytellers;
	private List<CountryStat> fansByCountry;	
	private List<CountryStat> storyTellerByCountry;
	
	public String getArtistId() {
		return artistId;
	}
	
	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}

	public long getGlobalFans() {
		return globalFans;
	}

	public void setGlobalFans(long globalFans) {
		this.globalFans = globalFans;
	}

	public long getGlobalStorytellers() {
		return globalStorytellers;
	}

	public void setGlobalStorytellers(long globalStorytellers) {
		this.globalStorytellers = globalStorytellers;
	}

	public List<CountryStat> getFansByCountry() {
		return fansByCountry;
	}

	public void setFansByCountry(List<CountryStat> fansByCountry) {
		this.fansByCountry = fansByCountry;
	}

	public List<CountryStat> getStoryTellerByCountry() {
		return storyTellerByCountry;
	}

	public void setStoryTellerByCountry(List<CountryStat> storyTellerByCountry) {
		this.storyTellerByCountry = storyTellerByCountry;
	}
	
}
