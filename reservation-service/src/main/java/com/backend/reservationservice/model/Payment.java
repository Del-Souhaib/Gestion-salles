package com.backend.reservationservice.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Payment {

    @Id
    private String id;

    private Long responsable;
    @Field("reservation_id")
    @DocumentReference(lookup = "{ 'id' : ?#{#target} }")
    private Reservation reservation;

    private String type;

    private Double amount;

    private Date created_at=new Date();

}
