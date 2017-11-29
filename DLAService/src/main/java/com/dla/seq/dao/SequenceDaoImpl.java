package com.dla.seq.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import static org.springframework.data.mongodb.core.query.Query.*;
import static org.springframework.data.mongodb.core.query.Criteria.*;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.*;

import com.dla.seq.exception.SequenceException;
import com.dla.seq.model.SequenceId;

@Repository
public class SequenceDaoImpl implements SequenceDao {

	@Autowired
	private MongoOperations mongoOperation;

	@Override
	public long getNextSequenceId(String key) throws SequenceException {
	  System.out.println(key);

		SequenceId seqId = mongoOperation.findAndModify(
	      query(where("_id").is(key)), 
	      new Update().inc("seq", 1),
	      options().returnNew(true),
	      SequenceId.class);
		
		System.out.println(seqId);

	  return seqId.getSeq();

	}

}
