package com.webapp.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "productId")
	private int id;
	
	@Column(name = "productName")
	private String name;
	
	@Column(name = "productPrice")
	private int price;
	
	@Column(name = "productManufacturingCompany")
	private String company;
	
	@Column(name = "productManufacturingCountry")
	private String country;
	
	@Column(name = "productAvailableForSale")
	private int isAvailable;

	public Product() {
		//default constructor
	}
	
	public Product(String name, int price, String company, String country, int isAvailable) {
		super();
		this.name = name;
		this.price = price;
		this.company = company;
		this.country = country;
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", company=" + company + ", country="
				+ country + ", sale=" + isAvailable + "]";
	}

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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(int isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	
	
	
	

}
