package com.kwler.commons.db.base.nosql.mongo.dao;

import java.util.List;

import com.kwler.commons.db.base.nosql.mongo.model.BaseMongoObject;

/**
 * 
 * @author Joseph Siegar
 *
 * @param <T>
 */
public interface BaseDAO<T extends BaseMongoObject> {

	//save
	void save(T t);
	void save(List<T> list);

	//query
	List<T> getAll();
	List<T> find(String criteriaJson);
	
	//miscellaneous
	String generateId();	

}
