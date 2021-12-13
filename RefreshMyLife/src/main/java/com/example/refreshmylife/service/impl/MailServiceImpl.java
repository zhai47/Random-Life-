package com.example.refreshmylife.service.impl;

import com.example.refreshmylife.mapper.MailMapper;
import com.example.refreshmylife.model.Mail;
import com.example.refreshmylife.model.User;
import com.example.refreshmylife.service.MailService;
import com.example.refreshmylife.service.UserService;
import com.example.refreshmylife.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class MailServiceImpl implements MailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private MailMapper mailMapper;

    @Autowired
    private JavaMailSenderImpl javaMailSenderImp;

    @Override
    public void sendTextMail(Mail mail) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mail.getFrom());
        message.setTo(mail.getTo());
        message.setSubject(mail.getSubject());
        message.setText(mail.getText());

        try {
            javaMailSender.send(message);
            log.info("Text邮件已经发送");
        } catch (Exception e) {
            log.info("发送Text邮件时发生异常！", e);
        }
    }

    @Override
    public void addTextMail(String email, String subject, String text) {
        Mail mail = new Mail();
        mail.setFrom(email);
        mail.setTo(email);
        mail.setSubject(subject);
        mail.setText(text);
        System.out.println(mail);
        mailMapper.insert(mail);
        sendTextMail(mail);
    }


}
