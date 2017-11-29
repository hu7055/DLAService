package com.dla.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;

@Configuration
public class AppConfig {
	
	@Value("${spring.data.mongodb.host}")
	private String mongodbHost;
	@Value("${spring.data.mongodb.port}")
	private Integer mongodbPort;
	@Value("${spring.data.mongodb.database}")
	private String mongodbDatabase;
	
	@Bean
	public MongoTemplate mongoTemplate(){
		
		return new MongoTemplate(new MongoClient(mongodbHost,mongodbPort), mongodbDatabase);
	}
}
