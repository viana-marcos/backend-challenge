package com.invillia.service;

import java.util.List;

import com.invillia.model.Product;
import com.invillia.model.Store;

public interface ProductService {
	Product createProduct(Product product);
	Product getProductForId(Long id);	
	void updateProduct(Long id, Store store);
	List<Product> getAllProducts();
	List<String> fielsMessageErros(Product product);
}
