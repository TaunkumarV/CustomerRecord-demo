package com.customer.crud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 
 * @author Tarun
 *
 */

@SpringBootApplication
//@EnableCaching
public class CustomerCrudDemoApplication {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(CustomerCrudDemoApplication.class, args);
	}

}
