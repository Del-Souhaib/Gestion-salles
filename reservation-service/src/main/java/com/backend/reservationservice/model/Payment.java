package com.backend.reservationservice.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Data
@Document
public class Payment {

    @Id
    private String id;

    private Long responsable;
//    @Field("reservation_id")
//    @DocumentReference(lookup = "{ 'id' : ?#{#target} }")
    @DBRef
    @JsonIgnore
    private Reservation reservation;

    private String type_payment;

    private String card_type;

    private String card_number;

    private String expiration_date;

    private Integer security_code;

    private Double amount;

    private Date created_at=new Date();

}
