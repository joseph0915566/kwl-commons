package com.kwler.commons.db.scheduler.job.nosql.mongo.dao;

import javax.inject.Inject;

import com.kwler.commons.db.base.nosql.mongo.dao.BaseObjectIdMorphiaDAO;
import com.kwler.commons.db.base.nosql.mongo.service.MorphiaService;
import com.kwler.commons.db.scheduler.job.nosql.mongo.model.Job;
import com.kwler.commons.json.JsonService;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class JobMorphiaDAO extends BaseObjectIdMorphiaDAO<Job> implements JobDAO {

	@Inject
	public JobMorphiaDAO(MorphiaService morphiaService, JsonService jsonService) {
		super(morphiaService, jsonService);
	}

}
