package com.dataport.booking.service;

import com.dataport.booking.entity.Particpants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)//当发生异常时回滚
public class MailService {
    private static String content = "<!DOCTYPE html>"
            + "<html>"
            + "<head>"
            + "<title>测试邮件2</title>"
            + "<meta name=\"content-type\" content=\"text/html; charset=UTF-8\">"
            + "</head>"
            + "<body>"
            + "<p style=\"color:#0FF\">这是一封测试邮件~</p>"
            + "</body>"
            + "</html>"; // 可以用HTMl语言写
    @Autowired
    JavaMailSender javaMailSender;
    public void postMail(String mailAddress,String mailSubject,String mailText){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("2285246577@qq.com");
        simpleMailMessage.setTo(mailAddress);
        simpleMailMessage.setSubject(mailSubject);
        simpleMailMessage.setText(mailText);
        javaMailSender.send(simpleMailMessage);
    }
}
