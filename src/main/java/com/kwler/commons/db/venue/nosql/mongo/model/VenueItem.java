package com.kwler.commons.db.venue.nosql.mongo.model;

import java.util.List;

import org.mongodb.morphia.annotations.Entity;

import com.kwler.commons.db.scheduler.job.nosql.mongo.model.HarvestingResult;

/**
 * 
 * @author Joseph Siegar
 *
 */
@Entity(value = "venueItem", noClassnameStored = true)
public class VenueItem extends HarvestingResult {

	private String venueId;
	private List<Entry> items;

	public String getVenueId() {
		return venueId;
	}

	public void setVenueId(String venueId) {
		this.venueId = venueId;
	}

	public List<Entry> getItems() {
		return items;
	}

	public void setItems(List<Entry> items) {
		this.items = items;
	}

	public static class Entry{
		
		private String date;
		private String venue;
		private String artist;
		private String country;
		private String location;
		private String website;
		private String twitter;
		private String triplej;
		private String bandcamp;
		
		public String getDate() {
			return date;
		}
		
		public void setDate(String date) {
			this.date = date;
		}
		
		public String getVenue() {
			return venue;
		}
		
		public void setVenue(String venue) {
			this.venue = venue;
		}
		
		public String getArtist() {
			return artist;
		}
		
		public void setArtist(String artist) {
			this.artist = artist;
		}
		
		public String getCountry() {
			return country;
		}
		
		public void setCountry(String country) {
			this.country = country;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public String getWebsite() {
			return website;
		}

		public void setWebsite(String website) {
			this.website = website;
		}

		public String getTwitter() {
			return twitter;
		}

		public void setTwitter(String twitter) {
			this.twitter = twitter;
		}

		public String getTriplej() {
			return triplej;
		}

		public void setTriplej(String triplej) {
			this.triplej = triplej;
		}

		public String getBandcamp() {
			return bandcamp;
		}

		public void setBandcamp(String bandcamp) {
			this.bandcamp = bandcamp;
		}
		
	}

}
