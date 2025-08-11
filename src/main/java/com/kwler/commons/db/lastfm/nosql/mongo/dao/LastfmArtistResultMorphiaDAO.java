package com.kwler.commons.db.lastfm.nosql.mongo.dao;

import javax.inject.Inject;

import com.kwler.commons.db.base.nosql.mongo.service.MorphiaService;
import com.kwler.commons.db.lastfm.nosql.mongo.model.LastfmArtistResult;
import com.kwler.commons.db.scheduler.job.nosql.mongo.dao.HarvestingResultMorphiaDAO;
import com.kwler.commons.json.JsonService;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class LastfmArtistResultMorphiaDAO extends HarvestingResultMorphiaDAO<LastfmArtistResult> implements LastfmArtistResultDAO {

	@Inject
	public LastfmArtistResultMorphiaDAO(MorphiaService morphiaService, JsonService jsonService) {
		super(morphiaService, jsonService);
	}

	@Override
	public void savePartial(LastfmArtistResult t) {}
	
}
