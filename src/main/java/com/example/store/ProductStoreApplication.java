package com.example.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ProductStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductStoreApplication.class, args);
	}
}

//
//
//auditing simply means tracking and 
//logging every change we do in our persisted records, which 
//simply means tracking every insert, update, and delete operation and storing it.



//use auditing for stuff like 
//Spring Data Annotations @CreatedBy, @CreatedDate, @LastModifiedBy, and @LastModifiedDate

// Next we require a repository to create all functions that will help us in creating deleting etc