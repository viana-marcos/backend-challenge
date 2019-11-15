package com.invillia.service;

import java.util.List;

import com.invillia.model.Order;

public interface OrderService {
	Order createOrder(Order order);
	Order getOrderForId(Long id);	
	List<Order> getAllOrder();
	Order filter(String confirmationDate, String address);
	List<String> fielsMessageErros(Order order);
}
