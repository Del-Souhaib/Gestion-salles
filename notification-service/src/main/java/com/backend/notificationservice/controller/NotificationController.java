package com.backend.notificationservice.controller;

import com.backend.notificationservice.service.NotificationService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.ws.rs.GET;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    @Autowired
    NotificationService notificationService;

    @GetMapping("")
    public void sendInvitationMail() throws MessagingException {
        String[] mails={"souhaib2.allout@gmail.com"};
        notificationService.SendMail(mails,"test","just test");
    }

    @GetMapping("/ff")
    public String ff()  {
       return  "ffffffff";
    }
}
