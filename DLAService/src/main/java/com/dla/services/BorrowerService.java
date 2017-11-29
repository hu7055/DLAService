package com.dla.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dla.document.Borrower;
import com.dla.document.Credit;
import com.dla.repository.BorrowerRepository;
import com.dla.seq.dao.SequenceDao;

@Service
@Configurable
public class BorrowerService {
	
	private static final String BORROWER_SEQ_KEY = "borrower";
	private static final String CREDIT_SEQ_KEY = "credit";
	
	@Autowired
	private SequenceDao sequenceDao;

	@Autowired
	BorrowerRepository borrowerRepository;
	
	public BorrowerService(BorrowerRepository borrowerRepository) {
		this.borrowerRepository = borrowerRepository;
	}
	
    public List<Borrower> findAllBorrowers(){
    	return borrowerRepository.findAll(new Sort(Sort.Direction.ASC, "bid"));
    }
    
    public Integer addBorrower(Borrower borrower){
    	
    	borrowerRepository.save(borrower);
    	
    	return borrower.getBid();
    }
    public void deleteBorrower(Integer bid){
    	if(borrowerRepository.findOne(bid)!= null){
    		borrowerRepository.delete(bid);
    	} 
    }
    
    public Borrower getBorrower(Integer bid){
    	
    	Borrower borrower = borrowerRepository.findOne(bid);
    	if(borrower != null){
    		 borrowerRepository.findOne(bid);
    	} 
    	return borrower;
    }
    
    public Integer getNextSequence(String seqKeyType){
    	long seqKey = sequenceDao.getNextSequenceId(seqKeyType);
    	return (int) seqKey;
    }
    
    @PostConstruct
    private void iniDataForTesting() {
    	/*borrowerRepository.save(new Borrower(new Integer(1), "Andy","416-897-9550","test address 2"));
    	borrowerRepository.save(new Borrower(new Integer(2), "Jinyoung","647-648-1007","test address 1"));
    	borrowerRepository.save(new Borrower(new Integer(3), "Bryan","647-648-1234","test address 1"));
    	borrowerRepository.save(new Borrower(new Integer(4), "Selva","647-648-4567","test address 1"));
    	borrowerRepository.save(new Borrower(new Integer(5), "Krishnadass","647-648-8888","test address 1"));
    	borrowerRepository.save(new Borrower(new Integer(6), "eon","647-232-1234","test address 1"));*/
    }
	

}
