package com.kwler.commons.db.scheduler.job.nosql.mongo.dao;

import java.util.List;

import com.kwler.commons.db.base.nosql.mongo.dao.BaseStringIdDAO;
import com.kwler.commons.db.scheduler.job.nosql.mongo.model.HarvestingResult;

/**
 * 
 * @author Joseph Siegar
 *
 */
public interface HarvestingResultDAO<T extends HarvestingResult> extends BaseStringIdDAO<T> {

	void savePartial(T t);
	List<T> getByJobId(String jobId);
	List<T> getByJobId(List<String> jobId);
	
}
