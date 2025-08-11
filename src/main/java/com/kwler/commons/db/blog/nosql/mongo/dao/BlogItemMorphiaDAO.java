package com.kwler.commons.db.blog.nosql.mongo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import com.kwler.commons.db.base.nosql.mongo.service.MorphiaService;
import com.kwler.commons.db.blog.nosql.mongo.model.BlogItem;
import com.kwler.commons.db.scheduler.job.nosql.mongo.dao.HarvestingResultMorphiaDAO;
import com.kwler.commons.json.JsonService;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class BlogItemMorphiaDAO extends HarvestingResultMorphiaDAO<BlogItem> implements BlogItemDAO {

	@Inject
	public BlogItemMorphiaDAO(MorphiaService morphiaService, JsonService jsonService) {
		super(morphiaService, jsonService);
	}

	@Override
	public void savePartial(BlogItem blogItem) {
		
		Datastore datastore = morphiaService.getDatastore();
		Query<BlogItem> query = datastore.createQuery(BlogItem.class)
										.field("_id").equal(blogItem.getId());
		
		UpdateOperations<BlogItem> op = datastore.createUpdateOperations(BlogItem.class)
										.set("blogId", blogItem.getBlogId())
										.set("jobId", blogItem.getJobId())
										.set("date", blogItem.getDate())
										.set("name", blogItem.getName())
										.addAll("items", blogItem.getItems(), true);
		
		datastore.update(query, op, true);

	}

	@Override
	public List<BlogItem> searchByDate(String date) {
		
		Datastore datastore = morphiaService.getDatastore();
		Query<BlogItem> query = datastore.createQuery(BlogItem.class)
										.field("date").equal(date);
		
		return query.asList();
		
	}

	@Override
	public List<BlogItem> searchByUrl(String url) {
		
		List<BlogItem> result = new ArrayList<>();
		
		Datastore datastore = morphiaService.getDatastore();
		Query<BlogItem> query = datastore.createQuery(BlogItem.class)
										.field("items.url").equal(url);		
		result.addAll(query.asList());

		Query<BlogItem> secondQuery = datastore.createQuery(BlogItem.class)
										.field("items.url").equal(StringUtils.stripEnd(url, "/"));		
		result.addAll(secondQuery.asList());
		
		return result;
		
	}

}
