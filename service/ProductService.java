package com.category.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.category.entity.Product;
import com.category.repository.ProductRepository;

public class ProductService {
	
	private ProductRepository  productRepository;

	public Page<Product> getAllCategories(int page){
		return productRepository.findAll(PageRequest.of(page, 10));
		
	}
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	public Optional<Product> getProductById(Long id){
		return productRepository.findById(id);
	}
	public Product updateProduct(Long id,Product updatedProduct) {
		Product product = productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));
		product.setName(updatedProduct.getName());
		product.setDescription(updatedProduct.getDescription());
		return productRepository.save(product);
		
	}
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
	public Object getAllProduct(int page) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
