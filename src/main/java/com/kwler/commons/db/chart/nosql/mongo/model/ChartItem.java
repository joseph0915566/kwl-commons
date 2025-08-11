package com.kwler.commons.db.chart.nosql.mongo.model;

import org.mongodb.morphia.annotations.Entity;

import com.kwler.commons.db.scheduler.job.nosql.mongo.model.HarvestingResult;

/**
 * 
 * @author Joseph Siegar
 *
 */
@Entity(value = "chartItem", noClassnameStored = true)
public abstract class ChartItem extends HarvestingResult {

	protected String chartId;
	protected ChartItemClass chartItemClass;
	
	public String getChartId() {
		return chartId;
	}
	
	public void setChartId(String chartId) {
		this.chartId = chartId;
	}
	
	public ChartItemClass getChartItemClass() {
		return chartItemClass;
	}

}
