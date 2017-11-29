package com.dla.seq.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sequence")
public class SequenceId {
	@Id
	private String _id;
	
	private long seq;

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		this._id = id;
	}

	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
	}

	@Override
	public String toString() {
		return "SequenceId [id=" + _id + ", seq=" + seq + "]";
	}
	
	
}
