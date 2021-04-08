package com.springboot.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.pojo.Purchase;
import com.springboot.repository.PurchaseRepository;

@Service(value = "purchaseService")
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@Override
	public void addPurchase(Purchase purchase) {
		this.purchaseRepository.saveAndFlush(purchase);
	}

	@Override
	public List<Purchase> filterByDate(String date) {
		return this.purchaseRepository.filterPurchaseByDate(date);
	}

	@Override
	public List<Purchase> filterByCategory(String category) {
		return this.purchaseRepository.filterPurchaseByCategory(category);
	}

	@Override
	public List<Purchase> getAllPurchase() {
		return this.purchaseRepository.findAll();
	}

	
	
}
