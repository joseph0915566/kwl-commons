package com.kwler.commons.db.chart.nosql.mongo.dao;

import javax.inject.Inject;

import com.kwler.commons.db.base.nosql.mongo.service.MorphiaService;
import com.kwler.commons.db.chart.nosql.mongo.model.ArtistSummary;
import com.kwler.commons.db.scheduler.job.nosql.mongo.dao.HarvestingResultMorphiaDAO;
import com.kwler.commons.json.JsonService;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class ArtistSummaryMorphiaDAO extends HarvestingResultMorphiaDAO<ArtistSummary> implements ArtistSummaryDAO {

	@Inject
	public ArtistSummaryMorphiaDAO(MorphiaService morphiaService, JsonService jsonService) {
		super(morphiaService, jsonService);
	}

	@Override
	public void savePartial(ArtistSummary t) {}

}
