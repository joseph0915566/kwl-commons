package com.kwler.commons.db.worker.log.nosql.mongo.dao;

import com.kwler.commons.db.base.nosql.mongo.dao.BaseStringIdDAO;
import com.kwler.commons.db.worker.log.nosql.mongo.model.WorkerStatus;

/**
 * 
 * @author Joseph Siegar
 *
 */
public interface WorkerStatusDAO extends BaseStringIdDAO<WorkerStatus> {

	String getWorkers();
	
}
