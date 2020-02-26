package com.infosys.profile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;


@Configuration
public class CloudConfig {
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean 
	public Sampler defaultSampler() { 
	  return Sampler.ALWAYS_SAMPLE; 
	}
}
