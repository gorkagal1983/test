package com.sherpa.test.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeonameCity {
		
	private String postalCode;
	private String placeName;
	private String adminName1;
	private String adminName2;
	
	
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getAdminName1() {
		return adminName1;
	}
	public void setAdminName1(String adminName1) {
		this.adminName1 = adminName1;
	}
	public String getAdminName2() {
		return adminName2;
	}
	public void setAdminName2(String adminName2) {
		this.adminName2 = adminName2;
	}
		
}
