package com.kwler.commons.db.base.nosql.mongo.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;

/**
 * 
 * @author Joseph Siegar
 *
 */
public abstract class BaseObjectIdObject extends BaseMongoObject {

	@Id protected ObjectId id;

	public String getId() {
		if(id == null) return null;
		return id.toString();
	}

	public void setId(String id) {
		if (id == null) {
			this.id = null;
		} else {
			this.id = new ObjectId(id);
		}
	}
	
}
