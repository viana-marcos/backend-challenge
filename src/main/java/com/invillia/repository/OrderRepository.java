package com.invillia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.invillia.model.Order;



@Repository("orderRepository")
public interface OrderRepository extends JpaRepository<Order, Long>  {	

	@Query("SELECT o FROM orders o WHERE o.confirmationDate = ?1 or o.address = ?2")
	Order findOrderByNameAndAddress(String confirmationDate, String address);

}
