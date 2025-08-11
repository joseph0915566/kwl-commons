package com.kwler.commons.db.spotify.nosql.mongo.model;

import java.util.List;

import org.mongodb.morphia.annotations.Entity;

import com.kwler.commons.db.scheduler.job.nosql.mongo.model.HarvestingResult;

/**
 * 
 * @author Joseph Siegar
 *
 */
@Entity(value = "spotifySimilarArtist", noClassnameStored = true)
public class SpotifySimilarArtist extends HarvestingResult {

	private String artistId;
	private List<SimilarArtist> similarArtists;
	
	public String getArtistId() {
		return artistId;
	}

	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}

	public List<SimilarArtist> getSimilarArtists() {
		return similarArtists;
	}

	public void setSimilarArtists(List<SimilarArtist> similarArtists) {
		this.similarArtists = similarArtists;
	}

	public static class SimilarArtist{
		
		private List<String> genres; 
		private String id; 
		private Followers followers; 
		private String name; 
		private int popularity; 
		private List<Image> images; 
		
		public List<String> getGenres() {
			return genres;
		}

		public void setGenres(List<String> genres) {
			this.genres = genres;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public Followers getFollowers() {
			return followers;
		}

		public void setFollowers(Followers followers) {
			this.followers = followers;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getPopularity() {
			return popularity;
		}

		public void setPopularity(int popularity) {
			this.popularity = popularity;
		}

		public List<Image> getImages() {
			return images;
		}

		public void setImages(List<Image> images) {
			this.images = images;
		}

		public static class Followers{
			
			private long total;

			public long getTotal() {
				return total;
			}

			public void setTotal(long total) {
				this.total = total;
			} 			
			
		}
		
		public static class Image{
			
			private String url;

			public String getUrl() {
				return url;
			}

			public void setUrl(String url) {
				this.url = url;
			} 						
			
		}

	}

}
