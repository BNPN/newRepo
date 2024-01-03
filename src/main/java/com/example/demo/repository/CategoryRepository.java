package com.example.demo.repository;

import java.util.ArrayList;

import com.example.demo.model.Category;


public interface CategoryRepository {
/*ArrayList<Customer> getCustomers();
	
	Customer addCustomer(Customer customer);
	
	Customer getCustomerById(int customerId);*/
	ArrayList<Category> getCategories();
	
	Category addCategory(Category category);
	
	Category getCategoryById(int CategoryId);
	
}
