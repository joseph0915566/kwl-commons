package com.kwler.commons.db.worker.log.nosql.mongo.model;

import org.mongodb.morphia.annotations.Entity;

import com.kwler.commons.db.base.nosql.mongo.model.BaseStringIdObject;

/**
 * 
 * @author Joseph Siegar
 *
 */
@Entity(value = "workerStatus", noClassnameStored = true)
public class WorkerStatus extends BaseStringIdObject {

	private String machineId;
	private String date;
	private long lastJob;
	
	public String getMachineId() {
		return machineId;
	}
	
	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}

	public long getLastJob() {
		return lastJob;
	}

	public void setLastJob(long lastJob) {
		this.lastJob = lastJob;
	}
	
}
