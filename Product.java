package com.category.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


public class Product {
	@Id
	@GeneratedValue
	
	private String Id;
	private String name;
	private String description;
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
