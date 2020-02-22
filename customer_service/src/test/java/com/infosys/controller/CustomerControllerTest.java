package com.infosys.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;


import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import com.infosys.cutomer_service.controller.CustomerController;
import com.infosys.cutomer_service.dto.CustomerDTO;


@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
	
	@Autowired
	private MockMvc mvc;
	

	private CustomerController customerController;
	
	@Test
	public void getCustomer() throws Exception{
		 CustomerController customerController = mock(CustomerController.class);
		CustomerDTO customer1= new CustomerDTO();
		customer1.setId(1);
		customer1.setName("james");
		List<CustomerDTO> all =  Collections.singletonList(customer1);
		//given(customerController.getAllCustomer()).willReturn(all);		//given(customerController.getAllCustomer()).willReturn(all);
		mvc.perform(get("/customers/"))
		.andExpect(status().isOk());/*
		.andExpect(jsonPath("name", is(customer1.getName())))
		.andExpect(jsonPath("Id", is(customer1.getId())));*/
		
	}

}