package com.sherpa.test.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detail")
public class Detail {
	
	public Detail() { 
	} 
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)    
	private Long id;
	
	@Column(name="cp")
	private String cp;
	
	@Column(name="city")
	private String city;
	
	//private Master master;

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
	
	/*@OneToOne(mappedBy = "detail")
    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }*/
}

