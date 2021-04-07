package com.springboot.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "purchase_id")
	private int id;
	
	@Column(name = "shopper_id")
	private int purchaseshopperId;
	
	@Column(name = "product_id ")
	private int purchaseproductId;
	
	@Column(name = "purchase_category")
	private String category;
	
	@Column(name = "purchase_date ")
	private Date purchaseDate;
	
	@Column(name = "purchase_quantity ")
	private int purchaseQuantity;
	
	@Column(name = "purchase_price ")
	private double purchaseAmount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPurchaseshopperId() {
		return purchaseshopperId;
	}

	public void setPurchaseshopperId(int purchaseshopperId) {
		this.purchaseshopperId = purchaseshopperId;
	}

	public int getPurchaseproductId() {
		return purchaseproductId;
	}

	public void setPurchaseproductId(int purchaseproductId) {
		this.purchaseproductId = purchaseproductId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public int getPurchaseQuantity() {
		return purchaseQuantity;
	}

	public void setPurchaseQuantity(int purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}

	public double getPurchaseAmount() {
		return purchaseAmount;
	}

	public void setPurchaseAmount(double purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}
	
	@Override
	public String toString() {
		return "Purchase [id=" + id + ", purchaseshopperId=" + purchaseshopperId + ", purchaseproductId="
				+ purchaseproductId + ", category=" + category + ", purchaseDate=" + purchaseDate
				+ ", purchaseQuantity=" + purchaseQuantity + ", purchaseAmount=" + purchaseAmount + "]";
	}

	public Purchase(int purchaseshopperId, int purchaseproductId, String category, Date purchaseDate,
			int purchaseQuantity, double purchaseAmount) {
		super();
		this.purchaseshopperId = purchaseshopperId;
		this.purchaseproductId = purchaseproductId;
		this.category = category;
		this.purchaseDate = purchaseDate;
		this.purchaseQuantity = purchaseQuantity;
		this.purchaseAmount = purchaseAmount;
	}

	public Purchase() {
		super();
	}
	
	
}
