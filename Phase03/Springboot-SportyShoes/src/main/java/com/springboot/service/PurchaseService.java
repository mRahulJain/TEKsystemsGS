package com.springboot.service;

import java.util.Date;
import java.util.List;

import com.springboot.pojo.Purchase;

public interface PurchaseService {

	public void addPurchase(Purchase purchase);
	public List<Purchase> filterByDate(String date);
	public List<Purchase> filterByCategory(String category);
	public List<Purchase> getAllPurchase();
}
