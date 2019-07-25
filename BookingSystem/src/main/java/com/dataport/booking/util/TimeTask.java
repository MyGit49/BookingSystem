package com.dataport.booking.util;

import com.dataport.booking.entity.Meeting;
import com.dataport.booking.entity.Particpants;
import com.dataport.booking.entity.Room;
import com.dataport.booking.service.MailService;
import com.dataport.booking.service.MeetingService;
import com.dataport.booking.service.ParticpantsService;
import com.dataport.booking.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 定时任务，发送邮件
 */
@Component
public class TimeTask {

    @Autowired
    ParticpantsService particpantsService;
    @Autowired
    MeetingService meetingService;
    @Autowired
    MailService mailService;
    @Autowired
    RoomService roomService;
    //定时任务条件
    //每年：0 0 0 0 0 ?
    //每半小时执行一次：0 0/30 * * * ?
    //每五分钟执行一次：0 0/5 * * * ?
    @Scheduled(cron = "0 0/5 * * * ?")
    public void doTask(){
        Date nowTime = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("yyyy-MM-dd");
        String timeString = simpleDateFormat.format(nowTime);
        List<Meeting> meetingList = meetingService.meetingByTime(timeString);
        for (Meeting meeting : meetingList){
            String startTime;
            String endTime;
            if (meeting.getStartTime()%2==0){
                startTime = meeting.getStartTime()/2+"点";
            }else {
                startTime = (meeting.getStartTime()-1)/2+"点30分";
            }
            if (meeting.getEndTime()%2==0){
                endTime = meeting.getEndTime()/2+"点";
            }else {
                endTime = (meeting.getEndTime()-1)/2+"点30分";
            }
            Room room = roomService.findByRoomId(meeting.getRoomId());
            String mailText = "会议时间："+startTime+"--"+endTime+","+"会议地点:"+room.getName()+","+"会议内容:"+meeting.getContent()+"。";
            List<Particpants> particpantsList = particpantsService.findByMeetingId(meeting.getMeetingId());
            for (Particpants particpants : particpantsList){
                mailService.postMail(particpants.getUserEmail(),"会议通知",mailText);
            }
        }
        System.out.println("执行定时任务");
    }
}
