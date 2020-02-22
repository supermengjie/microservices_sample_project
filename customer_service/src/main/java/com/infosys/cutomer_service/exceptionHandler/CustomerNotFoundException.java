package com.infosys.cutomer_service.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException{

	public CustomerNotFoundException(int id) {
		// TODO Auto-generated constructor stub
		super("customer with "+id+" not found");
	}	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}