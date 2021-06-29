package com.devops.agentapp;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.devops.agentapp.model.Product;
import com.devops.agentapp.repository.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductTests {
	@Autowired
	private TestRestTemplate testRestTemplate;

	@Autowired
	private ProductRepository productRepository;
	
	@Before
	public void setUp() {
		Product product = new Product(1, "New product 1", 5, 200.00, null);
		productRepository.save(product);

		Product product2 = new Product(2, "New product 2", 20, 300.00, null);
		productRepository.save(product2);
	}
	@Test
	public void findById() {
		Product product = productRepository.findById(2).get();
		assertEquals(Integer.valueOf(2), product.getId());
	}
	@Test
	public void createNew() {
		Product product = new Product(null, "New product 1", 5, 200.00, null);
		Product prod = productRepository.save(product);
		
		assertEquals(prod.getId(), product.getId());
	}
	@Test
	public void getAll() {
		List<Product> prod = productRepository.findAll();
		
		assertEquals(prod.size(), 2);
	}
	
	@Test(expected=NoSuchElementException.class)
	public void delete() {
		productRepository.deleteById(1);
		Product product = productRepository.findById(1).get();
	}
}
