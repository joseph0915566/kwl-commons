package com.kwler.commons.db.spotify.nosql.mongo.dao;

import java.util.List;

import javax.inject.Inject;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import com.kwler.commons.db.base.nosql.mongo.service.MorphiaService;
import com.kwler.commons.db.scheduler.job.nosql.mongo.dao.HarvestingResultMorphiaDAO;
import com.kwler.commons.db.spotify.nosql.mongo.model.SpotifyAlbum;
import com.kwler.commons.db.spotify.nosql.mongo.model.SpotifyAlbum.Track;
import com.kwler.commons.json.JsonService;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class SpotifyAlbumMorphiaDAO extends HarvestingResultMorphiaDAO<SpotifyAlbum> implements SpotifyAlbumDAO {

	@Inject
	public SpotifyAlbumMorphiaDAO(MorphiaService morphiaService, JsonService jsonService) {
		super(morphiaService, jsonService);
	}

	@Override
	public void savePartial(SpotifyAlbum album) {
		
		Datastore datastore = morphiaService.getDatastore();
		Query<SpotifyAlbum> query = datastore.createQuery(SpotifyAlbum.class)
										.field("_id").equal(album.getId());
		
		UpdateOperations<SpotifyAlbum> op = datastore.createUpdateOperations(SpotifyAlbum.class);
		op.set("genres", album.getGenres());
		op.set("label", album.getLabel());
		
		datastore.update(query, op, true);
		
	}

	@Override
	public void addTracks(String mongoId, List<Track> tracks) {
		
		Datastore datastore = morphiaService.getDatastore();
		Query<SpotifyAlbum> query = datastore.createQuery(SpotifyAlbum.class)
										.field("_id").equal(mongoId);
		
		UpdateOperations<SpotifyAlbum> op = datastore.createUpdateOperations(SpotifyAlbum.class);
		for(Track track : tracks) op.set("tracks." + track.getId(), track);
		
		datastore.update(query, op, true);
		
	}

	@Override
	public void deleteAll() {
		morphiaService.getDatabase().getCollection("spotifyAlbum").drop();
	}
	
	
	@Override
	public List<SpotifyAlbum> findByArtist(String artistId) {
		
		Datastore datastore = morphiaService.getDatastore();
		Query<SpotifyAlbum> query = datastore.createQuery(SpotifyAlbum.class)
										.field("artistId").equal(artistId);
		query.or(query.criteria("albumGroup").equal("single") , query.criteria("albumGroup").equal("album"))	;							
		return query.asList();
	}

}
