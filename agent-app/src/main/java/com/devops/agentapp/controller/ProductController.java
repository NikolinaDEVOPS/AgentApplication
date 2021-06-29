package com.devops.agentapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devops.agentapp.model.Product;
import com.devops.agentapp.service.ProductService;
import com.devops.agentapp.exception.ProductNotFoundException;

import org.springframework.http.MediaType;


@RestController
@CrossOrigin
@RequestMapping(value = "/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getProducts() {
		return productService.findAll();
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Product newProduct(@RequestBody Product newProduct) {
	    return productService.save(newProduct);
	}
	
	@GetMapping("/{id}")
	public Product one(@PathVariable Integer id) {
	    return productService.findById(id)
	      .orElseThrow(() -> new ProductNotFoundException(id));
	}
	
	@PutMapping("/{id}")
	public Product updateProduct(@RequestBody Product newProduct, @PathVariable Integer id) {
		productService.findById(id)
			      .orElseThrow(() -> new ProductNotFoundException(id));
		newProduct.setId(id);
		return productService.save(newProduct);
	}
	
	@DeleteMapping("/{id}")
	void deleteEmployee(@PathVariable Integer id) {
		productService.findById(id)
			      .orElseThrow(() -> new ProductNotFoundException(id));
		productService.deleteById(id);
	}
}
