package com.infosys.cutomer_service.service;

import java.util.List;

import com.infosys.cutomer_service.dto.CustomerDTO;

public interface CustomerService {

	String save(CustomerDTO customer);

	List<CustomerDTO> findCustomer();

	CustomerDTO findCustomerById(int id);

}