package com.springboot.pojo;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Admin(String password) {
		super();
		this.password = password;
	}
	
	public Admin() {
		super();
	}

	@Override
	public String toString() {
		return "Admin [password=" + password + "]";
	}
	
}
