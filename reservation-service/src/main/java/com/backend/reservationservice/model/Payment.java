package com.backend.reservationservice.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Payment {

    @Id
    private String id;

    private Long responsable;

    @JsonIgnore
    private Reservation reservation;

    private String type;

    private Double amount;

    private Date created_at;

}
