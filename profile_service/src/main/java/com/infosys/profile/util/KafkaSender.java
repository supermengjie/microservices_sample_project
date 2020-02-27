package com.infosys.profile.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	private final String topic = "profile_service";
	public void send(String message) {
		kafkaTemplate.send(topic,message);
	}

}
