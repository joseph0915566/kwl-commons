package com.kwler.commons.db.chart.nosql.mongo.model;

import java.util.List;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class SongIdChartItem extends ChartItem {

	private List<Entry> items;
	
	public SongIdChartItem(){
		chartItemClass = ChartItemClass.SONGID;
	}
	
	public List<Entry> getItems() {
		return items;
	}

	public void setItems(List<Entry> items) {
		this.items = items;
	}

	public static class Entry{
		
		private Long songId;
		private String spotifyArtistId;
		private int position;
		
		public Long getSongId() {
			return songId;
		}

		public void setSongId(Long songId) {
			this.songId = songId;
		}

		public String getSpotifyArtistId() {
			return spotifyArtistId;
		}

		public void setSpotifyArtistId(String spotifyArtistId) {
			this.spotifyArtistId = spotifyArtistId;
		}

		public int getPosition() {
			return position;
		}
		
		public void setPosition(int position) {
			this.position = position;
		}
		
	}

}
