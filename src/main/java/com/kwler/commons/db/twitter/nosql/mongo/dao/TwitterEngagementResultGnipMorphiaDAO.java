package com.kwler.commons.db.twitter.nosql.mongo.dao;

import javax.inject.Inject;

import com.kwler.commons.db.base.nosql.mongo.service.MorphiaService;
import com.kwler.commons.db.scheduler.job.nosql.mongo.dao.HarvestingResultMorphiaDAO;
import com.kwler.commons.db.twitter.nosql.mongo.model.TwitterEngagementResultGnip;
import com.kwler.commons.json.JsonService;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class TwitterEngagementResultGnipMorphiaDAO extends HarvestingResultMorphiaDAO<TwitterEngagementResultGnip> implements TwitterEngagementResultGnipDAO {

	@Inject
	public TwitterEngagementResultGnipMorphiaDAO(MorphiaService morphiaService, JsonService jsonService) {
		super(morphiaService, jsonService);
	}

	@Override
	public void savePartial(TwitterEngagementResultGnip t) {}

}
