package com.kwler.commons.db.facebook.nosql.mongo.dao;

import javax.inject.Inject;

import com.kwler.commons.db.base.nosql.mongo.service.MorphiaService;
import com.kwler.commons.db.facebook.nosql.mongo.model.FacebookEventResult;
import com.kwler.commons.db.scheduler.job.nosql.mongo.dao.HarvestingResultMorphiaDAO;
import com.kwler.commons.json.JsonService;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class FacebookEventResultMorphiaDAO extends HarvestingResultMorphiaDAO<FacebookEventResult> implements FacebookEventResultDAO {

	@Inject
	public FacebookEventResultMorphiaDAO(MorphiaService morphiaService, JsonService jsonService) {
		super(morphiaService, jsonService);
	}

	@Override
	public void savePartial(FacebookEventResult t) {}

}
