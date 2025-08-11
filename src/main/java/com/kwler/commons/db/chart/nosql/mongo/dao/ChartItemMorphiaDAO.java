package com.kwler.commons.db.chart.nosql.mongo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.mongodb.morphia.Datastore;

import com.kwler.commons.db.base.nosql.mongo.service.MorphiaService;
import com.kwler.commons.db.chart.nosql.mongo.model.ChartItem;
import com.kwler.commons.db.chart.nosql.mongo.model.SongIdChartItem;
import com.kwler.commons.db.chart.nosql.mongo.model.SongTitleChartItem;
import com.kwler.commons.db.scheduler.job.nosql.mongo.dao.HarvestingResultMorphiaDAO;
import com.kwler.commons.json.JsonService;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class ChartItemMorphiaDAO extends HarvestingResultMorphiaDAO<ChartItem> implements ChartItemDAO {

	@Inject
	public ChartItemMorphiaDAO(MorphiaService morphiaService, JsonService jsonService) {
		super(morphiaService, jsonService);
	}
	
	@Override
	public ChartItem get(String id){
		
		Datastore datastore = morphiaService.getDatastore();
		
		DBObject dbo = datastore
								.getDB()
								.getCollection("chartItem")
								.find(
										datastore.createQuery(ChartItem.class)
												.field("_id").equal(id)
												.getQueryObject()										
									)
								.one();
		dbo.put("id", dbo.removeField("_id").toString());
		
		String json = jsonService.toJson(dbo);
		MockChartItem mock = jsonService.toPojo(json, MockChartItem.class);
		
		ChartItem result = null;
		switch (mock.getChartItemClass()) {
			case SONGID:
				result = jsonService.toPojo(json, SongIdChartItem.class);
				break;
			default:
				result = jsonService.toPojo(json, SongTitleChartItem.class);
				break;
		}
		
		return result;
		
	}

	@Override
	public List<ChartItem> getByJobId(String jobId){
		
		Datastore datastore = morphiaService.getDatastore();
		
		DBCursor cursor = datastore
								.getDB()
								.getCollection("chartItem")
								.find(
										datastore.createQuery(ChartItem.class)
												.field("jobId").equal(jobId)
												.getQueryObject()										
									);
		
		List<ChartItem> chartItems = new ArrayList<>();
		while(cursor.hasNext()){
			
			DBObject dbo = cursor.next();
			dbo.put("id", dbo.removeField("_id").toString());
			
			String json = jsonService.toJson(dbo);
			MockChartItem mock = jsonService.toPojo(json, MockChartItem.class);			
			switch (mock.getChartItemClass()) {
				case SONGID:
					chartItems.add(jsonService.toPojo(json, SongIdChartItem.class));
					break;
				default:
					chartItems.add(jsonService.toPojo(json, SongTitleChartItem.class));
					break;
			}
			
		}

		return chartItems;
	}
	
	private static class MockChartItem extends ChartItem{}

	@Override
	public void savePartial(ChartItem t) {}

}
