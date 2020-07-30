package com.customer.crud.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.crud.demo.models.Customer;
import com.customer.crud.demo.models.NoRecordFoundException;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;



/**
 * 
 * @author Tarun
 *
 */
@Service
public class CustomerService {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	CustomerRepository customerrepo;

	/**
	 * 
	 * @param customer
	 * @return
	 */
	//@CachePut(value = "customer", key = "#cust.id")
	public Customer insertRecord(Customer customer) {
		customer = customerrepo.save(customer);

		return customer;
	}
    
	/**
	 * 
	 * @param customer
	 * @return
	 * @throws NoRecordFoundException
	 */
	//@CachePut(value = "customer", key = "#cust.id")
	public Customer updateRecord(Customer customer) throws NoRecordFoundException {
		Optional<Customer> record = customerrepo.findById(customer.getId());

		if (record.isPresent()) {
			Customer updateRecord = record.get();
			updateRecord.setId(customer.getId());
			updateRecord.setName(customer.getName());
			updateRecord.setEmailaddress(customer.getEmailaddress());
			updateRecord = customerrepo.save(updateRecord);

			return updateRecord;
		} else {
			logger.info("No record found for given id {}", customer.getId());
			throw new NoRecordFoundException("No record found for given id");
		}
	}
	
	/**
	 * 
	 * @param customerid
	 * @throws NoRecordFoundException
	 */
	//@CacheEvict(value = "customer", allEntries=true)
	public void deleteRecordById(int customerid) throws NoRecordFoundException {
		Optional<Customer> record = customerrepo.findById(customerid);

		if (record.isPresent()) {
			customerrepo.deleteById(customerid);
		} else {
			logger.info("No record found for given id {}",customerid);
			throw new NoRecordFoundException("No record found for given id");
		}

	}
	
	/**
	 * 
	 * @param customerid
	 * @return
	 * @throws NoRecordFoundException
	 */
	//@Cacheable(value ="customer" ,key ="#p0" )
	public Customer getRecordById(int customerid) throws NoRecordFoundException {
		Optional<Customer> record = customerrepo.findById(customerid);

		if (record.isPresent()) {
			return record.get();
		} else {
			logger.info("No record found for given id {}",customerid);
			throw new NoRecordFoundException("No record found for given id");
		}
	}
	
	/**
	 * 
	 * @return all the records will be fetched with getAllRecords
	 */
	public List<Customer> getAllRecords() {
		List<Customer> customerRecords = customerrepo.findAll();
		logger.info("getAllCustomer size {}",customerRecords.size());
		if (customerRecords.size() > 0) {
			return customerRecords;
		} else {
			return new ArrayList<Customer>();
		}
	}

}
