/**                                
 * Copyright ? 2019 河北数港;
 * 版权所有。     
 */ 

package com.dataport.booking.service;


import java.util.Calendar;
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
	public Meeting editMeeting(int meetingId,int userId) {
		Meeting meeting=meetingRepositoryIF.findByMeetingId(meetingId);
		if(userId==meeting.getMeetingId()) {
			return meeting;
		}
		return null;
	}
	public void updateMeeting(Meeting meeting) {

		meetingRepositoryIF.save(meeting);
	}
	
	/**
	 * @author heyh
	 *  
	 *  1  记录：对list中元素进行遍历的时候使用倒序遍历（正序遍历使用remove始终会留有一个元素）
	 *  
	 *  2  按月份输出Meeting记录
	 */
	public List<Meeting> meetingByMonth(String roomId,String date){
		int roomId1=Integer.parseInt(roomId);
		List<Meeting> list = meetingRepositoryIF.findByRoomId(roomId1);
		for(int i=list.size()-1;i>=0;i--) {
			String str = list.get(i).getDate();
			if(!(date.substring(0,4).equals(str.substring(0, 4))&&date.substring(5, 7).equals(str.substring(5, 7)))) {
				list.remove(list.get(i));
			}
		}
		return list;
	}
	
	public List<Meeting> meetingByDay(String date){
		List<Meeting> list = meetingRepositoryIF.findAll();
		for(int i=list.size()-1;i>=0;i--) {
			String str = list.get(i).getDate();
			if(!(date.equals(str))) {
				list.remove(list.get(i));
			}
		}
		
		
		return list;
	}

	public List<Meeting> meetingByTime(String time){
		List<Meeting> list = meetingRepositoryIF.findAll();
		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		for(int i=list.size()-1;i>=0;i--) {
			String str = list.get(i).getDate();
			if(!(time.equals(str))&&(list.get(i).getStartTime()-hour*2)>4) {
				list.remove(list.get(i));
			}
		}


		return list;
	}

	public List<Meeting> meetingByUserId(int userId){
		List<Meeting> list = meetingRepositoryIF.findByUserId(userId);
		return list;
	}

	
}
