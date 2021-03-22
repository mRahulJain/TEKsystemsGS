package com.webapp.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.sun.istack.NotNull;

@Entity
@Table
public class Place {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PLACE_ID")
	private int id;
	
	@Column(name = "PLACE_NAME", nullable = false, unique = true)
	private String place;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Place() {
		super();
	}
	
	public Place(String place) {
		super();
		this.place = place;
	}

	@Override
	public String toString() {
		return "Place [id=" + id + ", place=" + place + "]";
	}
	
}
