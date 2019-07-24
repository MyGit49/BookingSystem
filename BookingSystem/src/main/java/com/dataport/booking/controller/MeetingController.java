/**                                
 * Copyright ? 2019 河北数港;
 * 版权所有。     
 */ 

package com.dataport.booking.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/Meeting")
public class MeetingController {
	@Autowired 
	MeetingService meetingService;
	@PostMapping("/showMeeting")
	public List<Meeting> showMeeting(@RequestParam Date date,@RequestParam Integer roomId){
		return meetingService.findByInfromation(date, roomId);
	}
	@GetMapping("/testMeeting")
	public List<Meeting> testShowMeeting( Date date, Integer roomId) throws Exception{
		SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		date=format.parse("2019-07-09 00:00:00");
	    roomId=new Integer(1);
		return meetingService.findByInfromation(date, roomId);
	}
	
	@GetMapping("/AllMeeting")
	public List<Meeting> allShowMeeting() {
		return meetingService.findAll();
	}
}
