package com.customer.crud.demo.models;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author Tarun
 *
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoRecordFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @param message
	 */
	public NoRecordFoundException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param t
	 */
	public NoRecordFoundException(String message, Throwable t) {
		super(message, t);
	}
	
	

}
