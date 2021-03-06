package com.infosys.cutomer_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.cutomer_service.dao.CustomerDao;
import com.infosys.cutomer_service.dto.CustomerDTO;
import com.infosys.cutomer_service.entity.CustomerEntity;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CustomerDao customerDao;
	
	@Override
	public String save(CustomerDTO customer) {
		logger.info("Creation request for customer: "+customer);
		CustomerEntity customerEntity= new CustomerEntity();
		BeanUtils.copyProperties(customer, customerEntity);
		customerDao.save(customerEntity);
		return "";
		
	}
	
	@Override
	public CustomerDTO findCustomerById(int id) {
		logger.info("customersInfo request for customer "+ id);
		Optional<CustomerEntity> optionalCE= customerDao.findById(id);
		CustomerDTO c=null;
		if(optionalCE.isPresent()) {
			CustomerEntity ce = optionalCE.get();
			c= new CustomerDTO();
			BeanUtils.copyProperties(ce, c);
			
		}
		logger.info("customersInfo for customer:"+c );
		return c;
	}
	
	@Override
	public List<CustomerDTO> findCustomer() {
		logger.info("customersInfo request for all customer");
		Iterable<CustomerEntity> allCustomers=customerDao.findAll();
		List<CustomerDTO>  lCustomers= new ArrayList<>();
		for(CustomerEntity ce: allCustomers) {
			CustomerDTO c = new CustomerDTO();
			BeanUtils.copyProperties(ce, c);
			lCustomers.add(c);
		}
		logger.info("customersInfo for all customer : "+ lCustomers );
		return lCustomers;
		
	}
}
