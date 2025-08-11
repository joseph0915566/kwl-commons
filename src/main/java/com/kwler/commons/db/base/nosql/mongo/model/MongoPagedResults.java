package com.kwler.commons.db.base.nosql.mongo.model;

import java.util.Collections;
import java.util.List;

public class MongoPagedResults<T> {

	private List<T> results;
	private Long size;
	
	public static <T> MongoPagedResults<T> empty() {
		List<T> empty = Collections.emptyList();
		return new MongoPagedResults<T>(empty, 0L);
	}
	
	public static <T> MongoPagedResults<T> from(List<T> results, Long totalSize) {
		return new MongoPagedResults<>(results, totalSize);
	}

	public MongoPagedResults() {
		super();
	}

	public MongoPagedResults(List<T> results, Long size) {
		super();
		this.results = results;
		this.size = size;
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

}
