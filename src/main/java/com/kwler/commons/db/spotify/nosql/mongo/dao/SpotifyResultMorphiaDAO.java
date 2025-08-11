package com.kwler.commons.db.spotify.nosql.mongo.dao;

import javax.inject.Inject;

import com.kwler.commons.db.base.nosql.mongo.service.MorphiaService;
import com.kwler.commons.db.scheduler.job.nosql.mongo.dao.HarvestingResultMorphiaDAO;
import com.kwler.commons.db.spotify.nosql.mongo.model.SpotifyResult;
import com.kwler.commons.json.JsonService;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class SpotifyResultMorphiaDAO extends HarvestingResultMorphiaDAO<SpotifyResult> implements SpotifyResultDAO {

	@Inject
	public SpotifyResultMorphiaDAO(MorphiaService morphiaService, JsonService jsonService) {
		super(morphiaService, jsonService);
	}

	@Override
	public void savePartial(SpotifyResult t) {}

}
