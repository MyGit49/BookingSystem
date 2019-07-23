package com.dataport.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dataport.booking.entity.User;
import com.dataport.booking.service.UserService;

@RestController
@RequestMapping("/V1")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/user/pagesearch")
	public Page<User> findAll(Pageable pageable){
		return userService.findAll(pageable);
	}
	
	
}
