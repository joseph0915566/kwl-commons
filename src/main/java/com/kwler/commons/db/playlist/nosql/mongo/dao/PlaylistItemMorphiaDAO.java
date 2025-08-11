package com.kwler.commons.db.playlist.nosql.mongo.dao;

import javax.inject.Inject;

import com.kwler.commons.db.base.nosql.mongo.service.MorphiaService;
import com.kwler.commons.db.playlist.nosql.mongo.model.PlaylistItem;
import com.kwler.commons.db.scheduler.job.nosql.mongo.dao.HarvestingResultMorphiaDAO;
import com.kwler.commons.json.JsonService;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class PlaylistItemMorphiaDAO extends HarvestingResultMorphiaDAO<PlaylistItem> implements PlaylistItemDAO {

	@Inject
	public PlaylistItemMorphiaDAO(MorphiaService morphiaService, JsonService jsonService) {
		super(morphiaService, jsonService);
	}

	@Override
	public void savePartial(PlaylistItem t) {}

}
