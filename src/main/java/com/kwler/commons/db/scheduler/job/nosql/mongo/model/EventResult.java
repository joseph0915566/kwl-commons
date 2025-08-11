package com.kwler.commons.db.scheduler.job.nosql.mongo.model;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class EventResult {

	protected String latitude;
	private String description;
	protected String name;
	protected String longitude;
	protected String datetime;
	protected String city;
	protected String region;
	protected String country;
	protected String eventOriginalId;
	protected String venueOriginalId;
	
	public String getLatitude() {
		return latitude;
	}
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLongitude() {
		return longitude;
	}
	
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getEventOriginalId() {
		return eventOriginalId;
	}

	public void setEventOriginalId(String eventOriginalId) {
		this.eventOriginalId = eventOriginalId;
	}

	public String getVenueOriginalId() {
		return venueOriginalId;
	}

	public void setVenueOriginalId(String venueOriginalId) {
		this.venueOriginalId = venueOriginalId;
	}
	
}
