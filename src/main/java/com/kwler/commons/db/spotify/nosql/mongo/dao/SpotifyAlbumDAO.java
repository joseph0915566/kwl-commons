package com.kwler.commons.db.spotify.nosql.mongo.dao;

import java.util.List;

import com.kwler.commons.db.scheduler.job.nosql.mongo.dao.HarvestingResultDAO;
import com.kwler.commons.db.spotify.nosql.mongo.model.SpotifyAlbum;
import com.kwler.commons.db.spotify.nosql.mongo.model.SpotifyAlbum.Track;

/**
 * 
 * @author Joseph Siegar
 *
 */
public interface SpotifyAlbumDAO extends HarvestingResultDAO<SpotifyAlbum> {

	public void addTracks(String artistId, List<Track> tracks);
	public void deleteAll();
	//4056
	public List<SpotifyAlbum> findByArtist(String artistId);
	
}
