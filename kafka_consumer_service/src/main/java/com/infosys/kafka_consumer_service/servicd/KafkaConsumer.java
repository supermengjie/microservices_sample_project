package com.infosys.kafka_consumer_service.servicd;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infosys.kafka_consumer_service.dao.TransactionDao;
import com.infosys.kafka_consumer_service.entity.TransactionDetails;

@Service
public class KafkaConsumer {
	
	@Autowired
	TransactionDao transactionDao;
	private ObjectMapper om = new ObjectMapper();
	
	@KafkaListener(topics="profile_service", groupId ="group-id")
	public void consume(String message) throws JsonParseException, JsonMappingException, IOException {
		//System.out.println(message);
		TransactionDetails td=om.readValue(message, TransactionDetails.class);
		td.setConsumeTime(Timestamp.valueOf(LocalDateTime.now()));
		transactionDao.save(td);
		//System.out.println(td);
	}

}
