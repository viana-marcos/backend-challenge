package com.invillia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.invillia.model.Store;



@Repository("storeRepository")
public interface StoreRepository extends JpaRepository<Store, Long>  {
	
	@Query("SELECT s FROM store s WHERE s.name = ?1 or s.address = ?2")
	Store findStoreByNameAndAddress(String name, String address);	

}
