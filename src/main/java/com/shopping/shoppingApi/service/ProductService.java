package com.shopping.shoppingApi.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.shopping.shoppingApi.entitie.Product;
import com.shopping.shoppingApi.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	public Page<Product> getAllProduct(Pageable pageable) {
		return productRepository.findAll(pageable);
	}
	
	public Optional<Product> findById(UUID id) {
		return productRepository.findById(id);
	}
	
	public List<Product> getProductByCategoryId(UUID id){
		return productRepository.getProductByCategory(id);
	}
	
	@Transactional
	public Product save(Product product) {
		if (productRepository.existsByproduct(product.getName(), product.getModel(), product.getManufacturer())) {
			return null;
		}
		return productRepository.save(product);
	}
	
	
}
