package com.kwler.commons.db.base.nosql.mongo.model;

import org.mongodb.morphia.annotations.Id;

/**
 * 
 * @author Joseph Siegar
 *
 */
public abstract class BaseStringIdObject extends BaseMongoObject {

	@Id protected String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
