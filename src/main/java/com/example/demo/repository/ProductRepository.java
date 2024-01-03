package com.example.demo.repository;

import java.util.ArrayList;



import com.example.demo.model.Product;

public interface ProductRepository {
	ArrayList<Product> getProducts();

	Product addProduct(Product product);
	
	Product getProductById(int productId);
	
	ArrayList<Product> getProductByCat(int productId);

}
