//package com.dataport.booking.util;
//
//import com.dataport.booking.entity.Meeting;
//import com.dataport.booking.entity.Room;
//import com.dataport.booking.entity.User;
//import com.dataport.booking.service.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//
///**
// * 定时任务，发送邮件
// */
//@Component
//public class TimeTask {
//
//    @Autowired
//    MeetingService meetingService;
//    @Autowired
//    UserService userService;
//    @Autowired
//    MailService mailService;
//    @Autowired
//    RoomService roomService;
//    //定时任务条件
//    //每年：0 0 0 0 0 ?
//    //每半小时执行一次：0 0/30 * * * ?
//    //每五分钟执行一次：0 0/5 * * * ?
//    @Scheduled(cron = "0 0/30 * * * ?")
//    public void doTask(){
//        //查出今天的会议记录
//        Date today = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("yyyy-MM-dd");
//        String todayString = simpleDateFormat.format(today);
//        List<Meeting> meetingList = meetingService.meetingByDay(todayString);
//        //查出符合条件的会议记录
//        Calendar c = Calendar.getInstance();
//        int hour = c.get(Calendar.HOUR_OF_DAY);
//        for (int i = meetingList.size()-1;i>=0;i--){
//            if (hour*2-meetingList.get(i).getStartTime()>4){
//                meetingList.remove(meetingList.get(i));
//            }
//        }
//        for (int i = meetingList.size()-1;i>=0;i--){
//            User user = userService.findByUserId(meetingList.get(i).getUserId());
//            String mailText;
//            String startTime;
//            String endTime;
//            if (meetingList.get(i).getStartTime()%2==0){
//                startTime = meetingList.get(i).getStartTime()/2+":00";
//            }else {
//                startTime = (meetingList.get(i).getStartTime()-1)/2+":30";
//            }
//            if (meetingList.get(i).getEndTime()%2==0){
//                endTime = meetingList.get(i).getEndTime()/2+":00";
//            }else {
//                endTime = (meetingList.get(i).getEndTime()-1)/2+":30";
//            }
//            Room room = roomService.findByRoomId(meetingList.get(i).getRoomId());
//            mailText = "会议时间："+startTime+"--"+endTime+","+"会议地点："+room.getName()+","+"会议内容："+meetingList.get(i).getContent()+"。";
//            mailService.postMail(user.getEmail(),"会议通知",mailText);
//        }
//        System.out.println("执行定时任务");
//    }
//}
