/**                                
 * Copyright ? 2019 河北数港;
 * 版权所有。     
 */ 

package com.dataport.booking.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dataport.booking.entity.MyMeeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dataport.booking.entity.Meeting;
import com.dataport.booking.service.MeetingService;

/**
 * <p>Class       : com.dataport.booking.controller.MeetingController
 * <p>Descdription: 前端返回date（yyyy-mm-dd HH:mm:ss） 和roomId 返回前端Meeting类
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
@RestController
@RequestMapping("/meeting")
public class MeetingController {
	@Autowired 
	MeetingService meetingService;
	
	/**
	 * @author zhangjw
	 *查询全部会议记录
	 */
	@PostMapping("/allMeeting")
	public List<Meeting> allMeeting(){
		return meetingService.findAll();
	}
	
	/**
	 * @author zhangjw
	 * 实现：何宇豪
	 *按月查询会议记录
	 *入参：房间ID、月份（1-12）    按需要将参数转为int类型
	 */
	@PostMapping("/meetingByMonth")
	public List<Meeting> meetingByMonth(@RequestParam String roomId,
			@RequestParam String date){
		return meetingService.meetingByMonth(roomId,date);
	}
	
	/**
	 * @author zhangjw
	 * 实现：何宇豪
	 *按天查询会议记录
	 *入参：年、月、天    按需要将参数转为int类型
	 */
	@PostMapping("/meetingByDay")
	public List<Meeting> meetingByDay(@RequestParam String date){
		return meetingService.meetingByDay(date);
	}
	
	@PostMapping("/meetingByUserId")
	public List<Meeting> meetingByUserId(@RequestParam int userId){
		return meetingService.meetingByUserId(userId);
	}
	
	/**
	 * @author zhangjw
	 * 实现：宋家林
	 *添加会议记录
	 *入参：meeting对象
	 */
	@PostMapping("/addMeeting")
	public String addMeeting(@RequestBody Meeting meeting){
		//需要实现的业务逻辑
		int size=meetingService.insertMeeting(meeting);
		String string;
		  if(size>0) {
		   string = new String("success");}
		  else {
		   string = new String("false");}
		  return string;
	}
	
	/**
	 * @author zhangjw
	 * 实现：孙焕振
	 *修改会议记录
	 *入参：userId,meetingId
	 */
	@PostMapping("/editMeeting")
	public String editMeeting(@RequestBody MyMeeting myMeeting){
		//返回前台状态码success或者error。
		return "";
	}
//	@PutMapping("/updateMeeting")
//	public Meeting updateMeeting(@RequestBody Meeting meeting){
//
//		if(meetingService.editMeeting(meeting.getMeetingId(), meeting.getUserId())!=null) {
//			String content=meeting.getContent();
//			int roomId=meeting.getRoomId();
//			int startTime=meeting.getStartTime();
//			int endTime=meeting.getEndTime();
//			String date=meeting.getDate();
//			meeting.setContent(content);
//			meeting.setRoomId(roomId);
//			meeting.setStartTime(startTime);
//			meeting.setEndTime(endTime);
//			meeting.setDate(date);
//			meetingService.updateMeeting(meeting);
//			return meeting;
//		}
//		return null;
//	}
	/**
	 * @author zhangjw
	 * 实现：杨雷
	 *删除会议记录
	 *入参：userId,meetingId
	 */
	@PostMapping("/deleteMeeting")
	public String deleteMeeting(@RequestParam int meetingId,@RequestParam int userId) {
		//int meetid=Integer.parseInt(meetingId);
		if(userId==meetingService.selectUserIdFromMeeting(meetingId)) {
			Integer size=meetingService.deleteMeeting(meetingId);
			String string;
			if(size>0) {
				string = new String("success");
			}
			else {
				string = new String("false");
			}
			return string;
		}
		else
			return "userId false";
	}
	
}
