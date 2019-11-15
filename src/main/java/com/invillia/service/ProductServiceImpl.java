package com.invillia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invillia.exception.NotFoundException;
import com.invillia.model.Product;
import com.invillia.model.Store;
import com.invillia.repository.ProductRepository;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> getAllProducts() {		
		return this.productRepository.findAll();
	}

	@Override
	public  Product createProduct(Product product) {		
		return this.productRepository.save(product);
    }
	

	@Override
	public void updateProduct(Long id, Store store) throws NotFoundException {
		Optional<Product> persistedOptional  = this.productRepository.findById(id);
		
		if (!persistedOptional.isPresent())
			throw new NotFoundException("Não encontrado");
		Product persisted = persistedOptional.get();
		//persisted.setName(store.getName());
		//persisted.setAddress(store.getAddress());
		//this.storeRepository.save(persisted);
		
	}

	@Override
	public Product getProductForId(Long id) throws NotFoundException{
		Optional<Product> persistedOptional  = this.productRepository.findById(id);
		if (!persistedOptional.isPresent())
			throw new NotFoundException("Não encontrado");
		return persistedOptional.get();
	}
	
	public List<String> fielsMessageErros(Product product) {
		List<String> messages = new ArrayList<String>();
		if(product.getStoreId() == null)
			messages.add("Identificador da loja obrigatório");
		if(product.getUnitPrice() == null)
			messages.add("o campo UnitPrice é obrigatório");
		if(product.getDescription() == null || product.getDescription().length() == 0)
			messages.add("a descrição é obrigatório");
		return messages;
		
	}
	

}
