package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Customer;

public interface CustomerJpaRepository extends JpaRepository<Customer,Integer>{

}
