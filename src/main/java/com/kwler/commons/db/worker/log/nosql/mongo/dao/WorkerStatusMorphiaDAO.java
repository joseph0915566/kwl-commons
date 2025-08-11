package com.kwler.commons.db.worker.log.nosql.mongo.dao;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.inject.Inject;

import com.kwler.commons.db.base.nosql.mongo.dao.BaseStringIdMorphiaDAO;
import com.kwler.commons.db.base.nosql.mongo.service.MorphiaService;
import com.kwler.commons.db.worker.log.nosql.mongo.model.WorkerStatus;
import com.kwler.commons.json.JsonService;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class WorkerStatusMorphiaDAO extends BaseStringIdMorphiaDAO<WorkerStatus> implements WorkerStatusDAO {
	
	private final ZoneId sg = ZoneId.of("Asia/Singapore");
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	@Inject
	public WorkerStatusMorphiaDAO(MorphiaService morphiaService, JsonService jsonService) {
		super(morphiaService, jsonService);
	}

	@Override
	public String getWorkers() {
		
		return jsonService.toJson(
									morphiaService.getDatastore().createQuery(WorkerStatus.class)
												.field("date").equal(LocalDate.now(sg).format(formatter))
												.asList()
								);
		
	}	

}
