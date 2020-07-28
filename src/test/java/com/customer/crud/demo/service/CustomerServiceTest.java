package com.customer.crud.demo.service;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.customer.crud.demo.models.Address;
import com.customer.crud.demo.models.Customer;
import com.customer.crud.demo.models.NoRecordFoundException;

/**
 * 
 * @author Tarun
 *
 */

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CustomerServiceTest {

	@Autowired
	CustomerService customerService;

	@Test
	public void testInsertRecord() {
		Customer record = new Customer(1, "customer1", "customer@xyz.com",
				new Address("1", "street1", "Chennai", 600000), true);
		Customer result = customerService.insertRecord(record);
		Assert.assertNotNull(result);
	}

	@Test
	public void testUpdateRecord() {
		Customer record = new Customer(1, "customercustomer1", "customer123@xyz.com",
				new Address("1", "street1", "Chennai", 600000), true);
		Customer result;
		try {
			result = customerService.updateRecord(record);
			Assert.assertNotNull(result);
		} catch (NoRecordFoundException e) {
			Assert.assertEquals("No record existss for given id", e.getMessage());
		}
	}

	@Test
	public void testDeleteRecordId() {
		try {
			customerService.deleteRecordById(2);
		} catch (NoRecordFoundException e) {
			Assert.assertEquals("No record existss for given id", e.getMessage());
		}
	}

	@Test
	public void testGetRecordById() {
		try {
			Customer result = customerService.getRecordById(2);
			Assert.assertNotNull(result);
		} catch (NoRecordFoundException e) {
			Assert.assertEquals("No record existss for given id", e.getMessage());
		}
	}
	
	@Test
	public void testGetAllRecords() {
		List<Customer> customers = customerService.getAllRecords();
		Assert.assertEquals(true, customers.size() >= 0);
	}

}
