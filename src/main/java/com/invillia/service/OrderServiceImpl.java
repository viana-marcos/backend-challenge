package com.invillia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invillia.exception.NotFoundException;
import com.invillia.model.Order;
import com.invillia.repository.OrderRepository;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public List<Order> getAllOrder() {		
		return this.orderRepository.findAll();
	}

	@Override
	public  Order createOrder(Order order) {		
		return this.orderRepository.save(order);
    }	

	

	@Override
	public Order getOrderForId(Long id) throws NotFoundException{
		Optional<Order> persistedOptional  = this.orderRepository.findById(id);
		if (!persistedOptional.isPresent())
			throw new NotFoundException("Não encontrado");
		return persistedOptional.get();
	}
	
	public List<String> fielsMessageErros(Order order) {
		List<String> messages = new ArrayList<String>();
		if(order.getStoreId() == null)
			messages.add("Identificador da loja obrigatório");
		if(order.getAddress() == null || order.getAddress().length() == 0)
			messages.add("o campo Address é obrigatório");
		if(order.getConfirmationDate() == null)
			messages.add("a data de confirmação é obrigatório");		
		if(order.getStatus() == null)
			messages.add("o status é obrigatório");
		
		if(order.getItems() == null || order.getItems().size()  == 0)
			messages.add("Não contém item na Ordem");
		return messages;
		
	}
	
	@Override
	public Order filter(String confirmationDate, String address) {
		Order persistedOptional  = this.orderRepository.findOrderByNameAndAddress(confirmationDate, address);		
		return persistedOptional;
		
	}	
	

}
