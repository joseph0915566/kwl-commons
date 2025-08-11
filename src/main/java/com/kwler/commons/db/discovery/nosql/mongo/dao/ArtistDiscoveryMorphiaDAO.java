package com.kwler.commons.db.discovery.nosql.mongo.dao;

import java.util.List;

import javax.inject.Inject;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import com.kwler.commons.db.base.nosql.mongo.service.MorphiaService;
import com.kwler.commons.db.discovery.nosql.mongo.model.ArtistDiscovery;
import com.kwler.commons.db.scheduler.job.nosql.mongo.dao.HarvestingResultMorphiaDAO;
import com.kwler.commons.json.JsonService;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class ArtistDiscoveryMorphiaDAO extends HarvestingResultMorphiaDAO<ArtistDiscovery> implements ArtistDiscoveryDAO {

	@Inject
	public ArtistDiscoveryMorphiaDAO(MorphiaService morphiaService, JsonService jsonService) {
		super(morphiaService, jsonService);
	}

	@Override
	public void savePartial(ArtistDiscovery t) {}

	@Override
	public void updateRecord(ArtistDiscovery artistDiscovery) {
		
		Datastore datastore = morphiaService.getDatastore();
		Query<ArtistDiscovery> query = datastore.createQuery(ArtistDiscovery.class)
										.field("_id").equal(artistDiscovery.getId());
		
		UpdateOperations<ArtistDiscovery> op = datastore.createUpdateOperations(ArtistDiscovery.class);
		op.set("jobId", artistDiscovery.getJobId());
		op.set("date", artistDiscovery.getDate());
		op.set("items", artistDiscovery.getItems());
		
		datastore.update(query, op, true);
		
	}

	@Override
	public List<ArtistDiscovery> get(String date, int limit, int offset) {
		return morphiaService
							.getDatastore()
							.createQuery(ArtistDiscovery.class)
							.field("date").equal(date)
							.offset(offset)
							.limit(limit)
							.asList();
	}

}
