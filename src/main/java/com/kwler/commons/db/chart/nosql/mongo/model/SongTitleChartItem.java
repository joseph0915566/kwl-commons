package com.kwler.commons.db.chart.nosql.mongo.model;

import java.util.List;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class SongTitleChartItem extends ChartItem {

	private List<Entry> items;
	
	public SongTitleChartItem(){
		chartItemClass = ChartItemClass.SONGTITLE;
	}
	
	public List<Entry> getItems() {
		return items;
	}

	public void setItems(List<Entry> items) {
		this.items = items;
	}

	public static class Entry{
		
		private String artistName;
		private List<SpotifyArtistId> spotifyArtistId;
		private String artistMbid;
		private String trackTitle;
		private String trackMbid;
		private String trackId;
		private int position;
		private int streamCount;
		private String asOfDate;
		
		public String getAsOfDate() {
			return asOfDate;
		}

		public void setAsOfDate(String asOfDate) {
			this.asOfDate = asOfDate;
		}

		public String getArtistName() {
			return artistName;
		}
		
		public void setArtistName(String artistName) {
			this.artistName = artistName;
		}

		public List<SpotifyArtistId> getSpotifyArtistId() {
			return spotifyArtistId;
		}

		public void setSpotifyArtistId(List<SpotifyArtistId> spotifyArtistId) {
			this.spotifyArtistId = spotifyArtistId;
		}

		public String getArtistMbid() {
			return artistMbid;
		}

		public void setArtistMbid(String artistMbid) {
			this.artistMbid = artistMbid;
		}

		public String getTrackMbid() {
			return trackMbid;
		}

		public void setTrackMbid(String trackMbid) {
			this.trackMbid = trackMbid;
		}

		public String getTrackId() {
			return trackId;
		}

		public void setTrackId(String trackId) {
			this.trackId = trackId;
		}

		public String getTrackTitle() {
			return trackTitle;
		}
		
		public void setTrackTitle(String trackTitle) {
			this.trackTitle = trackTitle;
		}
		
		public int getPosition() {
			return position;
		}
		
		public void setPosition(int position) {
			this.position = position;
		}

		public int getStreamCount() {
			return streamCount;
		}

		public void setStreamCount(int streamCount) {
			this.streamCount = streamCount;
		}
		
		public static class SpotifyArtistId{
			
			private String name;
			private String id;
			
			public String getName() {
				return name;
			}
			
			public void setName(String name) {
				this.name = name;
			}
			
			public String getId() {
				return id;
			}
			
			public void setId(String id) {
				this.id = id;
			}

		}
		
	}
	
}
