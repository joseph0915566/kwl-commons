package com.kwler.commons.db.itunes.nosql.mongo.model;

import java.util.List;

import org.mongodb.morphia.annotations.Entity;

import com.kwler.commons.db.scheduler.job.nosql.mongo.model.HarvestingResult;

/**
 * 
 * @author Joseph Siegar
 *
 */
@Entity(value = "itunesResult", noClassnameStored = true)
public class ITunesResult extends HarvestingResult {

	private String dataSourceId;
	private List<Item> items;
	
	public String getDataSourceId() {
		return dataSourceId;
	}

	public void setDataSourceId(String dataSourceId) {
		this.dataSourceId = dataSourceId;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public static class Item{
		
		private int position;
		private String artistUrl;
		private String artistId;
		private String artistName;
		private String artworkUrl100;
		private String collectionName;
		private String copyright;
		private String id;
		private String kind;
		private String name;
		private String releaseDate;
		private String url;
		private List<Genre> genres;
		
		public int getPosition() {
			return position;
		}

		public void setPosition(int position) {
			this.position = position;
		}

		public String getArtistUrl() {
			return artistUrl;
		}

		public void setArtistUrl(String artistUrl) {
			this.artistUrl = artistUrl;
		}

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

		public String getArtworkUrl100() {
			return artworkUrl100;
		}

		public void setArtworkUrl100(String artworkUrl100) {
			this.artworkUrl100 = artworkUrl100;
		}

		public String getCollectionName() {
			return collectionName;
		}

		public void setCollectionName(String collectionName) {
			this.collectionName = collectionName;
		}

		public String getCopyright() {
			return copyright;
		}

		public void setCopyright(String copyright) {
			this.copyright = copyright;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getKind() {
			return kind;
		}

		public void setKind(String kind) {
			this.kind = kind;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getReleaseDate() {
			return releaseDate;
		}

		public void setReleaseDate(String releaseDate) {
			this.releaseDate = releaseDate;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public List<Genre> getGenres() {
			return genres;
		}

		public void setGenres(List<Genre> genres) {
			this.genres = genres;
		}

		public static class Genre{
			
			private String genreId;
			private String name;
			private String url;
			
			public String getGenreId() {
				return genreId;
			}
			
			public void setGenreId(String genreId) {
				this.genreId = genreId;
			}
			
			public String getName() {
				return name;
			}
			
			public void setName(String name) {
				this.name = name;
			}
			
			public String getUrl() {
				return url;
			}
			
			public void setUrl(String url) {
				this.url = url;
			}
			
		}
		
	}
	
}
