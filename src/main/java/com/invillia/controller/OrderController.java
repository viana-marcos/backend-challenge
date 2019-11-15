package com.invillia.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.dto.ResponseDTO;
import com.invillia.exception.NotFoundException;
import com.invillia.model.Order;
import com.invillia.model.Store;
import com.invillia.service.OrderService;
import com.invillia.service.StoreService;

import io.swagger.annotations.Api;


@Api(value = "order")
@RestController
public class OrderController {
	
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private StoreService storeService;

	@RequestMapping("/order")
    public List<Order> getProducts() {		
		return this.orderService.getAllOrder();
	}
	
	@RequestMapping("/order/{id}")
    public ResponseEntity<Object> getProductForId(@PathVariable("id") Long id) {		
		
		try {
			Order order = this.orderService.getOrderForId(id);
			return new ResponseEntity<>(order, HttpStatus.OK);			
		}catch (NotFoundException e) {
			return new ResponseEntity<>("Order not found", HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping("/order/filter")
	public Order filter(@RequestParam(required = false) String confirmationDate, @RequestParam(required = false) String address) {
	    return this.orderService.filter(confirmationDate, address);
	}
	
	@PostMapping("/order")
	public  ResponseEntity<ResponseDTO> createOrder(@Valid @RequestBody Order order) {
		
		ResponseDTO response = new ResponseDTO();
		
		try {
			List<String> fielsMessageErros = this.orderService.fielsMessageErros(order);
			if(fielsMessageErros.size() > 0) {
				response.addAllMessages(fielsMessageErros);
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			Store store = this.storeService.getStoreForId(order.getStoreId());
				
			Order persisted = this.orderService.createOrder(order);
			
			response.setData(persisted);	
			  
		    return new ResponseEntity<>(response, HttpStatus.OK);
				
		}catch (NotFoundException e) {
			response.addMessage("Não existe loja com o id informado");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		
	}
		
	
}
