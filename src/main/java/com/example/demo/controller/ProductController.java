package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ProductService;
import com.example.demo.model.Product;

@RestController
public class ProductController {
	@Autowired
	public ProductService prodSer;
		
	@GetMapping("/products")
	public ArrayList<Product> getProduct(){
		return prodSer.getProducts();
	}
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product) {
		
		return prodSer.addProduct(product);
	}
	@GetMapping("/product/{productId}")
	public  Product getProduct(@PathVariable("productId") int productId){
		return prodSer.getProductById(productId);
	}
	@GetMapping("/products/category/{categoryId}")
	public ArrayList<Product> getProductByCat(@PathVariable("categoryId") int categoryId){
		return prodSer.getProductByCat(categoryId);
	}
}