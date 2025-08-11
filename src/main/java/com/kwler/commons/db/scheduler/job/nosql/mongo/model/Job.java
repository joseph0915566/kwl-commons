package com.kwler.commons.db.scheduler.job.nosql.mongo.model;

import java.util.List;
import java.util.Map;

import org.mongodb.morphia.annotations.Entity;

import com.kwler.commons.db.base.nosql.mongo.model.BaseObjectIdObject;

/**
 * 
 * @author Joseph Siegar
 *
 */
@Entity(value = "job", noClassnameStored = true)
public class Job extends BaseObjectIdObject {

	private String name;
	private String jobType;
	private List<Cron> cronList;
	private Map<String, String> jobParams;
	private String lastRunTimestamp;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Cron> getCronList() {
		return cronList;
	}

	public void setCronList(List<Cron> cronList) {
		this.cronList = cronList;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public Map<String, String> getJobParams() {
		return jobParams;
	}

	public void setJobParams(Map<String, String> jobParams) {
		this.jobParams = jobParams;
	}

	public String getLastRunTimestamp() {
		return lastRunTimestamp;
	}

	public void setLastRunTimestamp(String lastRunTimestamp) {
		this.lastRunTimestamp = lastRunTimestamp;
	}
	
}
