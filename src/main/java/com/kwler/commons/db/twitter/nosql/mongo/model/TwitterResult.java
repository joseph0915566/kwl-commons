package com.kwler.commons.db.twitter.nosql.mongo.model;

import java.util.List;

import org.mongodb.morphia.annotations.Entity;

import com.kwler.commons.db.scheduler.job.nosql.mongo.model.HarvestingResult;

/**
 * 
 * @author Joseph Siegar
 *
 */
@Entity(value = "twitterResult", noClassnameStored = true)
public class TwitterResult extends HarvestingResult {

	private String artistId;
	private long followersCount;	
	private long friendsCount;
	private long listedCount;
	private long favouritesCount;
	private long statusesCount;
	private List<Tweet> tweets;

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
	
	public long getFriendsCount() {
		return friendsCount;
	}
	
	public void setFriendsCount(long friendsCount) {
		this.friendsCount = friendsCount;
	}
	
	public long getListedCount() {
		return listedCount;
	}
	
	public void setListedCount(long listedCount) {
		this.listedCount = listedCount;
	}
	
	public long getFavouritesCount() {
		return favouritesCount;
	}
	
	public void setFavouritesCount(long favouritesCount) {
		this.favouritesCount = favouritesCount;
	}
	
	public long getStatusesCount() {
		return statusesCount;
	}
	
	public void setStatusesCount(long statusesCount) {
		this.statusesCount = statusesCount;
	}
	
	public List<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}

	public static class Tweet{
		
		private String id;
		private String text;
		private long retweetCount;
		private long favoriteCount;
		
		public String getId() {
			return id;
		}
		
		public void setId(String id) {
			this.id = id;
		}
		
		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public long getRetweetCount() {
			return retweetCount;
		}
		
		public void setRetweetCount(long retweetCount) {
			this.retweetCount = retweetCount;
		}
		
		public long getFavoriteCount() {
			return favoriteCount;
		}
		
		public void setFavoriteCount(long favoriteCount) {
			this.favoriteCount = favoriteCount;
		}
		
	}
	
}
