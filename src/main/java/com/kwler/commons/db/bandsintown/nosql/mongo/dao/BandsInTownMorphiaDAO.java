package com.kwler.commons.db.bandsintown.nosql.mongo.dao;

import java.util.List;

import javax.inject.Inject;

import com.kwler.commons.db.bandsintown.nosql.mongo.model.BandsInTownEvent;
import com.kwler.commons.db.base.nosql.mongo.service.MorphiaService;
import com.kwler.commons.db.scheduler.job.nosql.mongo.dao.HarvestingResultMorphiaDAO;
import com.kwler.commons.json.JsonService;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class BandsInTownMorphiaDAO extends HarvestingResultMorphiaDAO<BandsInTownEvent> implements BandsInTownDAO {

	@Inject
	public BandsInTownMorphiaDAO(MorphiaService morphiaService, JsonService jsonService) {
		super(morphiaService, jsonService);
	}

	@Override
	public List<BandsInTownEvent> findByArtistAndEventDateTimeGreaterThanEqualAndLessThanEqual(String artistId, String start, String end) {
		return morphiaService.
				getDatastore().
				createQuery(thisClazz).
				field("artistId").equal(artistId).
				field("events.datetime").greaterThanOrEq(start).
				field("events.datetime").lessThanOrEq(end).
				asList();
	}

	@Override
	public void savePartial(BandsInTownEvent event) {}

}
