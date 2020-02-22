package com.infosys.cutomer_service.exceptionHandler;

public class CustomerAlreadyExistException extends RuntimeException{

	public CustomerAlreadyExistException(int id) {
		// TODO Auto-generated constructor stub
		super("customer with "+id+" already existed");
	}	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
