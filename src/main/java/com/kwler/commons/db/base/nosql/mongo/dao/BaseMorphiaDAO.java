package com.kwler.commons.db.base.nosql.mongo.dao;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.kwler.commons.db.base.nosql.mongo.model.BaseMongoObject;
import com.kwler.commons.db.base.nosql.mongo.service.MorphiaService;
import com.kwler.commons.json.JsonService;

/**
 * 
 * @author Joseph Siegar
 *
 * @param <T>
 */
public abstract class BaseMorphiaDAO<T extends BaseMongoObject> implements BaseDAO<T> {
	
	protected final MorphiaService morphiaService;
	protected final JsonService jsonService;
	protected final Class<T> thisClazz;
	
	@SuppressWarnings("unchecked")
	public BaseMorphiaDAO(MorphiaService morphiaService, JsonService jsonService) {
		this.morphiaService = morphiaService;
		this.jsonService = jsonService;
		this.thisClazz = ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
	}
	
	@Override
	public void save(T t){
		if(t != null) morphiaService.save(t);
	}
	
	@Override
	public void save(List<T> t){
		if(t != null && !t.isEmpty()) morphiaService.save(t);
	}
	
	@Override
	public List<T> getAll(){
		return morphiaService.getDatastore().find(thisClazz).asList();
	}

	@Override
	public List<T> find(String criteriaJson){
		if(criteriaJson == null) return new ArrayList<>();
		return morphiaService.find(jsonService.toPojo(criteriaJson, thisClazz));
	}
	
	@Override
	public String generateId(){
		return new ObjectId().toString();
	}

}
