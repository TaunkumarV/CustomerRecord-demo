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
	public Customer updateRecord(Customer customer) throws NoRecordFoundException {
		Optional<Customer> record = customerrepo.findById(customer.getId());

		if (record.isPresent()) {
			Customer newEntity = record.get();
			newEntity.setId(customer.getId());
			newEntity.setName(customer.getName());
			newEntity.setEmailaddress(customer.getEmailaddress());
			newEntity = customerrepo.save(newEntity);

			return newEntity;
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
