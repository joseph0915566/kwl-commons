package com.kwler.commons.db.spotify.nosql.mongo.model;

import java.util.List;

import org.mongodb.morphia.annotations.Entity;

import com.kwler.commons.db.scheduler.job.nosql.mongo.model.HarvestingResult;

/**
 * 
 * @author Joseph Siegar
 *
 */
@Entity(value = "spotifyResult", noClassnameStored = true)
public class SpotifyResult extends HarvestingResult {

	private String artistId;
	private long followers;
	private int popularity;
	private List<String> genres;
	private List<String> images;
	private List<TopTrack> topTracks;
	
	public String getArtistId() {
		return artistId;
	}

	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}
	
	public long getFollowers() {
		return followers;
	}

	public void setFollowers(long followers) {
		this.followers = followers;
	}

	public int getPopularity() {
		return popularity;
	}
	
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}
	
	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public List<TopTrack> getTopTracks() {
		return topTracks;
	}

	public void setTopTracks(List<TopTrack> topTracks) {
		this.topTracks = topTracks;
	}

	public static class TopTrack{
		
		private String id;
		private List<Image> albumImages;
		private String title;
		private int popularity;
		
		public String getId() {
			return id;
		}
		
		public void setId(String id) {
			this.id = id;
		}
		
		public List<Image> getAlbumImages() {
			return albumImages;
		}

		public void setAlbumImages(List<Image> albumImages) {
			this.albumImages = albumImages;
		}

		public String getTitle() {
			return title;
		}
		
		public void setTitle(String title) {
			this.title = title;
		}
		
		public int getPopularity() {
			return popularity;
		}
		
		public void setPopularity(int popularity) {
			this.popularity = popularity;
		}
		
		public static class Image{
			
			private int height;
			private int width;
			private String url;
			
			public int getHeight() {
				return height;
			}
			
			public void setHeight(int height) {
				this.height = height;
			}
			
			public int getWidth() {
				return width;
			}
			
			public void setWidth(int width) {
				this.width = width;
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
