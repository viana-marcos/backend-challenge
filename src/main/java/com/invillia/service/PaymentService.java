package com.invillia.service;

import java.util.List;

import com.invillia.model.Payment;

public interface PaymentService {
	Payment createPayment(Payment payment);	
	List<Payment> getAllPayment();
	List<String> fielsMessageErros(Payment payment);	
}
