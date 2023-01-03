package com.backend.reservationservice.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Document
public class Reservation {

    @Id
    private String id;

    private Long owner;

    private Long responsable;

    private List<Long> players;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dateReservation;

    private Long pitch;

    private Date created_at=new Date();

    @DocumentReference
    private List<Payment> payments;

    public List<Long> getPlayers() {
        if(players==null){
            players=new ArrayList<>();
        }
        return players;
    }

    public List<Payment> getPayments() {
        if(payments==null){
            payments=new ArrayList<>();
        }
        return payments;
    }
}
