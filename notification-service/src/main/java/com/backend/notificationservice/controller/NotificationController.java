package com.backend.notificationservice.controller;

import com.backend.notificationservice.service.NotificationService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.ws.rs.GET;
import java.util.Date;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    @Autowired
    NotificationService notificationService;

    @GetMapping("/{dateReservation}")
    public void sendInvitationMail(@PathVariable("dateReservation") String dateReservation) throws MessagingException {
        String[] mails={"del.souhaib@gmail.com"};
        notificationService.SendMail(mails,"Reservation","Your reservation has been registred success. at "+dateReservation);
    }

    @GetMapping("/ff")
    public String ff()  {
       return  "ffffffff";
    }
}
