package com.devops.agentapp.controller;

import lombok.RequiredArgsConstructor;

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
import com.devops.agentapp.model.ProductOrder;
import com.devops.agentapp.service.ProductOrderService;
import com.devops.agentapp.service.ProductService;
import com.devops.agentapp.DTO.OrderDTO;
import com.devops.agentapp.exception.ProductNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@RestController
@CrossOrigin
@RequestMapping(value = "/order")
public class OrderController {
	@Autowired
	private ProductOrderService productOrderService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductOrder> getOrders() {
		return productOrderService.findAll();
	}
	
	@PostMapping
	public ProductOrder create(@RequestBody OrderDTO orderDto) {
		return productOrderService.save(orderDto);
	}
	
}
