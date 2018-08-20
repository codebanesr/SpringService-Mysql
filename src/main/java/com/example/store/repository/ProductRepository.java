package com.example.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.store.model.Product;

/**
 * Created by Shanur Rahman 20 Aug 2018
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	
	
//	You will now be able to use JpaRepository’s methods like save(), 
//	findOne(), findAll(), count(), delete() etc.

}



//This is step 2 of REST API , we get all functionalities required for rest application do a ctrl click to go to JpaRepository
//next step is to map url to functionalities, we do that in the controller section next