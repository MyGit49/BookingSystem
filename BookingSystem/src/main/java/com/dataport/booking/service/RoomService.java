package com.dataport.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dataport.booking.entity.Room;
import com.dataport.booking.repository.RoomRepositoryIF;

@Service
@Transactional(rollbackFor = Exception.class)//当发生异常时回滚
public class RoomService {

	@Autowired
	RoomRepositoryIF roomRepositoryIF;
	
	public List<Room> findAll() {
		return roomRepositoryIF.findAll();
	}

	public Room findByRoomId(int id){
		return roomRepositoryIF.findByRoomId(id);
	}
}
