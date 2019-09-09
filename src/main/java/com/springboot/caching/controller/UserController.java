package com.springboot.caching.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.springboot.caching.Service.UserService;
import com.springboot.caching.entity.User;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	
	private  final UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping(value = "/all")
	public List<User> getAllUsers(){
		return userService.findAll();
	}
	
	
	@GetMapping(value = "/add")
	public Boolean updateUser() {
		return userService.addUser();
	}
	
	@DeleteMapping(value = "/delete")
	public void deleteUsers() {
		userService.deleteAll();
	}
	
	
	
}
