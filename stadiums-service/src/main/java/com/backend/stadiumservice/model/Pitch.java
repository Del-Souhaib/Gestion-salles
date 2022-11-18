package com.backend.stadiumservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Pitch {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stadium_gen")
    @SequenceGenerator(name = "stadium_gen", sequenceName = "stadium_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    private String nom;

    private String Description;
    private String Type;
    private Integer capacity;
    private boolean covered;

    private Double price;

    private String location;

    @OneToMany
    private List<Image> images;
}
