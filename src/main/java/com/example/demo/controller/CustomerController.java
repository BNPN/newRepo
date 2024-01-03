package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.model.Product;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	public CustomerService cService;
	
	@GetMapping("/customers")
	public ArrayList<Customer> getCustomers(){
		return cService.getCustomers();
		
	}
	@GetMapping("/customer/{customerId}")
	public Customer getCustomerById(@PathVariable("customerId") int customerId){
		
		return cService.getCustomerById(customerId);
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		return cService.addCustomer(customer);
	}
	@GetMapping("/customer/{customerId}/products")
	public List<Product> getCustomerProducts(@PathVariable("customerId") int customerId){
		return cService.getCustomerProducts(customerId);
	}
	
	@PostMapping("/customer/{customerId}/add/products/{productId}")
	public String addCustomerProducts(@PathVariable("customerId") int customerId,@PathVariable("productId") int productId) {
		return cService.addCustomerProducts(customerId, productId);
	}
	
	@PostMapping("/customer/{customerId}/remove/products/{productId}")
	public String removeCustomerProducts(@PathVariable("customerId") int customerId,@PathVariable("productId") int productId) {
		return cService.removeCustomerProducts(customerId, productId);
	}

}
