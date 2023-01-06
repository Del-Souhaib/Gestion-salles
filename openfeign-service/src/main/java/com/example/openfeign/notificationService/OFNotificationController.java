package com.example.openfeign.notificationService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.crypto.Data;
import java.util.Date;

@FeignClient("notifications-service")
public interface OFNotificationController {

    @GetMapping("/api/notifications/{dateReservation}")
    void sendInvitationMail(@PathVariable("dateReservation") String dateReservation);

}
