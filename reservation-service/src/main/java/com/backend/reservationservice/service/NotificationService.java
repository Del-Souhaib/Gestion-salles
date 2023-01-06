package com.backend.reservationservice.service;

import com.example.openfeign.notificationService.OFNotificationController;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NotificationService {

    @Autowired
    private OFNotificationController ofNotificationController;

    public void sendMail(String dateReservation){
        ofNotificationController.sendInvitationMail(dateReservation);
    }
}
