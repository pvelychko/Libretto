package com.pvelychko.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Superclass for model classes
 * @author pvelychko
 *
 */
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
	/**
	 * Get id
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * Set id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	// Name
	/**
	 * Get name
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * Set name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
