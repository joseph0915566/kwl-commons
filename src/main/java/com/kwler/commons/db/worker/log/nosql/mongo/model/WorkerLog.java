package com.kwler.commons.db.worker.log.nosql.mongo.model;

import org.mongodb.morphia.annotations.Entity;

import com.kwler.commons.db.base.nosql.mongo.model.BaseObjectIdObject;

/**
 * 
 * @author Joseph Siegar
 *
 */
@Entity(value = "workerLog", noClassnameStored = true)
public class WorkerLog extends BaseObjectIdObject {

	private String jobId;
	private String machineId;
	private String resourceType;
	private String resourcePath;
	private String resourceId;
	private Long startTime;
	private Long completeTime;
	private String source;
	private JobStatus status;
	private String description;
	private Boolean deletedReferenceEntry;
	
	public String getJobId() {
		return jobId;
	}
	
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getMachineId() {
		return machineId;
	}

	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getResourcePath() {
		return resourcePath;
	}

	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	public Long getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(Long completeTime) {
		this.completeTime = completeTime;
	}

	public String getSource() {
		return source;
	}
	
	public void setSource(String source) {
		this.source = source;
	}

	public JobStatus getStatus() {
		return status;
	}

	public void setStatus(JobStatus status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getDeletedReferenceEntry() {
		return deletedReferenceEntry;
	}

	public void setDeletedReferenceEntry(Boolean deletedReferenceEntry) {
		this.deletedReferenceEntry = deletedReferenceEntry;
	}
	
}
