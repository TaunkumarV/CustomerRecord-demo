package com.customer.crud.demo.models;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author Tarun
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "Customer")
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String name;
	private String emailaddress;
	private Address address;
	private boolean status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailaddress() {
		return emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + emailaddress + ", address=" + address
				+ ", status=" + status + "]";
	}

	/**
	 * 
	 * @param id
	 * @param name
	 * @param emailaddress
	 * @param address
	 * @param status
	 */
	public Customer(int id, String name, String emailaddress, Address address, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.emailaddress = emailaddress;
		this.address = address;
		this.status = status;
	}

}
