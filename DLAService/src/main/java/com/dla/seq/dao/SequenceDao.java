package com.dla.seq.dao;

import com.dla.seq.exception.SequenceException;

public interface SequenceDao {
	long getNextSequenceId(String key) throws SequenceException;
}
