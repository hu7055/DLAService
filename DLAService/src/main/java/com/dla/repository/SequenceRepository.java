package com.dla.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dla.document.Borrower;
import com.dla.seq.model.SequenceId;

public interface SequenceRepository extends MongoRepository<SequenceId, Integer> {

}
