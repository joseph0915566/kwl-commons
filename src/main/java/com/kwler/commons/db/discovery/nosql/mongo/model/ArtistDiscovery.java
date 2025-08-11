package com.kwler.commons.db.discovery.nosql.mongo.model;

import java.util.List;

import org.mongodb.morphia.annotations.Entity;

import com.kwler.commons.db.scheduler.job.nosql.mongo.model.HarvestingResult;

/**
 * 
 * @author Joseph Siegar
 *
 */
@Entity(value = "artistDiscovery", noClassnameStored = true)
public class ArtistDiscovery extends HarvestingResult {

	private String artistId;
	private String artistName;
	private String artistSong;
	private String source;
	private String sourceId;
	private String sourceType;
	private String sourceDate;
	private int songPosition;
	private List<Item> items;
	
	public String getArtistId() {
		return artistId;
	}

	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getArtistSong() {
		return artistSong;
	}

	public void setArtistSong(String artistSong) {
		this.artistSong = artistSong;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getSourceDate() {
		return sourceDate;
	}

	public void setSourceDate(String sourceDate) {
		this.sourceDate = sourceDate;
	}

	public int getSongPosition() {
		return songPosition;
	}

	public void setSongPosition(int songPosition) {
		this.songPosition = songPosition;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public static class Item{
		
		private String spotifySongName;
		private String spotifySongId;
		private List<Artist> artists;
		
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
		
		public List<Artist> getArtists() {
			return artists;
		}
		
		public void setArtists(List<Artist> artists) {
			this.artists = artists;
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
