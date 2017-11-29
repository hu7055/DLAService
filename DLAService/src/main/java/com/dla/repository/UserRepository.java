package com.dla.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dla.document.Users;

public interface UserRepository extends MongoRepository<Users, Integer> {

}
