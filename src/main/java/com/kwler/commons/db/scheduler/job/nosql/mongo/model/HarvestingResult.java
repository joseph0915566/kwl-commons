package com.kwler.commons.db.scheduler.job.nosql.mongo.model;

import com.kwler.commons.db.base.nosql.mongo.model.BaseStringIdObject;

/**
 * 
 * @author Joseph Siegar
 *
 */
public abstract class HarvestingResult extends BaseStringIdObject {

	protected String jobId;
	protected String date;
	
	public String getJobId() {
		return jobId;
	}
	
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
}
