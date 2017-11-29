package com.dla.controller;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dla.document.Users;
import com.dla.repository.UserRepository;
import com.dla.services.UserService;

@RestController
@RequestMapping("/rest/users")
public class UserController {
	
	private UserService userService;
	
	private UserRepository userRepository;
	
	public UserController(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	public UserController() {
		// TODO Auto-generated constructor stub
		userService = new UserService(userRepository);
	}

	@GetMapping("/all")
	public List<Users> getAll() {
		return userService.findAllUsers();
	}
	
	public long getSum(){
		List<Users> users = userService.findAllUsers();
		long sum = new Long("0");
		
		for(Users user : users){
			sum = sum + user.getSalary();
		}
		return sum;
	}

}
