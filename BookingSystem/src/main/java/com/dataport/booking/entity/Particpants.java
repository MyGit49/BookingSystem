package com.dataport.booking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="table_particpants")
public class Particpants {
	
	@Id
	@Column(name="information_id")
	private int informationId;
	
	@Column(name = "meeting_id")
	private int meetingId;
	
	@Column(name = "user_email")
	private String userEmail;

	public int getInformationId() {
		return informationId;
	}

	public void setInformationId(int informationId) {
		this.informationId = informationId;
	}

	public int getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(int meetingId) {
		this.meetingId = meetingId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}



	
}
