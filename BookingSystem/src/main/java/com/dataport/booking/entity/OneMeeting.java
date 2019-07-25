package com.dataport.booking.entity;

public class OneMeeting {
    private String userName;
    private String roomName;
    private Meeting meeting;


    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getRoomName() {
        return roomName;
    }
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
    public Meeting getMeeting() {
        return meeting;
    }
    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }
}
