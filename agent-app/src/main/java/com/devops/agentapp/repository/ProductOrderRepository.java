package com.devops.agentapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devops.agentapp.model.Product;
import com.devops.agentapp.model.ProductOrder;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {
}
