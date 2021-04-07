package com.springboot.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private int id;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "product_price")
	private double productPrice;
	
	@Column(name = "product_image")
	private String productImage;
	
	@Column(name = "product_company")
	private String productCompany;
	
	@Column(name = "product_available_for_sale")
	private int productAvailableForSale;
	
	@Column(name = "product_category")
	private String category;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductCompany() {
		return productCompany;
	}

	public void setProductCompany(String productCompany) {
		this.productCompany = productCompany;
	}

	public int getProductAvailableForSale() {
		return productAvailableForSale;
	}

	public void setProductAvailableForSale(int productAvailableForSale) {
		this.productAvailableForSale = productAvailableForSale;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Product(String productName, double productPrice, String productImage, String productCompany,
			int productAvailableForSale, String category) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productImage = productImage;
		this.productCompany = productCompany;
		this.productAvailableForSale = productAvailableForSale;
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productImage=" + productImage + ", productCompany=" + productCompany + ", productAvailableForSale="
				+ productAvailableForSale + ", category=" + category + "]";
	}
	
	public Product() {
		super();
	}
	
}
