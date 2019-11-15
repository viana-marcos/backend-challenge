package com.invillia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.invillia.model.Payment;

@Repository("paymentRepository")
public interface PaymentRepository extends JpaRepository<Payment, Long>  {	
	
	
}
