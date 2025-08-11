package com.kwler.commons.db.bandsintown.nosql.mongo.dao;

import java.util.List;

import com.kwler.commons.db.bandsintown.nosql.mongo.model.BandsInTownEvent;
import com.kwler.commons.db.scheduler.job.nosql.mongo.dao.HarvestingResultDAO;

public interface BandsInTownDAO extends HarvestingResultDAO<BandsInTownEvent> {

	/**
	 * finds all BandsInTownEvent
	 * 
	 * @param artistId the mongo id of the artist owning the events
	 * @param start 2012-08-15T18:00:00
	 * @param end 2012-08-15T18:00:00
	 * @return List of BandsInTownEvent matching the criterias
	 */
	List<BandsInTownEvent> findByArtistAndEventDateTimeGreaterThanEqualAndLessThanEqual(String artistId, String start, String end);
}
