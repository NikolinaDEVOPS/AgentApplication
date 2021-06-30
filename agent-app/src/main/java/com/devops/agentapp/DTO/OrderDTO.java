package com.devops.agentapp.DTO;

import java.util.ArrayList;
import java.util.List;

import com.devops.agentapp.model.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDTO {
	private String customerName;

	private String customerLastName;

	private String address;

	private Double total;
	
	private List<Integer> productIds = new ArrayList<>();
}
