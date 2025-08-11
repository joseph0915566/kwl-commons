package com.kwler.commons.db.venue.nosql.mongo.dao;

import javax.inject.Inject;

import com.kwler.commons.db.base.nosql.mongo.service.MorphiaService;
import com.kwler.commons.db.scheduler.job.nosql.mongo.dao.HarvestingResultMorphiaDAO;
import com.kwler.commons.db.venue.nosql.mongo.model.VenueItem;
import com.kwler.commons.json.JsonService;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class VenueItemMorphiaDAO extends HarvestingResultMorphiaDAO<VenueItem> implements VenueItemDAO {

	@Inject
	public VenueItemMorphiaDAO(MorphiaService morphiaService, JsonService jsonService) {
		super(morphiaService, jsonService);
	}

	@Override
	public void savePartial(VenueItem t) {}

}
