package com.webapp.java;

public class Product {
	private String productName;
	private int productPrice;
	private String productCompany;
	private String productCountry;
	private boolean productAvailable;

	

	public Product() {
	
	}
	
	

	public Product(String productName, int productPrice, String productCompany, String productCountry,
			boolean productAvailable) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCompany = productCompany;
		this.productCountry = productCountry;
		this.productAvailable = productAvailable;
	}



	@Override
	public String toString() {
		return "Product [productName=" + productName + ", productPrice=" + productPrice + ", productCompany="
				+ productCompany + ", productCountry=" + productCountry + ", productAvailable=" + productAvailable
				+ "]";
	}



	public boolean isProductAvailable() {
		return productAvailable;
	}

	public void setProductAvailable(boolean productAvailable) {
		this.productAvailable = productAvailable;
	}
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductCompany() {
		return productCompany;
	}

	public void setProductCompany(String productCompany) {
		this.productCompany = productCompany;
	}

	public String getProductCountry() {
		return productCountry;
	}

	public void setProductCountry(String productCountry) {
		this.productCountry = productCountry;
	}

}
