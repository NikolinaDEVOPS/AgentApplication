package com.devops.agentapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devops.agentapp.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}