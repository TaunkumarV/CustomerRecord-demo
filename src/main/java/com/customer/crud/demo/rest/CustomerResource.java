package com.customer.crud.demo.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.crud.demo.models.Customer;
import com.customer.crud.demo.models.NoRecordFoundException;
import com.customer.crud.demo.service.CustomerService;


/**
 * 
 * @author Tarun
 *
 */
@RestController
@RequestMapping("/customer")
public class CustomerResource {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	CustomerService service;

	/**
	 * inserts customer record
	 * @param customer
	 * @return
	 */
	@PutMapping("/")
	private ResponseEntity<Customer> insertRecord(@RequestBody Customer customer) {
		logger.info("Begin insertRecord = {}", customer.getId());
		Customer updated = service.insertRecord(customer);
		logger.info("end insertRecord = {}", customer.getId());
		return new ResponseEntity<Customer>(updated, new HttpHeaders(), HttpStatus.OK);

	}

	/**
	 * updates customer record
	 * @param customer
	 * @return
	 * @throws NoRecordFoundException
	 */
	@PostMapping(path = "/", consumes = "application/json", produces = "application/json")
	private ResponseEntity<Customer> updateRecord(@RequestBody Customer customer) throws NoRecordFoundException {
		logger.info("Begin updateRecord = {}", customer.getId());
		Customer updated = service.updateRecord(customer);
		logger.info("end updateRecord = {}", customer.getId());
		return new ResponseEntity<Customer>(updated, new HttpHeaders(), HttpStatus.OK);

	}

	/**
	 * delete customer record by customerId
	 * @param customerid
	 * @return
	 * @throws NoRecordFoundException
	 */
	@DeleteMapping(path = "/{customerNumber}", produces = "application/json")
	private HttpStatus deleteRecordById(@PathVariable("customerNumber") int customerid)
			throws NoRecordFoundException {
		logger.info("Begin deleteRecordById = {}", customerid);
		service.deleteRecordById(customerid);
		logger.info("end deleteRecordById = {}", customerid);
		return HttpStatus.NOT_FOUND;

	}
	
	/**
	 * retrieves customer record by customer id
	 * @param customerid
	 * @return
	 * @throws NoRecordFoundException
	 */
	@GetMapping(path = "/{customerNumber}", produces = "application/json")
	private ResponseEntity<Customer> getRecordById(@PathVariable("customerNumber") int customerid)
			throws NoRecordFoundException {
		logger.info("Begin getRecordById = {}",customerid);
		Customer record = service.getRecordById(customerid);
		logger.info("end getRecordById = {}",customerid);
		if(!record.isStatus())
			return new ResponseEntity<Customer>(record, new HttpHeaders(), HttpStatus.NOT_FOUND);

		return new ResponseEntity<Customer>(record, new HttpHeaders(), HttpStatus.OK);

	}
	
	/**
	 * List of all customer records
	 * @return
	 */
	@GetMapping(path = "/", produces = "application/json")
	private ResponseEntity<List<Customer>> getAllRecords() {
		logger.info("Begin getAllRecords");
		List<Customer> list = service.getAllRecords();
		logger.info("End getAllRecords");
		return new ResponseEntity<List<Customer>>(list, new HttpHeaders(), HttpStatus.OK);

	}

}
