package com.invillia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.invillia.model.Product;



@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, Long>  {	
	

}
