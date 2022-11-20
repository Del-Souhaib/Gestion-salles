package com.backend.notificationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;

@Service
public class NotificationService {
//    private MailSender mailSender;
//
//    @Autowired
//    public NotificationService(MailSender mailSender) {
//        this.mailSender = mailSender;
//    }
//
//    public void sendMailMessage(String[] to, String subject, String message) {
//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//        simpleMailMessage.setFrom("info@pitches.com");
//        simpleMailMessage.setTo(to);
//        simpleMailMessage.setSubject(subject);
//        simpleMailMessage.setText(message);
//        this.mailSender.send(simpleMailMessage);
//    }


    @Autowired
    private JavaMailSender emailSender;

    public void SendMail(String[] to, String subject, String messageText) throws MessagingException {

        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("souhaib2.allout@gmail.com");
        helper.setTo(to);
        helper.setSubject(subject);
        String htmltemplate="<i>test</i>";
        helper.setText(messageText);


        emailSender.send(message);
    }
}
