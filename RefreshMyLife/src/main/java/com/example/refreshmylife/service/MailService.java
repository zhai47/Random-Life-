package com.example.refreshmylife.service;

import com.example.refreshmylife.model.Mail;

import java.util.Date;

public interface MailService {
    public void sendTextMail(Mail mail);
    public void addTextMail(String email, String subject, String text);
}
