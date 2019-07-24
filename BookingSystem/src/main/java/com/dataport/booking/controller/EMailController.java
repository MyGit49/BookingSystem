package com.dataport.booking.controller;

import com.dataport.booking.entity.Particpants;
import com.dataport.booking.service.MailService;
import com.dataport.booking.service.ParticpantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;
import java.util.List;


/**@张计委
 * 邮件控制器
 */
@RestController
@RequestMapping("/mail")
public class EMailController {

    @Autowired
    ParticpantsService particpantsService;
    @Autowired
    MailService mailService;

    @PostMapping("/postMail")
    public String postMail(@RequestParam String mailSubject,@RequestParam String mailText,
                           @RequestParam String meetingId){
        System.out.println(".........");
        int Id = Integer.parseInt(meetingId);
        List<Particpants> particpantsList = particpantsService.findByMeetingId(Id);
        try{
            for (Particpants particpants : particpantsList){
                mailService.postMail(particpants.getUserEmail(),mailSubject,mailText);
            }
            return "success";
        }catch(Exception e){
            return "error";
        }
    }

}
