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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.category.entity.Categories;
import com.category.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public ResponseEntity<?> getAllCategories(@RequestParam(defaultValue = "0") int page) {
		return ResponseEntity.ok(categoryService.getAllCategories(page));
	}

	@PostMapping
	public ResponseEntity<?> createCategory(@Validated @RequestBody Categories category) {
		return ResponseEntity.ok(categoryService.createCategory(category));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
		Optional<Categories> category = categoryService.getCategoryById(id);
		return category.isPresent() ? ResponseEntity.ok(category.get()) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateCategory(@PathVariable Long id, @Validated @RequestBody Categories category) {
		return ResponseEntity.ok(categoryService.updateCategory(id, category));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
		categoryService.deleteCategory(id);
		return ResponseEntity.noContent().build();
	}
}
