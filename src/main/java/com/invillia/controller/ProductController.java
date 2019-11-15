package com.invillia.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.dto.ResponseDTO;
import com.invillia.exception.NotFoundException;
import com.invillia.model.Product;
import com.invillia.model.Store;
import com.invillia.service.ProductService;
import com.invillia.service.StoreService;

import io.swagger.annotations.Api;


@Api(value = "product")
@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private StoreService storeService;

	@RequestMapping("/product")
    public List<Product> getProducts() {		
		return this.productService.getAllProducts();
	}
	
	@RequestMapping("/product/{id}")
    public ResponseEntity<Object> getProductForId(@PathVariable("id") Long id) {		
		
		try {
			Product product = this.productService.getProductForId(id);
			return new ResponseEntity<>(product, HttpStatus.OK);			
		}catch (NotFoundException e) {
			return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/product")
	public  ResponseEntity<ResponseDTO> createProduct(@Valid @RequestBody Product product) {
		
		ResponseDTO response = new ResponseDTO();
		
		try {
			List<String> fielsMessageErros = this.productService.fielsMessageErros(product);
			if(fielsMessageErros.size() > 0) {
				response.addAllMessages(fielsMessageErros);
				 return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			Store store = this.storeService.getStoreForId(product.getStoreId());
				
			Product persisted = this.productService.createProduct(product);
			
			response.setData(persisted);	
			  
		    return new ResponseEntity<>(response, HttpStatus.OK);
				
		}catch (NotFoundException e) {
			response.addMessage("Não existe loja com o id informado");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		
	}	
	
	@PutMapping("/product/{id}")
	public ResponseEntity<String> updateStore(@RequestBody Store store, @PathVariable("id") Long id) {
		try {
			this.productService.updateProduct(id, store);
			return new ResponseEntity<>("Store is updated successfully", HttpStatus.OK);			
		}catch (NotFoundException e) {
			return new ResponseEntity<>("Store not found", HttpStatus.NOT_FOUND);
		}
	    
	}	
	
}
