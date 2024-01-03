package com.example.demo.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.model.Product;
import com.example.demo.repository.CustomerJpaRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.ProductJpaRepository;
@Service
public class CustomerService implements CustomerRepository {
	
	@Autowired
	public CustomerJpaRepository cJR;
	
	@Autowired
	public ProductJpaRepository pJR;

	@Override
	public ArrayList<Customer> getCustomers() {
		List<Customer> customer = cJR.findAll();
		ArrayList<Customer> customers=new ArrayList<>(customer);
		return customers;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		cJR.save(customer);
		return customer;
	}

	@Override
	public Customer getCustomerById(int customerId) {
		Customer customer=cJR.findById(customerId).get();
		return customer;
	}

	@Override
	public List<Product> getCustomerProducts(int customerId) {
		Customer customer=cJR.findById(customerId).get();
		return customer.getProducts();
	}

	@Override
	public String addCustomerProducts(int customerId ,int productId) {
		Product product=pJR.findById(productId).get();
		Customer cust=cJR.findById(customerId).get();
		List<Product> prod=cust.getProducts();
		prod.add(product);
		cust.setProducts(prod);
		cJR.save(cust );
		return "product added to cart successfully";
	}

	@Override
	public String removeCustomerProducts(int customerId ,int productId) {
		Product product=pJR.findById(productId).get();
		Customer cust=cJR.findById(customerId).get();
		List<Product> prod=cust.getProducts();
		prod.remove(product);
		cust.setProducts(prod);
		cJR.save(cust );
		return "product removed to cart successfully";
	}
}
