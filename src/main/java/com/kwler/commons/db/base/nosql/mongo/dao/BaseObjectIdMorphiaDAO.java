package com.kwler.commons.db.base.nosql.mongo.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kwler.commons.db.base.nosql.mongo.exception.InvalidIdException;
import com.kwler.commons.db.base.nosql.mongo.model.BaseObjectIdObject;
import com.kwler.commons.db.base.nosql.mongo.service.MorphiaService;
import com.kwler.commons.json.JsonService;

/**
 * 
 * @author Joseph Siegar
 *
 */
public abstract class BaseObjectIdMorphiaDAO<T extends BaseObjectIdObject> extends BaseMorphiaDAO<T> implements BaseObjectIdDAO<T> {

	private static final Logger LOGGER = LoggerFactory.getLogger(BaseObjectIdMorphiaDAO.class);

	public BaseObjectIdMorphiaDAO(MorphiaService morphiaService, JsonService jsonService) {
		super(morphiaService, jsonService);
	}
	
	public List<ObjectId> toObjectIds(List<String> StringIds){

		List<ObjectId> objectIds = new ArrayList<>();
		for(String id : StringIds){
			try {
				objectIds.add(new ObjectId(id));
			} catch (Exception e) {
				LOGGER.error(id + " is empty or malformed");
			}			
		}
		
		return objectIds;
		
	}
	
	@Override
	public void delete(String id){

		ObjectId _id = null;
		try {
			_id = new ObjectId(id);
		} catch (Exception e) {
			throw new InvalidIdException(id + " is empty or malformed");
		}			
		
	    morphiaService.getDatastore().delete(thisClazz, _id);
	    
	}
	
	@Override
	public T get(String id){

		ObjectId _id = null;
		try {
			_id = new ObjectId(id);
			return morphiaService.getDatastore().get(thisClazz, _id);
		} catch (Exception e) {
			LOGGER.error(id + " is empty or malformed");
		}			
		
		return null;
		
	}

}
