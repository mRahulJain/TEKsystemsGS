package com.springboot.service;

import java.util.List;
import java.util.Optional;

import com.springboot.pojo.Shopper;

public interface ShopperService {

	public List<Shopper> getShoppers();
	public Shopper getShopper(int id);
	public boolean getAndCheckShopper(String username, String password);
	public void addShopper(Shopper shopper);
	public List<Shopper> getShopperByUsername(String username);
	
}
