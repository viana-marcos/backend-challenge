package com.invillia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invillia.model.Payment;
import com.invillia.repository.PaymentRepository;

@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {
	
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Override
	public List<Payment> getAllPayment() {		
		return this.paymentRepository.findAll();
	}

	@Override
	public  Payment createPayment(Payment payment) {		
		return this.paymentRepository.save(payment);
    }
	
	
	public List<String> fielsMessageErros(Payment payment) {
		List<String> messages = new ArrayList<String>();
		if(payment.getOrderId()== null)
			messages.add("Identificador da Ordem obrigatório");
		if(payment.getCreditCardNumber() == null || payment.getCreditCardNumber().length() == 0)
			messages.add("o numero do cartão de credito é obrigatório");
		if(payment.getPaymentDate() == null)
			messages.add("a data de pagamento é obrigatório");		
		if(payment.getStatus() == null)
			messages.add("o status é obrigatório");		
		return messages;		
	}
	

}
