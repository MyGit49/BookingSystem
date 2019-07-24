/**                                
 * Copyright ? 2019 河北数港;
 * 版权所有。     
 */ 

package com.dataport.booking.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dataport.booking.entity.Meeting;
import com.dataport.booking.repository.MeetingRepositoryIF;

/**
 * <p>Class       : com.dataport.booking.service.MeetingService
 * <p>Descdription: 类功能描述
 *
 * @author  XX XX@dataport.com.cn
 * @version 1.0.0
 *<p>
 *--------------------------------------------------------------<br>
 * 修改履历：<br>
 *        <li> 2019年7月23日，XX@dataport.com.cn，创建文件；<br>
 *--------------------------------------------------------------<br>
 *</p>
 */
@Service
@Transactional(rollbackFor = Exception.class)//当发生异常时回滚
public class MeetingService {
	@Autowired 
	MeetingRepositoryIF meetingRepositoryIF;
	
//	public List<Meeting> findByDate(Timestamp date,int roomId) {
//		return meetingRepositoryIF.findByDateAndRoomId(date, roomId);
//	}
//	
	public List<Meeting> findByInfromation(Date date,Integer roomId) {
		return meetingRepositoryIF.findByDateAndRoomId(date, roomId);
	}
	public List<Meeting> findAll(){
		return meetingRepositoryIF.findAll();
	}
	
	
	public int insertMeeting(Meeting meeting) {
		  return meetingRepositoryIF.insertMeeting(meeting.getMeetingId(),meeting.getUserId(),
		    meeting.getRoomId(),meeting.getContent(),meeting.getStartTime(),meeting.getEndTime(),
		    meeting.getDate());
		 }
}
