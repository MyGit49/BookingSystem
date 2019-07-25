/**                                
 * Copyright ? 2019 河北数港;
 * 版权所有。     
 */ 

package com.dataport.booking.controller;

import com.dataport.booking.entity.Meeting;
import com.dataport.booking.entity.Room;
import com.dataport.booking.entity.User;
import com.dataport.booking.service.MailService;
import com.dataport.booking.service.MeetingService;
import com.dataport.booking.service.RoomService;
import com.dataport.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * <p>Class       : com.dataport.booking.controller.Test
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
@RestController
@RequestMapping("/test")
public class Test {
    @Autowired
    MeetingService meetingService;
    @Autowired
    UserService userService;
    @Autowired
    MailService mailService;
    @Autowired
    RoomService roomService;
    @PostMapping("/test")
    public String test(){
        //查出今天的会议记录
        Date today = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("yyyy-MM-dd");
        String todayString = simpleDateFormat.format(today);
        List<Meeting> meetingList = meetingService.meetingByDay(todayString);
        //查出符合条件的会议记录
        Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		for (int i = meetingList.size()-1;i>=0;i--){
		    if (hour*2-meetingList.get(i).getStartTime()>4){
		        meetingList.remove(meetingList.get(i));
            }
        }
		for (int i = meetingList.size()-1;i>=0;i--){
            User user = userService.findByUserId(meetingList.get(i).getUserId());
            String mailText;
            String startTime;
            String endTime;
            if (meetingList.get(i).getStartTime()%2==0){
                startTime = meetingList.get(i).getStartTime()/2+":00";
            }else {
                startTime = (meetingList.get(i).getStartTime()-1)/2+":30";
            }
            if (meetingList.get(i).getEndTime()%2==0){
                endTime = meetingList.get(i).getEndTime()/2+":00";
            }else {
                endTime = (meetingList.get(i).getEndTime()-1)/2+":30";
            }
            Room room = roomService.findByRoomId(meetingList.get(i).getRoomId());
            mailText = "会议时间："+startTime+"--"+endTime+","+"会议地点："+room.getName()+","+"会议内容："+meetingList.get(i).getContent()+"。";
            mailService.postMail(user.getEmail(),"会议通知",mailText);
        }
        System.out.println(meetingList.size()+todayString+hour);
        return "success";
    }

}
