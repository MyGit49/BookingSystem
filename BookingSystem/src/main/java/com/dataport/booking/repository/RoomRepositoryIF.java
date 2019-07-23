package com.dataport.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dataport.booking.entity.Room;

public interface RoomRepositoryIF extends JpaRepository<Room, String>{

}
