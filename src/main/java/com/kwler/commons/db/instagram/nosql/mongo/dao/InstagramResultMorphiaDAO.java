package com.kwler.commons.db.instagram.nosql.mongo.dao;

import javax.inject.Inject;

import com.kwler.commons.db.base.nosql.mongo.service.MorphiaService;
import com.kwler.commons.db.instagram.nosql.mongo.model.InstagramResult;
import com.kwler.commons.db.scheduler.job.nosql.mongo.dao.HarvestingResultMorphiaDAO;
import com.kwler.commons.json.JsonService;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class InstagramResultMorphiaDAO extends HarvestingResultMorphiaDAO<InstagramResult> implements InstagramResultDAO {

	@Inject
	public InstagramResultMorphiaDAO(MorphiaService morphiaService, JsonService jsonService) {
		super(morphiaService, jsonService);
	}

	@Override
	public void savePartial(InstagramResult t) {}

}
