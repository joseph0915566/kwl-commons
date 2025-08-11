package com.kwler.commons.db.youtube.nosql.mongo.model;

import org.mongodb.morphia.annotations.Entity;

import com.kwler.commons.db.scheduler.job.nosql.mongo.model.HarvestingResult;

/**
 * 
 * @author Joseph Siegar
 *
 */
@Entity(value = "youtubeResult", noClassnameStored = true)
public class YoutubeResult extends HarvestingResult {

	private String artistId;
	private YoutubeChannel channel;
	//manual field in DAO
	
	public String getArtistId() {
		return artistId;
	}
	
	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}

	public YoutubeChannel getChannel() {
		return channel;
	}

	public void setChannel(YoutubeChannel channel) {
		this.channel = channel;
	}
	
}
