package com.sherpa.test.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "master")
public class Master {
	
	public Master() { 
	} 
	
	public Master(long id, String username) {
        this.id = id; 
        this.username = username; 
    }
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)    
	private Long id;
	
	@Column(name="username")
	private String username;
	
	@OneToOne
	@JoinColumn(name="id_detail")
	private Detail detail;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}	

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }
}
