package com.kwler.commons.db.chart.nosql.mongo.model;

import java.util.List;
import java.util.Map;

import org.mongodb.morphia.annotations.Entity;

import com.kwler.commons.db.scheduler.job.nosql.mongo.model.HarvestingResult;

/**
 * 
 * @author Joseph Siegar
 *
 */
@Entity(value = "artistSummary", noClassnameStored = true)
public class ArtistSummary extends HarvestingResult {

	private String dataSourceId;
	private List<Items> items;
	
	public String getDataSourceId() {
		return dataSourceId;
	}

	public void setDataSourceId(String dataSourceId) {
		this.dataSourceId = dataSourceId;
	}
	
	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

	public static class Items{
		
		private String artist;
		private String location;
		private String bio;
		private List<String> genre;
		private String photoUrl;
		private List<String> similarArtists;
		private Map<String, String> otherData;
		private List<String> track;
		private List<String> socialMedia;
		private String sourceUrl;
		
		public String getArtist() {
			return artist;
		}
		
		public void setArtist(String artist) {
			this.artist = artist;
		}

		public String getLocation() {
			return location;
		}
		
		public void setLocation(String location) {
			this.location = location;
		}
		
		public List<String> getGenre() {
			return genre;
		}
		
		public void setGenre(List<String> genre) {
			this.genre = genre;
		}
		
		public String getBio() {
			return bio;
		}

		public void setBio(String bio) {
			this.bio = bio;
		}

		public String getPhotoUrl() {
			return photoUrl;
		}

		public void setPhotoUrl(String photoUrl) {
			this.photoUrl = photoUrl;
		}

		public List<String> getSimilarArtists() {
			return similarArtists;
		}

		public void setSimilarArtists(List<String> similarArtists) {
			this.similarArtists = similarArtists;
		}

		public Map<String, String> getOtherData() {
			return otherData;
		}

		public void setOtherData(Map<String, String> otherData) {
			this.otherData = otherData;
		}

		public List<String> getTrack() {
			return track;
		}

		public void setTrack(List<String> track) {
			this.track = track;
		}

		public String getSourceUrl() {
			return sourceUrl;
		}

		public void setSourceUrl(String sourceUrl) {
			this.sourceUrl = sourceUrl;
		}

		public List<String> getSocialMedia() {
			return socialMedia;
		}
		
		public void setSocialMedia(List<String> socialMedia) {
			this.socialMedia = socialMedia;
		}

	}
	
}
