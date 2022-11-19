package com.backend.stadiumservice.model;

import javax.persistence.*;

@Entity
public class PitchRate {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    private Pitch pitch;

    private Integer nb_stars;

    private String comment;
}
