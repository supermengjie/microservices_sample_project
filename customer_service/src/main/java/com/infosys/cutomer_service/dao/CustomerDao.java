package com.infosys.cutomer_service.dao;

import org.springframework.data.repository.CrudRepository;

import com.infosys.cutomer_service.entity.CustomerEntity;

public interface CustomerDao extends CrudRepository<CustomerEntity, Integer> {
	
}
