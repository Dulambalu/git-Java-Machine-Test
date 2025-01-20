package com.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.category.entity.Categories;


public interface CategoryRepository  extends JpaRepository<Categories, Long>{

}
