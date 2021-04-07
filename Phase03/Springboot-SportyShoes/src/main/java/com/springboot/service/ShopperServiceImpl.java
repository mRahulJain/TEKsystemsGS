package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.pojo.Shopper;
import com.springboot.repository.ShopperRepository;

@Service(value = "shopperService")
public class ShopperServiceImpl implements ShopperService {

	@Autowired
	private ShopperRepository shopperRepository;
	
	@Override
	public boolean getAndCheckShopper(String username, String password) {
		List<Shopper> shopperList = this.shopperRepository.findAll();
		for(Shopper shopper : shopperList) {
			if(shopper.getUsername().equals(username)) {
				if(shopper.getPassword().equals(password)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void addShopper(Shopper shopper) {
		this.shopperRepository.saveAndFlush(shopper);
	}

	@Override
	public List<Shopper> getShoppers() {
		return this.shopperRepository.findAll(Sort.by(Sort.Direction.ASC, "username"));
	}

	@Override
	public List<Shopper> getShopperByUsername(String username) {
		return this.shopperRepository.findShopperByUsername(username);
	}

	@Override
	public Shopper getShopper(int id) {
		return this.shopperRepository.getOne(id);
	}

	
	
}
