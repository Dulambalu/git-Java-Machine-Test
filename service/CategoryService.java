package com.category.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import com.category.entity.Categories;

import com.category.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public Page<Categories> getAllCategories(int page) {
		return categoryRepository.findAll(PageRequest.of(page, 10));
	}

	public Categories createCategory(Categories category) {
		return categoryRepository.save(category);
	}

	public Optional<Categories> getCategoryById(Long id) {
		return categoryRepository.findById(id);
	}

	public Categories updateCategory(Long id, Categories updatedCategory) {
		Categories category = categoryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Category not found"));
		category.setName(updatedCategory.getName());
		category.setDescription(updatedCategory.getDescription());
		return categoryRepository.save(category);
	}

	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}
}
