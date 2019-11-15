package com.invillia.service;

import java.util.List;

import com.invillia.model.Store;

public interface StoreService {
	Store createStore(Store store);
	Store getStoreForId(Long id);
	Store filter(String name, String address);
	void updateStore(Long id, Store store);
	List<Store> getAllStore();
}
