package com.kwler.commons.db.twitter.nosql.mongo.dao;

import javax.inject.Inject;

import com.kwler.commons.db.base.nosql.mongo.service.MorphiaService;
import com.kwler.commons.db.scheduler.job.nosql.mongo.dao.HarvestingResultMorphiaDAO;
import com.kwler.commons.db.twitter.nosql.mongo.model.TwitterAR;
import com.kwler.commons.json.JsonService;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class TwitterARMorphiaDAO extends HarvestingResultMorphiaDAO<TwitterAR> implements TwitterARDAO {

	@Inject
	public TwitterARMorphiaDAO(MorphiaService morphiaService, JsonService jsonService) {
		super(morphiaService, jsonService);
	}

	@Override
	public void savePartial(TwitterAR t) {
	}

}
