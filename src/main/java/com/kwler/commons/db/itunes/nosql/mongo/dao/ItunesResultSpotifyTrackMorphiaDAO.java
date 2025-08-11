package com.kwler.commons.db.itunes.nosql.mongo.dao;

import javax.inject.Inject;

import com.kwler.commons.db.base.nosql.mongo.service.MorphiaService;
import com.kwler.commons.db.itunes.nosql.mongo.model.ItunesResultSpotifyTrack;
import com.kwler.commons.db.scheduler.job.nosql.mongo.dao.HarvestingResultMorphiaDAO;
import com.kwler.commons.json.JsonService;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class ItunesResultSpotifyTrackMorphiaDAO extends HarvestingResultMorphiaDAO<ItunesResultSpotifyTrack> implements ItunesResultSpotifyTrackDAO {

	@Inject
	public ItunesResultSpotifyTrackMorphiaDAO(MorphiaService morphiaService, JsonService jsonService) {
		super(morphiaService, jsonService);
	}

	@Override
	public void savePartial(ItunesResultSpotifyTrack t) {
	}

}
