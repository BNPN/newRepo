package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	public CategoryService cService;
	
	@GetMapping("/categories")
	public ArrayList<Category> getCategories(){
		return cService.getCategories();
	}
	
	@PostMapping("/categories")
	public Category addCategory(@RequestBody Category category) {
		return cService.addCategory(category);
	}
	
	
	@GetMapping("/category/{categoryId}")
	public Category getCategory(@PathVariable("categoryId") int categoryId) {
		return cService.getCategoryById(categoryId);
	}
}
