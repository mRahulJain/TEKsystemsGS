package com.springboot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.springboot.pojo.Product;
import com.springboot.repository.ProductRepository;

@Service(value = "productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void addProduct(Product product) {
		this.productRepository.saveAndFlush(product);
		
	}

	@Override
	public void updateProduct(int id, Product product) {
		this.productRepository.deleteById(id);
		product.setId(id);
		this.productRepository.saveAndFlush(product);
	}

	@Override
	public void deleteProduct(int id) {
		this.productRepository.deleteById(id);
	}

	@Override
	public List<Product> getAllProducts() {
		return this.productRepository.findAll(Sort.by(Sort.Direction.ASC, "productName"));
	}

	@Override
	public Product getProductById(int id) {
		return this.productRepository.getOne(id);
	}
	
}
