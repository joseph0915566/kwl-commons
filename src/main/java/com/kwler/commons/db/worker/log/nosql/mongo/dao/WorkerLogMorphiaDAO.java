package com.kwler.commons.db.worker.log.nosql.mongo.dao;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kwler.commons.db.base.nosql.mongo.dao.BaseObjectIdMorphiaDAO;
import com.kwler.commons.db.base.nosql.mongo.model.MongoPagedResults;
import com.kwler.commons.db.base.nosql.mongo.service.MorphiaService;
import com.kwler.commons.db.worker.log.nosql.mongo.model.JobStatus;
import com.kwler.commons.db.worker.log.nosql.mongo.model.WorkerLog;
import com.kwler.commons.db.worker.log.nosql.mongo.model.WorkerLogCriteria;
import com.kwler.commons.db.worker.log.nosql.mongo.model.WorkerStatus;
import com.kwler.commons.json.JsonService;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class WorkerLogMorphiaDAO extends BaseObjectIdMorphiaDAO<WorkerLog> implements WorkerLogDAO {

	private final ZoneId sg = ZoneId.of("Asia/Singapore");
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	@Inject
	public WorkerLogMorphiaDAO(MorphiaService morphiaService, JsonService jsonService) {
		super(morphiaService, jsonService);
	}

	@Override
	public List<WorkerLog> getEntriesBefore(long timestamp, int skip, int limit) {
		return morphiaService
							.getDatastore()
							.createQuery(WorkerLog.class)
							.field("startTime").lessThanOrEq(timestamp)
							.offset(skip)
							.order("-startTime")
							.limit(limit)
							.asList();
	}
	
	@Override
	public MongoPagedResults<WorkerLog> findByCriteria(WorkerLogCriteria criteria, Long dateStart, Long dateEnd, Integer offset, Integer limit) {
		if (criteria == null) return MongoPagedResults.empty();
		
		Query<WorkerLog> query = morphiaService
				.getDatastore()
				.createQuery(WorkerLog.class);
		
		String jobId = criteria.getJobId();
		if (jobId != null && !jobId.isEmpty()) query = query
				.field("jobId").equal(jobId);
		
		String resourcePath = criteria.getResourcePath();
		if (StringUtils.isNotEmpty(resourcePath)) query = query.field("resourcePath").equal(resourcePath);
		
		String resourceType = criteria.getResourceType();
		if (resourceType != null && !resourceType.isEmpty()) query = query
				.field("resourceType").equal(resourceType);
		
		String resourceId = criteria.getResourceId();
		if (StringUtils.isNotEmpty(resourceId)) query = query.field("resourceId").equal(resourceId);
		
		String source = criteria.getSource();
		if (source != null && !source.isEmpty()) query = query
				.field("source").equal(source);
		
		String status = criteria.getStatus();
		if (status != null && !status.isEmpty()) query = query
				.field("status").equal(status);
		
		String machineId = criteria.getMachineId();
		if (machineId != null && !machineId.isEmpty()) query = query
				.field("machineId").equal(machineId);
		
		if (dateStart!=null && dateEnd!=null) {
			query = query
					.field("startTime").greaterThanOrEq(dateStart)
					.field("completeTime").greaterThanOrEq(dateStart)
					.field("startTime").lessThanOrEq(dateEnd)
					.field("completeTime").lessThanOrEq(dateEnd);
		}
		
		query = query
				.offset(offset)
				.limit(limit)
				.order("-completeTime");
		
		return MongoPagedResults.from(query.asList(), query.countAll());
	}

	@Deprecated
	@Override
	public List<WorkerLog> findByCriteria(WorkerLogCriteria criteria, Long dateStart, Long dateEnd, Integer limit) {
		if (criteria == null) return Collections.emptyList();
		
		Query<WorkerLog> query = morphiaService
				.getDatastore()
				.createQuery(WorkerLog.class);
		
		String jobId = criteria.getJobId();
		if (jobId != null && !jobId.isEmpty()) query = query
				.field("jobId").equal(jobId);
		
		String resourceType = criteria.getResourceType();
		if (resourceType != null && !resourceType.isEmpty()) query = query
				.field("resourceType").equal(resourceType);
		
		String resourceId = criteria.getResourceId();
		if (StringUtils.isNotEmpty(resourceId)) query = query.field("resourceId").equal(resourceId);
		
		String source = criteria.getSource();
		if (source != null && !source.isEmpty()) query = query
				.field("source").equal(source);
		
		String status = criteria.getStatus();
		if (status != null && !status.isEmpty()) query = query
				.field("status").equal(status);
		
		String machineId = criteria.getMachineId();
		if (machineId != null && !machineId.isEmpty()) query = query
				.field("machineId").equal(machineId);
		
		if (dateStart!=null && dateEnd!=null) {
			query = query
					.field("startTime").greaterThanOrEq(dateStart)
					.field("completeTime").greaterThanOrEq(dateStart)
					.field("startTime").lessThanOrEq(dateEnd)
					.field("completeTime").lessThanOrEq(dateEnd);
		}
		
		query = query
				.limit(limit)
				.order("-completeTime");
		
		return query.asList();
	}

	@Override
	public Long countByCompleteTime(Long dateStart, Long dateEnd) {
		Long count = morphiaService
				.getDatastore()
				.createQuery(WorkerLog.class)
				.field("startTime").greaterThanOrEq(dateStart)
				.field("startTime").lessThanOrEq(dateEnd)
				.field("completeTime").greaterThanOrEq(dateStart)
				.field("completeTime").lessThanOrEq(dateEnd)
				.countAll();

		return count;
	}

	@Override
	public String getWorkers() {

		/*
		MongoCollection<Document> coll = morphiaService.getMongoClient().getDatabase(dbName).getCollection("workerLog");
		AggregateIterable<Document> output = coll.aggregate
															(
																	Arrays.asList(
																					new Document("$match", new Document("machineId", new Document("$exists", true)))
																					, new Document(
																								"$group"
																								, new Document(
																												"_id"
																												, "$machineId"
																												)
																								.append(
																										"lastJob"
																										, new Document("$max", "$completeTime")
																										)
																								)
																					)
															);

		return jsonService.toJson(output);
		*/
		
		List<WorkerStatus> statuses = morphiaService.getDatastore().createQuery(WorkerStatus.class)
												.field("date").equal(LocalDate.now(sg).format(formatter))
												.asList();
		List<WorkerStatusResponse> response = new ArrayList<>();
		for(WorkerStatus status : statuses) {
			WorkerStatusResponse statusResponse = new WorkerStatusResponse();
			statusResponse._id = status.getMachineId();
			statusResponse.lastJob = status.getLastJob();
			response.add(statusResponse);
		}
		
		return jsonService.toJson(response);
		
	}

	@Override
	public void changeStatus(String jobId, JobStatus jobStatus, String errorMessage) {
		
		Datastore datastore = morphiaService.getDatastore();
		
		Query<WorkerLog> query = 	datastore
									.createQuery(WorkerLog.class)
									.field("jobId").equal(jobId);
		
		UpdateOperations<WorkerLog> operation = 	datastore.createUpdateOperations(WorkerLog.class)
													.set("status", jobStatus)
													.set("description", errorMessage);
		
		datastore.update(query, operation);
		
	}
	
	private static class WorkerStatusResponse{
		@JsonProperty("_id") private String _id;
		@JsonProperty("lastJob") private long lastJob;
	}

}
