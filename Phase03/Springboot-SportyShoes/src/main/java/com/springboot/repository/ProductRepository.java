package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.pojo.Product;

@Repository(value = "productRepository")
public interface ProductRepository extends JpaRepository<Product, Integer> { }
