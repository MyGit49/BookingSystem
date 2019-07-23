package com.dataport.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class PersonController {
	@GetMapping("/test/{str}")
	public String test(@PathVariable String str) {
		return str;
	}

}
