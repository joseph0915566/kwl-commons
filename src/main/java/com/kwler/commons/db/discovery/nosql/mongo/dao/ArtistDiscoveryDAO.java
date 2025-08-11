package com.kwler.commons.db.discovery.nosql.mongo.dao;

import java.util.List;

import com.kwler.commons.db.discovery.nosql.mongo.model.ArtistDiscovery;
import com.kwler.commons.db.scheduler.job.nosql.mongo.dao.HarvestingResultDAO;

/**
 * 
 * @author Joseph Siegar
 *
 */
public interface ArtistDiscoveryDAO extends HarvestingResultDAO<ArtistDiscovery> {

	void updateRecord(ArtistDiscovery artistDiscovery);
	List<ArtistDiscovery> get(String sourceDate, int limit, int offset);
	
}
