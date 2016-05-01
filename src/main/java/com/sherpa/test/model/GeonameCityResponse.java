package com.sherpa.test.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeonameCityResponse {
		
	@JsonProperty("postalCodes")
	private List<GeonameCity> cities;

	public List<GeonameCity> getCities() {
		return cities;
	}

	public void setCities(List<GeonameCity> cities) {
		this.cities = cities;
	}
	
	
		
}
