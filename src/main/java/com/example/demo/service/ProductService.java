package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CategoryJpaRepository;
import com.example.demo.repository.ProductJpaRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.model.Category;
import com.example.demo.model.Product;

@Service
public class ProductService implements ProductRepository {
	
	@Autowired
	public ProductJpaRepository pJR;
	
	@Autowired
	public CategoryJpaRepository cJR;

	@Override
	public ArrayList<Product> getProducts() {
		List<Product> product=pJR.findAll();
		ArrayList<Product> products=new ArrayList<>(product);
		return products;
	}

	@Override
	public Product addProduct(Product product) {
		Category cat=product.getCategory();
		int catId=cat.getCategoryId();
		Category comCat=cJR.findById(catId).get();
		product.setCategory(comCat);
		pJR.save(product);
		return product;
	}

	@Override
	public Product getProductById(int productId) {
		Product product=pJR.findById(productId).get();
		return product;
	}
	@Override
	public ArrayList<Product> getProductByCat(int categoryId) {
		List<Product> prodList=pJR.findAll();
		ArrayList<Product> productArr=new ArrayList<>(prodList);
		ArrayList<Product> fProd=new ArrayList<>();
		for(Product prod:productArr) {
			Category cat=prod.getCategory();
			int catId=cat.getCategoryId();
			if(catId==categoryId) {
				fProd.add(prod);
				
			}
		}
		
		return fProd;
	}
	

	

}
