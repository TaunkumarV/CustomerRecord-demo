package com.customer.crud.demo.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.customer.crud.demo.models.Customer;

/**
 * 
 * @author Tarun
 * Customer Respository class is used for data access functionality 
 */
public interface CustomerRepository extends MongoRepository<Customer, Integer> {

}
