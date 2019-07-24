package com.dataport.booking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="table_particpants")
public class Particpants {
	
	@Id
	@Column(name="inforation_id")
	private int inforationId;
	
	@Column(name = "meeting_id")
	private int meetingId;
	
	@Column(name = "user_id")
	private int userId;

	public int getInforation_id() {
		return inforationId;
	}

	public void setInforation_id(int inforation_id) {
		this.inforationId = inforation_id;
	}

	public int getMeeting_id() {
		return meetingId;
	}

	public void setMeeting_id(int meeting_id) {
		this.meetingId = meeting_id;
	}

	public int getUser_id() {
		return userId;
	}

	public void setUser_id(int user_id) {
		this.userId = user_id;
	}
	
	
}
