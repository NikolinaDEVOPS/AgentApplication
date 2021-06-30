package com.devops.agentapp.service;


import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.devops.agentapp.DTO.OrderDTO;
import com.devops.agentapp.model.Product;
import com.devops.agentapp.model.ProductOrder;
import com.devops.agentapp.repository.ProductOrderRepository;
import com.devops.agentapp.repository.ProductRepository;



@Service
@RequiredArgsConstructor
public class ProductOrderService {
    private final ProductOrderRepository productOrderRepository;
    private final ProductRepository productRepository;
    
    public List<ProductOrder> findAll() {
        return productOrderRepository.findAll();
    }

    public ProductOrder save(OrderDTO orderDto) {
		Double total = 0.0;
    	List<Product> products = new ArrayList<>();
    	
		for (Integer id : orderDto.getProductIds()) {
			Product product = productRepository.findById(id).get();
			
			if (product.getAmount() > 0) {
				total += product.getPrice();
				product.setAmount(product.getAmount() - 1);
				productRepository.save(product);
				products.add(product);
			} else {
				throw new Error("Product is not on stock.");
			}
		}
		ProductOrder order = new ProductOrder(null, orderDto.getCustomerName(), orderDto.getCustomerLastName(),
				orderDto.getAddress(), total, products);
		return productOrderRepository.save(order);
    }

	public Optional<ProductOrder>  findById(Integer id) {
		return productOrderRepository.findById(id);
	}

	public void deleteById(Integer id) {
		productOrderRepository.deleteById(id);
	}

}