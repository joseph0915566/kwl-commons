package com.kwler.commons.db.base.nosql.mongo.dao;

import java.util.List;

import com.kwler.commons.db.base.nosql.mongo.model.BaseStringIdObject;
import com.kwler.commons.db.base.nosql.mongo.service.MorphiaService;
import com.kwler.commons.json.JsonService;

/**
 * 
 * @author Joseph Siegar
 *
 */
public abstract class BaseStringIdMorphiaDAO<T extends BaseStringIdObject> extends BaseMorphiaDAO<T> implements BaseStringIdDAO<T> {
	
	public BaseStringIdMorphiaDAO(MorphiaService morphiaService, JsonService jsonService) {
		super(morphiaService, jsonService);
	}
	
	@Override
	public void delete(String id){
	    morphiaService.getDatastore().delete(thisClazz, id);
	}
	
	@Override
	public T get(String id){
		return morphiaService.getDatastore().get(thisClazz, id);		
	}
	
	@Override
	public List<T> get(List<String> idList){
		return morphiaService.getDatastore().find(thisClazz).
				field("_id").in(idList).asList();		
	}

}
