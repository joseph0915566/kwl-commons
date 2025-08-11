package com.kwler.commons.db.twitter.nosql.mongo.model;

import java.util.List;

import org.mongodb.morphia.annotations.Entity;

import com.kwler.commons.db.scheduler.job.nosql.mongo.model.HarvestingResult;

/**
 * 
 * @author Joseph Siegar
 *
 */
@Entity(value = "twitterAR", noClassnameStored = true)
public class TwitterAR extends HarvestingResult {

	private String accountId;
	private List<Tweet> tweets;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
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
		
	}

}
