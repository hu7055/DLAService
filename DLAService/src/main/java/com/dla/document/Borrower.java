package com.dla.document;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Borrower {
	@Id
	private Integer bid;
	private String bname;
	private String phone;
	private String address;
	private List<Credit> credits;
	

	public Borrower(Integer bid, String bname, String phone, String address, List<Credit> credits) {
		this.bid = bid;
		this.bname = bname;
		this.phone = phone;
		this.address = address;
		this.credits = credits;
	}
	public Borrower() {
		
	}
	
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String teamName) {
		this.phone = teamName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Credit> getCredits() {
		return credits;
	}
	public void setCredits(List<Credit> credits) {
		this.credits = credits;
	}
	
	
	
	
}
