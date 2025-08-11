package com.kwler.commons.db.twitter.nosql.mongo.dao;

import javax.inject.Inject;

import com.kwler.commons.db.base.nosql.mongo.service.MorphiaService;
import com.kwler.commons.db.scheduler.job.nosql.mongo.dao.HarvestingResultMorphiaDAO;
import com.kwler.commons.db.twitter.nosql.mongo.model.TwitterResult;
import com.kwler.commons.json.JsonService;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class TwitterResultMorphiaDAO extends HarvestingResultMorphiaDAO<TwitterResult> implements TwitterResultDAO {

	@Inject
	public TwitterResultMorphiaDAO(MorphiaService morphiaService, JsonService jsonService) {
		super(morphiaService, jsonService);
	}

	@Override
	public void savePartial(TwitterResult t) {}

}
