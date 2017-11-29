package com.dla.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.dla.document.Users;
import com.dla.repository.UserRepository;

//@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@EnableMongoRepositories("com.dla.repository")
@Configuration
public class MongoDbBConfig {

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository){
		return settings -> {
			userRepository.save(new Users(1, "Peter","Development",123L));
			userRepository.save(new Users(2, "Sam","Oeration",300L));
		};
	}
}
