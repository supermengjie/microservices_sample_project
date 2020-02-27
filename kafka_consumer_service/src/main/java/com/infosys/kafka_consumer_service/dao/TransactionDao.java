package com.infosys.kafka_consumer_service.dao;

import org.springframework.data.repository.CrudRepository;

import com.infosys.kafka_consumer_service.entity.TransactionDetails;

public interface TransactionDao extends CrudRepository<TransactionDetails, Integer> {
	
}
