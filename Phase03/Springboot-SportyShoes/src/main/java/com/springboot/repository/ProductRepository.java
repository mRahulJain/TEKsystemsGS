package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.pojo.Product;
import com.springboot.pojo.Purchase;

@Repository(value = "productRepository")
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
}
