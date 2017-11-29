package com.dla.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dla.document.Borrower;

public interface BorrowerRepository extends MongoRepository<Borrower, Integer> {

}
