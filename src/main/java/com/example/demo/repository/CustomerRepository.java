package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Customer;
import com.example.demo.model.Product;

public interface CustomerRepository {
	
	ArrayList<Customer> getCustomers();
	
	Customer addCustomer(Customer customer);
	
	Customer getCustomerById(int customerId);
	
	List<Product> getCustomerProducts(int customerId);
	
	String addCustomerProducts(int customerId ,int productId);

	String removeCustomerProducts(int customerId ,int productId);
}
