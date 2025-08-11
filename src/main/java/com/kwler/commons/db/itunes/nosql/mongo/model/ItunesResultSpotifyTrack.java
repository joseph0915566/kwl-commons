package com.kwler.commons.db.itunes.nosql.mongo.model;

import java.util.List;

import org.mongodb.morphia.annotations.Entity;

import com.kwler.commons.db.scheduler.job.nosql.mongo.model.HarvestingResult;

/**
 * 
 * @author Joseph Siegar
 *
 */
@Entity(value = "itunesResultSpotifyTrack", noClassnameStored = true)
public class ItunesResultSpotifyTrack extends HarvestingResult {

	private String dataSourceId;
	private int itunesPosition;
	private String itunesArtistId;
	private String itunesArtistName;
	private String itunesSongName;
	private List<Item> items;
	
	public String getDataSourceId() {
		return dataSourceId;
	}

	public void setDataSourceId(String dataSourceId) {
		this.dataSourceId = dataSourceId;
	}

	public int getItunesPosition() {
		return itunesPosition;
	}

	public void setItunesPosition(int itunesPosition) {
		this.itunesPosition = itunesPosition;
	}

	public String getItunesArtistId() {
		return itunesArtistId;
	}

	public void setItunesArtistId(String itunesArtistId) {
		this.itunesArtistId = itunesArtistId;
	}

	public String getItunesArtistName() {
		return itunesArtistName;
	}

	public void setItunesArtistName(String itunesArtistName) {
		this.itunesArtistName = itunesArtistName;
	}

	public String getItunesSongName() {
		return itunesSongName;
	}

	public void setItunesSongName(String itunesSongName) {
		this.itunesSongName = itunesSongName;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public static class Item{
		
		private List<Artist> artists;
		private String spotifySongName;
		private String spotifySongId;
		
		public List<Artist> getArtists() {
			return artists;
		}

		public void setArtists(List<Artist> artists) {
			this.artists = artists;
		}

		public String getSpotifySongName() {
			return spotifySongName;
		}
		
		public void setSpotifySongName(String spotifySongName) {
			this.spotifySongName = spotifySongName;
		}
		
		public String getSpotifySongId() {
			return spotifySongId;
		}

		public void setSpotifySongId(String spotifySongId) {
			this.spotifySongId = spotifySongId;
		}

		public static class Artist{
			
			private String id;
			private String name;
			
			public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
			}

			public String getName() {
				return name;
			}
			
			public void setName(String name) {
				this.name = name;
			}
			
		}
		
	}
	
}
