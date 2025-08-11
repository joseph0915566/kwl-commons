package com.kwler.commons.db.worker.log.nosql.mongo.dao;

import java.util.List;

import com.kwler.commons.db.base.nosql.mongo.dao.BaseObjectIdDAO;
import com.kwler.commons.db.base.nosql.mongo.model.MongoPagedResults;
import com.kwler.commons.db.worker.log.nosql.mongo.model.JobStatus;
import com.kwler.commons.db.worker.log.nosql.mongo.model.WorkerLog;
import com.kwler.commons.db.worker.log.nosql.mongo.model.WorkerLogCriteria;

/**
 * 
 * @author Joseph Siegar
 *
 */
public interface WorkerLogDAO extends BaseObjectIdDAO<WorkerLog> {

	List<WorkerLog> getEntriesBefore(long timestamp, int skip, int limit);
	
	/**
	 * 
	 * @param criteria
	 * @param dateStart required timestamp. only include logs >= this
	 * @param dateEnd required timestamp. only include logs <= this
	 * @param offset
	 * @param limit
	 * @return
	 */
	MongoPagedResults<WorkerLog> findByCriteria(WorkerLogCriteria criteria, Long dateStart, Long dateEnd, Integer offset, Integer limit);
	
	@Deprecated
	List<WorkerLog> findByCriteria(WorkerLogCriteria criteria, Long dateStart, Long dateEnd, Integer limit);
	String getWorkers();

	/**
	 *
	 * @param dateStart
	 * @param dateEnd
	 * @return the number of completed worker logs within the given time frame
	 */
	Long countByCompleteTime(Long dateStart, Long dateEnd);
	void changeStatus(String jobId, JobStatus jobStatus, String errorMessage);
}
