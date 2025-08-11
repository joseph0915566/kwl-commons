package com.kwler.commons.db.facebook.nosql.mongo.model;

import java.util.List;

import org.mongodb.morphia.annotations.Entity;

import com.kwler.commons.db.scheduler.job.nosql.mongo.model.HarvestingResult;

/**
 * 
 * @author Joseph Siegar
 *
 */
@Entity(value = "facebookEventResult", noClassnameStored = true)
public class FacebookEventResult extends HarvestingResult {

	private String pageId;
	private List<Event> events;

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public static class Event{
		
		private String date;
		private String venue;
		private String artist;
		private String event_name;
		private String country;
		private String location;
		
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
		
		public String getEvent_name() {
			return event_name;
		}
		
		public void setEvent_name(String event_name) {
			this.event_name = event_name;
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
		
	}

}
