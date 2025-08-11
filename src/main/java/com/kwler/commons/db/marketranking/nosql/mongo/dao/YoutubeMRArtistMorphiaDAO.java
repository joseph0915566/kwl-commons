package com.kwler.commons.db.marketranking.nosql.mongo.dao;

import javax.inject.Inject;

import com.kwler.commons.db.base.nosql.mongo.service.MorphiaService;
import com.kwler.commons.db.marketranking.nosql.mongo.model.YoutubeMRArtist;
import com.kwler.commons.db.scheduler.job.nosql.mongo.dao.HarvestingResultMorphiaDAO;
import com.kwler.commons.json.JsonService;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class YoutubeMRArtistMorphiaDAO extends HarvestingResultMorphiaDAO<YoutubeMRArtist> implements YoutubeMRArtistDAO {

	@Inject
	public YoutubeMRArtistMorphiaDAO(MorphiaService morphiaService, JsonService jsonService) {
		super(morphiaService, jsonService);
	}

	@Override
	public void savePartial(YoutubeMRArtist t) {}

}
