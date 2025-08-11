package com.kwler.commons.db.facebook.nosql.mongo.dao;

import javax.inject.Inject;

import com.kwler.commons.db.base.nosql.mongo.service.MorphiaService;
import com.kwler.commons.db.facebook.nosql.mongo.model.FacebookResult;
import com.kwler.commons.db.scheduler.job.nosql.mongo.dao.HarvestingResultMorphiaDAO;
import com.kwler.commons.json.JsonService;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class FacebookResultMorphiaDAO extends HarvestingResultMorphiaDAO<FacebookResult> implements FacebookResultDAO {

	@Inject
	public FacebookResultMorphiaDAO(MorphiaService morphiaService, JsonService jsonService) {
		super(morphiaService, jsonService);
	}

	@Override
	public void savePartial(FacebookResult t) {}

}
