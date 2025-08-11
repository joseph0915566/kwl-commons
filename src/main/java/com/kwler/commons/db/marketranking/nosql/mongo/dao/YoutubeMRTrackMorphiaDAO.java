package com.kwler.commons.db.marketranking.nosql.mongo.dao;

import javax.inject.Inject;

import com.kwler.commons.db.base.nosql.mongo.service.MorphiaService;
import com.kwler.commons.db.marketranking.nosql.mongo.model.YoutubeMRTrack;
import com.kwler.commons.db.scheduler.job.nosql.mongo.dao.HarvestingResultMorphiaDAO;
import com.kwler.commons.json.JsonService;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class YoutubeMRTrackMorphiaDAO extends HarvestingResultMorphiaDAO<YoutubeMRTrack> implements YoutubeMRTrackDAO {

	@Inject
	public YoutubeMRTrackMorphiaDAO(MorphiaService morphiaService, JsonService jsonService) {
		super(morphiaService, jsonService);
	}

	@Override
	public void savePartial(YoutubeMRTrack t) {}

}
