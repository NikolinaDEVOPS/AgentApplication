package com.devops.agentapp.service;


import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.devops.agentapp.model.Product;
import com.devops.agentapp.repository.ProductRepository;



@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

	public Optional<Product>  findById(Integer id) {
		return productRepository.findById(id);
	}

	public void deleteById(Integer id) {
		productRepository.deleteById(id);
	}

}