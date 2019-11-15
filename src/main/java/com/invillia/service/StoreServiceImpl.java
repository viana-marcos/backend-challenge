package com.invillia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invillia.exception.NotFoundException;
import com.invillia.model.Store;
import com.invillia.repository.StoreRepository;

@Service("storeService")
public class StoreServiceImpl implements StoreService {
	
	
	@Autowired
	private StoreRepository storeRepository;

	@Override
	public List<Store> getAllStore() {		
		return this.storeRepository.findAll();
	}

	@Override
	public Store createStore(Store store) {		
		return this.storeRepository.save(store);
	}

	@Override
	public void updateStore(Long id, Store store) throws NotFoundException {
		Optional<Store> persistedOptional  = this.storeRepository.findById(id);
		
		if (!persistedOptional.isPresent())
			throw new NotFoundException("Não encontrado");
		Store persisted = persistedOptional.get();
		persisted.setName(store.getName());
		persisted.setAddress(store.getAddress());
		this.storeRepository.save(persisted);
		
	}

	@Override
	public Store getStoreForId(Long id) throws NotFoundException{
		Optional<Store> persistedOptional  = this.storeRepository.findById(id);
		if (!persistedOptional.isPresent())
			throw new NotFoundException("Não encontrado");
		return persistedOptional.get();
	}

	@Override
	public Store filter(String name, String address) {
		Store persistedOptional  = this.storeRepository.findStoreByNameAndAddress(name, address);		
		return persistedOptional;
		
	}
	

}
