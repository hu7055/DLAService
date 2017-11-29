package com.dla.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dla.document.Borrower;
import com.dla.document.Users;
import com.dla.model.AjaxResponseBody;
import com.dla.services.BorrowerService;
import com.dla.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class IndexController {

    private final Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    UserService userService;
    
    @Autowired
    BorrowerService borrowerService;
    

    @GetMapping("/")
    public ModelAndView index(HttpServletRequest request) {
        logger.debug("from master");
    	ModelAndView mav = new ModelAndView();
    	logger.debug("test3");
    	mav.addObject("result", "success");
    	mav.setViewName("pages/index");
    	
    	return mav;
    }
    
    @GetMapping("/table")
    public ModelAndView table(HttpServletRequest request) {
    	ModelAndView mav = new ModelAndView();
    	
    	mav.addObject("result", "success");
    	mav.setViewName("pages/table");
    	
    	return mav;
    }
    @GetMapping("/mainPage")
    public ModelAndView mainPage() {
    	
    	ModelAndView mav = new ModelAndView();
    	mav.addObject("name", "subpage");
    	mav.setViewName("pages/index");
        
    	return mav;
    }
    @GetMapping("/test1")
    public ModelAndView test1() {
    	
    	ModelAndView mav = new ModelAndView();
    	mav.addObject("name", "test1");
    	mav.setViewName("test1");
        
    	return mav;
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/index2")
    public ResponseEntity<List<Users>> index3() {
    	
    	List<Users> users = userService.findAllUsers();
    	System.out.println(users);
    	
        return new ResponseEntity<List<Users>>(users,HttpStatus.OK );
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/borrower")
    public ResponseEntity<List<Borrower>> borrower() {
    	
    	List<Borrower> borrowers = borrowerService.findAllBorrowers();
    	//System.out.println(borrowers);
    	
        return new ResponseEntity<List<Borrower>>(borrowers,HttpStatus.OK );
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/borrower", method=RequestMethod.POST, consumes="application/json")
    public ResponseEntity<?> addBorrower(@RequestBody String json) {
    	
    	System.out.println("added customer : "+ json);
    	ObjectMapper mapper = new ObjectMapper();
    	Borrower borrower = null;
        try {
			borrower = mapper.readValue(json, Borrower.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Integer bid = borrowerService.addBorrower(borrower);
        
        System.out.println("added customer : "+ borrower.getBid() + borrower.getBname());
    	
        AjaxResponseBody result = new AjaxResponseBody();

        //If error, just return a 400 bad request, along with the error message
        result.setMsg("success");
        Map<String,String> resultMap = new HashMap<String,String>();
        resultMap.put("bid", bid.toString());
        if(borrower.getCredits() != null){
        	resultMap.put("creditAppId", borrower.getCredits().get(0).getCreditAppId().toString());
        }
        
        result.setResultMap(resultMap);
        

        return ResponseEntity.ok(result);
    	
    	
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/borrower/{bid}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteBorrower(@PathVariable("bid") Integer bid) {
    
        System.out.println("delete");
        borrowerService.deleteBorrower(bid);
    	
        AjaxResponseBody result = new AjaxResponseBody();

        result.setMsg("success");

        return ResponseEntity.ok(result);
    	
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/borrower/{bid}", method=RequestMethod.GET)
    public ResponseEntity<?> getBorrower(@PathVariable("bid") Integer bid) {
    
        System.out.println("getBorrower");
        
    	
        Borrower borrower = borrowerService.getBorrower(bid);
    	//System.out.println(borrowers);
    	
        AjaxResponseBody result = new AjaxResponseBody();

        result.setMsg("success");

        return new ResponseEntity<Borrower>(borrower,HttpStatus.OK );
    	
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/sequence/{seqKey}", method=RequestMethod.GET)
    public ResponseEntity<?> creditSequence(@PathVariable("seqKey") String seqKey) {
    
        System.out.println("get next sequence..");
        Integer nextSeqKey = borrowerService.getNextSequence(seqKey);
    	
        AjaxResponseBody result = new AjaxResponseBody();
        Map<String,String> resultMap = new HashMap<String,String>();
        
        if("credit".equalsIgnoreCase(seqKey)){
        	resultMap.put("creditAppId", nextSeqKey.toString());
        } else if("borrower".equalsIgnoreCase(seqKey)) {
        	resultMap.put("bid", nextSeqKey.toString());
        } else if("facility".equalsIgnoreCase(seqKey)) {
        	resultMap.put("fid", nextSeqKey.toString());
        }
        result.setMsg("success");
        result.setResultMap(resultMap);
        return ResponseEntity.ok(result);
    	
    }
}
