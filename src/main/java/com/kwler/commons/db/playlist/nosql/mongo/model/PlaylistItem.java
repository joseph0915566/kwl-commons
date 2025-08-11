package com.kwler.commons.db.playlist.nosql.mongo.model;

import java.util.List;

import org.mongodb.morphia.annotations.Entity;

import com.kwler.commons.db.scheduler.job.nosql.mongo.model.HarvestingResult;

/**
 * 
 * @author Joseph Siegar
 *
 */
@Entity(value = "playlistItem", noClassnameStored = true)
public class PlaylistItem extends HarvestingResult {

	private String playlistId;
	private List<Entry> items;
	
	public String getPlaylistId() {
		return playlistId;
	}

	public void setPlaylistId(String playlistId) {
		this.playlistId = playlistId;
	}

	public List<Entry> getItems() {
		return items;
	}

	public void setItems(List<Entry> items) {
		this.items = items;
	}

	public static class Entry{
		
		private String country;
		private String artistName;
		private String trackTitle;
		private String content;
		
		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getArtistName() {
			return artistName;
		}
		
		public void setArtistName(String artistName) {
			this.artistName = artistName;
		}
		
		public String getTrackTitle() {
			return trackTitle;
		}
		
		public void setTrackTitle(String trackTitle) {
			this.trackTitle = trackTitle;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}
		
	}
	
}
