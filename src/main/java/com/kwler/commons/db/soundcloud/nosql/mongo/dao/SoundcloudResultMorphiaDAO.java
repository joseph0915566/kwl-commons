package com.kwler.commons.db.soundcloud.nosql.mongo.dao;

import javax.inject.Inject;

import com.kwler.commons.db.base.nosql.mongo.service.MorphiaService;
import com.kwler.commons.db.scheduler.job.nosql.mongo.dao.HarvestingResultMorphiaDAO;
import com.kwler.commons.db.soundcloud.nosql.mongo.model.SoundcloudResult;
import com.kwler.commons.json.JsonService;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class SoundcloudResultMorphiaDAO extends HarvestingResultMorphiaDAO<SoundcloudResult> implements SoundcloudResultDAO {

	@Inject
	public SoundcloudResultMorphiaDAO(MorphiaService morphiaService, JsonService jsonService) {
		super(morphiaService, jsonService);
	}

	@Override
	public void savePartial(SoundcloudResult soundcloudResult) {}

}
