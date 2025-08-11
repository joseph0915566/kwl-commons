package com.kwler.commons.db.base.nosql.mongo.dao;

import java.util.List;

import com.kwler.commons.db.base.nosql.mongo.model.BaseStringIdObject;

/**
 * 
 * @author Joseph Siegar
 *
 * @param <T>
 */
public interface BaseStringIdDAO<T extends BaseStringIdObject> extends BaseDAO<T> {

	//delete
	void delete (String id);

	//query
	T get(String id);

	//query multiple ids
	List<T> get(List<String> idList);
}
