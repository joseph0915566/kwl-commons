package com.kwler.commons.db.facebook.nosql.mongo.model;

import com.kwler.commons.i18n.Country;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class CountryStat {

	private Country country;
	private long count;
	
	public CountryStat() {}
	
	public CountryStat(Country country, long count){
		this.country = country;
		this.count = count;
	}
	
	public Country getCountry() {
		return country;
	}
	
	public void setCountry(Country country) {
		this.country = country;
	}
	
	public long getCount() {
		return count;
	}
	
	public void setCount(long count) {
		this.count = count;
	}
	
}
