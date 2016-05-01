package com.sherpa.test.utilities;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.sherpa.test.model.GeonameCity;
import com.sherpa.test.model.GeonameCityResponse;

public class GeonamesRestAPI {

	private static final Logger log = LoggerFactory.getLogger(GeonamesRestAPI.class);
	private static final String geonamesUrl = "http://api.geonames.org/";
	
	
	public String getCityByPostalCode(String cp){
		
		RestTemplate restTemplate = new RestTemplate();
		List<GeonameCity> geoCities = restTemplate.getForObject(geonamesUrl + "postalCodeSearchJSON?postalcode=" + cp + "&country=ES&maxRows=1&username=demo", GeonameCityResponse.class).getCities();
        
		if (geoCities == null || geoCities.isEmpty()){
			log.info("There is no city for the postal code: " + cp);
			return null;
		}
		
		return geoCities.get(0).getPlaceName();
	}
	
	
}
