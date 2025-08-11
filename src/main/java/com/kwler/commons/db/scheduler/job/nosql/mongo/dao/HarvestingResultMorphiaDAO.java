package com.kwler.commons.db.scheduler.job.nosql.mongo.dao;

import java.util.List;

import com.kwler.commons.db.base.nosql.mongo.dao.BaseStringIdMorphiaDAO;
import com.kwler.commons.db.base.nosql.mongo.service.MorphiaService;
import com.kwler.commons.db.scheduler.job.nosql.mongo.model.HarvestingResult;
import com.kwler.commons.json.JsonService;

/**
 * 
 * @author Joseph Siegar
 *
 */
public abstract class HarvestingResultMorphiaDAO<T extends HarvestingResult> extends BaseStringIdMorphiaDAO<T> implements HarvestingResultDAO<T> {

	public HarvestingResultMorphiaDAO(MorphiaService morphiaService, JsonService jsonService) {
		super(morphiaService, jsonService);
	}

	@Override
	public List<T> getByJobId(String jobId){
		return morphiaService.getDatastore().createQuery(thisClazz).field("jobId").equal(jobId).asList();
	}

	@Override
	public List<T> getByJobId(List<String> jobIds){
		return morphiaService.getDatastore().createQuery(thisClazz).field("jobId").in(jobIds).asList();
	}

}
