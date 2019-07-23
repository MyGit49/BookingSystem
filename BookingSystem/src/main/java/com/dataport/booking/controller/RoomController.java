package com.dataport.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dataport.booking.entity.Room;
import com.dataport.booking.service.RoomService;

@RestController
@RequestMapping("/V1")
public class RoomController {

	@Autowired
	RoomService roomService;
	
	@GetMapping("/showRoom")
	public List<Room> showRoom() {
		return roomService.findAll();
	}
}
