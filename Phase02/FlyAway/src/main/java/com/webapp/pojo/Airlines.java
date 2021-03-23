package com.webapp.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Airlines {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AIRLINE_ID")
	private int id;
	
	@Column(name = "AIRLINE_NAME", nullable = false, unique = true)
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Airlines() {
		super();
	}
	
	public Airlines(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Airlines [id=" + id + ", name=" + name + "]";
	}
}
