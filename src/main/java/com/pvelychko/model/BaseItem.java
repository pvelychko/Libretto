package com.pvelychko.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class BaseItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="since", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date since;
	
	protected BaseItem() {
		since = new Date();
	}

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
	
	// Since
	public Date getSince() {
		return since;
	}
	public void setSince(Date since) {
		throw new IllegalAccessError();
	}
	
}
