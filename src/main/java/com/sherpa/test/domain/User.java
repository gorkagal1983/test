package com.sherpa.test.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
	
	public User() { 
	} 
	
	public User(long id, String username) {
        this.id = id; 
        this.username = username; 
    }
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)    
	private Long id;
	
	@Column(name="username")
	@NotNull
	@Size(max = 100)
	private String username;
	
	@OneToOne
	@JoinColumn(name="id_address")
	private Address address;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
