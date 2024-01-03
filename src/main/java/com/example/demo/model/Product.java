package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name="product")
public class Product {
	@Id
	@Column(name="productId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productId;
	
	@Column(name="productName")
	private String productName;
	
	@Column(name="productImg")
	private String productImg;
	
	@Column(name="productCost")
	private int productCost;
	
	@Column(name="productDiscount")
	private int productDiscount;
	
	
	@ManyToOne
	@JoinColumn(name="category")
	private Category category;
	
	





	@ManyToMany(mappedBy="products")
	@JsonIgnoreProperties("products")
	private List<Customer> customers=new ArrayList<>();
	
	public Product() {
		super();
	}

	

	

	
	public Product(int productId, String productName, String productImg, int productCost, int productDiscount,
			Category category, List<Customer> customers) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productImg = productImg;
		this.productCost = productCost;
		this.productDiscount = productDiscount;
		this.category = category;
		this.customers = customers;
	}





	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public int getProductCost() {
		return productCost;
	}

	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}

	public int getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(int productDiscount) {
		this.productDiscount = productDiscount;
	}

	





	public Category getCategory() {
		return category;
	}






	public void setCategory(Category category) {
		this.category = category;
	}






	public List<Customer> getCustomers() {
		return customers;
	}





	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	

}

