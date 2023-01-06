package com.example.openfeign.stadiumsService;

import lombok.Data;

import java.io.Serializable;

@Data
public class StadiumResponse implements Serializable {
    private Long id;

    private String name;

    private String description;
    private String type;
    private Integer capacity;
    private boolean covered;


    private Double price;

    private String location;

}
