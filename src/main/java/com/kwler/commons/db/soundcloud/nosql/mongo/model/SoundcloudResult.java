package com.kwler.commons.db.soundcloud.nosql.mongo.model;

import java.util.List;

import org.mongodb.morphia.annotations.Entity;

import com.kwler.commons.db.scheduler.job.nosql.mongo.model.HarvestingResult;

/**
 * 
 * @author Joseph Siegar
 *
 */
@Entity(value = "soundcloudResult", noClassnameStored = true)
public class SoundcloudResult extends HarvestingResult {

	private String artistId;
	private long followersCount;
	private int trackCount;
	private List<SoundcloudTrack> tracks;
	//manual field in DAO
	
	public String getArtistId() {
		return artistId;
	}
	
	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}

	public long getFollowersCount() {
		return followersCount;
	}

	public void setFollowersCount(long followersCount) {
		this.followersCount = followersCount;
	}

	public int getTrackCount() {
		return trackCount;
	}

	public void setTrackCount(int trackCount) {
		this.trackCount = trackCount;
	}

	public List<SoundcloudTrack> getTracks() {
		return tracks;
	}

	public void setTracks(List<SoundcloudTrack> tracks) {
		this.tracks = tracks;
	}
	
}
