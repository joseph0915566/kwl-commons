package com.kwler.commons.db.spotify.nosql.mongo.model;

import java.util.List;
import java.util.Map;

import org.mongodb.morphia.annotations.Entity;

import com.kwler.commons.db.scheduler.job.nosql.mongo.model.HarvestingResult;

/**
 * 
 * @author Joseph Siegar
 *
 */
@Entity(value = "spotifyAlbum", noClassnameStored = true)
public class SpotifyAlbum extends HarvestingResult {

	private String artistId;
	private String albumId;
	private String uri;
	private String name;
	private String harvestType;
	private String releaseDate;
	private String releaseDatePrecision;
	private String type;
	private String albumGroup;
	private List<String> genres;
	private String label;
	private List<String> images;
	private Map<String, Track> tracks;
	
	public String getArtistId() {
		return artistId;
	}

	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}

	public String getAlbumId() {
		return albumId;
	}

	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHarvestType() {
		return harvestType;
	}

	public void setHarvestType(String harvestType) {
		this.harvestType = harvestType;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getReleaseDatePrecision() {
		return releaseDatePrecision;
	}

	public void setReleaseDatePrecision(String releaseDatePrecision) {
		this.releaseDatePrecision = releaseDatePrecision;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAlbumGroup() {
		return albumGroup;
	}

	public void setAlbumGroup(String albumGroup) {
		this.albumGroup = albumGroup;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public Map<String, Track> getTracks() {
		return tracks;
	}

	public void setTracks(Map<String, Track> tracks) {
		this.tracks = tracks;
	}

	public static class Track{
		
		private String id;
		private String uri;
		private String name;
		private int trackNumber;
		private List<Artist> artists;
		
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getUri() {
			return uri;
		}

		public void setUri(String uri) {
			this.uri = uri;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getTrackNumber() {
			return trackNumber;
		}

		public void setTrackNumber(int trackNumber) {
			this.trackNumber = trackNumber;
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
