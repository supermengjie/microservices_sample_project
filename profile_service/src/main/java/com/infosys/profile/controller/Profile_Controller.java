package com.infosys.profile.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infosys.profile.dto.CustomerDTO;
import com.infosys.profile.dto.EquipmentDTO;
import com.infosys.profile.dto.ProfileDTO;
import com.infosys.profile.exceptionHandler.ProfileNotFoundException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("profile")
public class Profile_Controller {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	DiscoveryClient discoveryClient;
	@Autowired
	RestTemplate restTemplate;
	
	
	
	@HystrixCommand(fallbackMethod = "getProfileFallback")
	@GetMapping("/{id}")
	public ResponseEntity<ProfileDTO> getProfile(@PathVariable int id) {
		Map<String, String> contextMap=MDC.getCopyOfContextMap();
		System.out.println(contextMap);
		logger.info("Profile request for customer Id {}", id);
		List<ServiceInstance> friendInstances= discoveryClient.getInstances("customer-service");
		ServiceInstance serviceInstance=friendInstances.get(0);
		URI friendUri = serviceInstance.getUri();
		//CustomerDTO customer=restTemplate.getForObject(friendUri+"customers/"+id,CustomerDTO.class);
		ResponseEntity<CustomerDTO> customer1 = restTemplate.exchange(friendUri+"customers/"+id, HttpMethod.GET, null,CustomerDTO.class);
		if(customer1==null) {
			throw new ProfileNotFoundException(id);
		}
		friendInstances= discoveryClient.getInstances("equipment-service");
		serviceInstance=friendInstances.get(0);
		friendUri = serviceInstance.getUri();
		
		ResponseEntity<List<EquipmentDTO>> responseBody = restTemplate.exchange(friendUri+"equipments/"+id,HttpMethod.GET, null, new ParameterizedTypeReference<List<EquipmentDTO>>() {});
		
		ProfileDTO profile = new ProfileDTO();
		profile.setId(id);
		CustomerDTO customer = customer1.getBody();
		profile.setName(customer.getName());
		profile.setAddress(customer.getAddress());
		
		profile.setEquipment(responseBody.getBody());
		logger.info("Profile for customerId{} : {}", id, profile);
		return new ResponseEntity<>(profile, HttpStatus.OK);
	}
	
	public ResponseEntity<ProfileDTO> getProfileFallback(@PathVariable int id) {
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

}
