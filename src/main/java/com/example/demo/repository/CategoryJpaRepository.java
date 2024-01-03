package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Category;

public interface CategoryJpaRepository extends JpaRepository<Category,Integer> {

}
