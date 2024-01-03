package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category;

import com.example.demo.repository.CategoryJpaRepository;
import com.example.demo.repository.CategoryRepository;


@Service
public class CategoryService implements CategoryRepository {
	
	@Autowired
	public CategoryJpaRepository catJR;

	@Override
	public ArrayList<Category> getCategories() {
		List<Category> category= catJR.findAll();
		ArrayList<Category> categories=new ArrayList<>(category);
		return categories;
	}

	@Override
	public Category addCategory(Category category) {
		catJR.save(category);
		return category;
	}

	@Override
	public Category getCategoryById(int categoryId) {
		Category category=catJR.findById(categoryId).get();
		
		return category;
	}

}
