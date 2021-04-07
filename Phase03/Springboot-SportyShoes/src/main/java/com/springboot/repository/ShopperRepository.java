package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.pojo.Shopper;

@Repository("shopperRepository")
public interface ShopperRepository extends JpaRepository<Shopper, Integer> { 

	@Query(
			value = "SELECT * from Shopper where shopper_username like %?1% or "
					+ "shopper_first_name like %?1% or "
					+ "shopper_last_name like %?1% or "
					+ "shopper_email like %?1% or "
					+ "shopper_phone_number like %?1% or "
					+ "shopper_address like %?1%",
			nativeQuery = true)
	List<Shopper> findShopperByUsername(String like);
	
}
