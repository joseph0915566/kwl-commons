package com.kwler.commons.db.bandsintown.nosql.mongo.model;

import java.util.LinkedList;
import java.util.List;

import org.mongodb.morphia.annotations.Entity;

import com.kwler.commons.db.scheduler.job.nosql.mongo.model.EventResult;
import com.kwler.commons.db.scheduler.job.nosql.mongo.model.HarvestingResult;

/**
 * 
 * @author Joseph Siegar
 *
 */
@Entity(value = "bandsintownEvent", noClassnameStored = true)
public class BandsInTownEvent extends HarvestingResult {

	private String artistId;
	private List<EventResult> events;
	//manual field in DAO
	
	public String getArtistId() {
		return artistId;
	}
	
	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}

	public List<EventResult> getEvents() {
		if (events == null) events = new LinkedList<>();
		return events;
	}

	public void setEvents(List<EventResult> events) {
		this.events = events;
	}
	
}
