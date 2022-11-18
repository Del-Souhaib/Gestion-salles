package com.backend.reservationservice.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Getter
@Setter
public class Reservation {

    @Id
    private String id;

    private Date dateReservation;
}
