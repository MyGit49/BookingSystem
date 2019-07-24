package com.dataport.booking.entity;

import java.security.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="table_meeting")
public class Meeting {
	
	@Id
	@Column(name = "meeting_id")
	@JsonProperty(value="meeting_id")
	private int meetingId;
	
	@Column(name = "user_id")
	@JsonProperty(value="user_id")
	private int userId;
	
	@Column(name = "room_id")
	@JsonProperty(value="room_id")
	private int roomId;
	
	@Column(name = "meeting_content")
	@JsonProperty(value="meeting_content")
	private String content;
	
	@Column(name = "start_time")
	@JsonProperty(value="start_time")
	private int startTime;
	
	@Column(name = "end_time")
	@JsonProperty(value="end_time")
	private int endTime;
	
	@Column(name = "date")
	@JsonProperty(value="date")
	private String date;
	
	public int getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(int meetingId) {
		this.meetingId = meetingId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
