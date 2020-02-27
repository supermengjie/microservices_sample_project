package com.infosys.equipment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import brave.sampler.Sampler;


@Configuration
public class CloudConfig {
	
	@Bean 
	public Sampler defaultSampler() { 
	  return Sampler.ALWAYS_SAMPLE; 
	}
}
