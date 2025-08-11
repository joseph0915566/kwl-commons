package com.kwler.commons.db.base.nosql.mongo.dao;

import com.kwler.commons.db.base.nosql.mongo.model.BaseObjectIdObject;

/**
 * 
 * @author Joseph Siegar
 *
 * @param <T>
 */
public interface BaseObjectIdDAO<T extends BaseObjectIdObject> extends BaseDAO<T> {

	//delete
	void delete (String id);

	//query
	T get(String id);

}
