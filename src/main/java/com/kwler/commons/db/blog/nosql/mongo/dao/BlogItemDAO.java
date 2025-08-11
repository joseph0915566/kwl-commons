package com.kwler.commons.db.blog.nosql.mongo.dao;

import java.util.List;

import com.kwler.commons.db.blog.nosql.mongo.model.BlogItem;
import com.kwler.commons.db.scheduler.job.nosql.mongo.dao.HarvestingResultDAO;

/**
 * 
 * @author Joseph Siegar
 *
 */
public interface BlogItemDAO extends HarvestingResultDAO<BlogItem> {

	List<BlogItem> searchByDate(String date);
	List<BlogItem> searchByUrl(String url);
	
}
