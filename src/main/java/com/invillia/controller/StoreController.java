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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.exception.NotFoundException;
import com.invillia.model.Store;
import com.invillia.service.StoreService;

import io.swagger.annotations.Api;


@Api(value = "store")
@RestController
public class StoreController {
	
	@Autowired
	private StoreService storeService;

	@RequestMapping("/store")
    public List<Store> getStores() {		
		return this.storeService.getAllStore();
	}
	
	@RequestMapping("/store/{id}")
    public ResponseEntity<Object> getStoreForId(@PathVariable("id") Long id) {		
		
		try {
			Store store = this.storeService.getStoreForId(id);
			return new ResponseEntity<>(store, HttpStatus.OK);			
		}catch (NotFoundException e) {
			return new ResponseEntity<>("Store not found", HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/store")
	public Store createStore(@Valid @RequestBody Store store) {
	    return this.storeService.createStore(store);
	}
	
	@RequestMapping("/store/filter")
	public Store filter(@RequestParam(required = false) String name, @RequestParam(required = false) String address) {
	    return this.storeService.filter(name, address);
	}
	
	@PutMapping("/store/{id}")
	public ResponseEntity<String> updateStore(@RequestBody Store store, @PathVariable("id") Long id) {
		try {
			this.storeService.updateStore(id, store);
			return new ResponseEntity<>("Store is updated successfully", HttpStatus.OK);			
		}catch (NotFoundException e) {
			return new ResponseEntity<>("Store not found", HttpStatus.NOT_FOUND);
		}
	    
	}
	
}
