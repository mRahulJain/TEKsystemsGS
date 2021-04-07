package com.springboot.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.pojo.Purchase;
import com.springboot.pojo.Shopper;

@Repository(value = "purchaseRepository")
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

	@Query(
			value = "SELECT * from Purchase where purchase_date = ?1",
			nativeQuery = true)
	List<Purchase> filterPurchaseByDate(Date date);
	
	@Query(
			value = "SELECT * from Purchase where purchase_category = ?1",
			nativeQuery = true)
	List<Purchase> filterPurchaseByCategory(String category);
	
}
