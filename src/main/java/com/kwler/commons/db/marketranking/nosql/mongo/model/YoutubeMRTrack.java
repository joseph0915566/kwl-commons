package com.kwler.commons.db.marketranking.nosql.mongo.model;

import java.util.List;

import org.mongodb.morphia.annotations.Entity;

import com.kwler.commons.db.scheduler.job.nosql.mongo.model.HarvestingResult;

/**
 * 
 * @author Joseph Siegar
 *
 */
@Entity(value = "youtubeMRTrack", noClassnameStored = true)
public class YoutubeMRTrack extends HarvestingResult {

	private String dataSourceId;
	private List<Entry> items;
	private String country;
	private String asOfDate;

	public String getDataSourceId() {
		return dataSourceId;
	}

	public void setDataSourceId(String dataSourceId) {
		this.dataSourceId = dataSourceId;
	}

	public List<Entry> getItems() {
		return items;
	}

	public void setItems(List<Entry> items) {
		this.items = items;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getAsOfDate() {
		return asOfDate;
	}
	
	public void setAsOfDate(String asOfDate) {
		this.asOfDate = asOfDate;
	}

	public static class Entry{
		
		private String artist;
		private String title;
		private String position;
		private int view;
		
		public String getArtist() {
			return artist;
		}
		
		public void setArtist(String artist) {
			this.artist = artist;
		}
		
		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getPosition() {
			return position;
		}
		
		public void setPosition(String position) {
			this.position = position;
		}
		
		public int getView() {
			return view;
		}
		
		public void setView(int view) {
			this.view = view;
		}

	}

}
