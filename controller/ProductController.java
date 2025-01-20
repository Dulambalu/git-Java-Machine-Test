package com.category.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.category.entity.Product;
import com.category.service.ProductService;

public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping
	public ResponseEntity<?> getAllProduct(@RequestParam(defaultValue = "0") int page) {
		return ResponseEntity.ok(productService.getAllProduct(page));
	}

	@PostMapping
	public ResponseEntity<?> createProduct(@Validated @RequestBody Product product) {
		return ResponseEntity.ok(productService.createProduct(product));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable Long id) {
		Optional<Product> product = productService.getProductById(id);
		return product.isPresent() ? ResponseEntity.ok(product.get()) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable Long id, @Validated @RequestBody Product product) {
		return ResponseEntity.ok(productService.updateProduct(id, product));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		return ResponseEntity.noContent().build();
	}

}
