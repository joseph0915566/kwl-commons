package com.kwler.commons.db.twitter.nosql.mongo.model;

import java.util.List;

import org.mongodb.morphia.annotations.Entity;

import com.kwler.commons.db.scheduler.job.nosql.mongo.model.HarvestingResult;

/**
 * 
 * @author Joseph Siegar
 *
 */
@Entity(value = "twitterEngagementResultGnip", noClassnameStored = true)
public class TwitterEngagementResultGnip extends HarvestingResult {

	private String repliedArtistId;
	private String fullDate;
	private List<String> mentionedArtistIds;
	private Location twitterGeoLocation;
	private List<Location> gnipLocations;
	private List<Location> userDerivedLocations;

	public List<Location> getGnipLocations() {
		return gnipLocations;
	}

	public void setGnipLocations(List<Location> gnipLocations) {
		this.gnipLocations = gnipLocations;
	}

	public List<Location> getUserDerivedLocations() {
		return userDerivedLocations;
	}

	public void setUserDerivedLocations(List<Location> userDerivedLocations) {
		this.userDerivedLocations = userDerivedLocations;
	}

	public String getRepliedArtistId() {
		return repliedArtistId;
	}

	public void setRepliedArtistId(String repliedArtistId) {
		this.repliedArtistId = repliedArtistId;
	}

	public List<String> getMentionedArtistIds() {
		return mentionedArtistIds;
	}

	public Location getTwitterGeoLocation() {
		return twitterGeoLocation;
	}

	public void setTwitterGeoLocation(Location twitterGeoLocation) {
		this.twitterGeoLocation = twitterGeoLocation;
	}

	public void setMentionedArtistIds(List<String> mentionedArtistIds) {
		this.mentionedArtistIds = mentionedArtistIds;
	}

	public String getFullDate() {
		return fullDate;
	}

	public void setFullDate(String fullDate) {
		this.fullDate = fullDate;
	}
	
	public static class Location{
		
		private String country;
		private String locality;
		private String region;
		private String subRegion;
		private List<String> coordinates;

		public String getLocality() {
			return locality;
		}

		public void setLocality(String locality) {
			this.locality = locality;
		}

		public String getRegion() {
			return region;
		}

		public void setRegion(String region) {
			this.region = region;
		}

		public String getSubRegion() {
			return subRegion;
		}

		public void setSubRegion(String subRegion) {
			this.subRegion = subRegion;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public List<String> getCoordinates() {
			return coordinates;
		}

		public void setCoordinates(List<String> coordinates) {
			this.coordinates = coordinates;
		}

	}
	
}
