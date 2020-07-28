package com.customer.crud.demo.models;

import java.io.Serializable;

/**
 * 
 * @author Tarun
 *
 */
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;
	private String flatno;
	private String street;
	private String city;
	private long zip;

	public String getFlatno() {
		return flatno;
	}

	public void setFlatno(String flatno) {
		this.flatno = flatno;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getZip() {
		return zip;
	}

	public void setZip(long zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Address [flatno=" + flatno + ", street=" + street + ", city=" + city + ", zip=" + zip + "]";
	}

	/**
	 * 
	 * @param flatNo
	 * @param street
	 * @param city
	 * @param zip
	 */
	public Address(String flatNo, String street, String city, long zip) {
		super();
		this.flatno = flatNo;
		this.street = street;
		this.city = city;
		this.zip = zip;
	}

}
