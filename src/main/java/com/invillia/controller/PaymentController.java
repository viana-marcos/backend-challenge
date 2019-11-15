package com.invillia.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.dto.ResponseDTO;
import com.invillia.exception.NotFoundException;
import com.invillia.model.Order;
import com.invillia.model.Payment;
import com.invillia.service.OrderService;
import com.invillia.service.PaymentService;

import io.swagger.annotations.Api;


@Api(value = "payment")
@RestController
public class PaymentController {
	
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private OrderService orderService;
	
	

	@RequestMapping("/payment")
    public List<Payment> getProducts() {		
		return this.paymentService.getAllPayment();
	}	
	
	
	@PostMapping("/payment")
	public  ResponseEntity<ResponseDTO> createPayment(@Valid @RequestBody Payment payment) {
		
		ResponseDTO response = new ResponseDTO();
		
		try {
			List<String> fielsMessageErros = this.paymentService.fielsMessageErros(payment);
			if(fielsMessageErros.size() > 0) {
				response.addAllMessages(fielsMessageErros);
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			Order order = this.orderService.getOrderForId(payment.getOrderId());
				
			Payment persisted = this.paymentService.createPayment(payment);
			
			response.setData(persisted);	
			  
		    return new ResponseEntity<>(response, HttpStatus.OK);
				
		}catch (NotFoundException e) {
			response.addMessage("Não existe loja com o id informado");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		
	}
		
	
}
