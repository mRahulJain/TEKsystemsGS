package com.webapp.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int id;
	
	@Column(name = "USER_NAME")
	private String username;
	
	@Column(name = "USER_EMAIL")
	private String email;
	
	@Column(name = "USER_PASSWORD")
	private String password;
	
	@Column(name = "USER_AGE")
	private int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public Person(String username, String email, String password, int age) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", age="
				+ age + "]";
	}

	public Person() {
		super();
	}
	
}
