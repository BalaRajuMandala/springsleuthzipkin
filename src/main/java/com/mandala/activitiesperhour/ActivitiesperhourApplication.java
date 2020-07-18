package com.mandala.activitiesperhour;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
public class ActivitiesperhourApplication {

	private static Logger log = LoggerFactory.getLogger(ActivitiesperhourApplication.class);

	public static void main(String[] args) {
		log.info("Yo! ActivitiesperhourApplication.");
		SpringApplication.run(ActivitiesperhourApplication.class, args);
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
