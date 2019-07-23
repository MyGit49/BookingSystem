package com.dataport.booking.controller;

import java.util.HashMap;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dataport.booking.entity.User;
import com.dataport.booking.service.UserService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/doLogin")
	public String doLogin(@RequestParam String userAccount,@RequestParam String password) {
		System.out.println("测试zjw");
		User user = userService.findByAccount(userAccount);
		if (user!=null) {
			if (user.getPassword().equals(password)) {
				return "success";
			}else {
				return "fail";
			}
		}
		return "fail";
	}

}
