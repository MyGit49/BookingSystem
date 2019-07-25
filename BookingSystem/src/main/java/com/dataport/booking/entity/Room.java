package com.dataport.booking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="table_room")
public class Room {
	
	@Id
	@Column(name = "room_id")
	private int roomId;
	
	@Column(name = "room_name")
	private String name;
	
	@Column(name = "room_capacity")
	private int capacity;
	
	@Column(name = "room_state")
	private int state;

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int room_id) {
		this.roomId = room_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	
}
