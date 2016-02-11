package com.pvelychko.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseItem implements Serializable {
	private static final long serialVersionUID = -1299744321169215478L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	// Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	// Name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
