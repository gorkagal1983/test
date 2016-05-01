package com.sherpa.test.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "address")
public class Address {
	
	public Address() { 
	} 
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)    
	private Long id;
	
	@Column(name="cp")
	@NotNull
	@Size(max=5)
	private String cp;
	
	@Column(name="city")
	@NotNull
	@Size(max=100)
	private String city;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}	
	
}

