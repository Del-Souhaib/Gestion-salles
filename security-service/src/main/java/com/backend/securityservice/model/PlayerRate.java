package com.backend.securityservice.model;

import org.apache.catalina.User;

import javax.persistence.*;

@Entity
public class PlayerRate {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    private MyUser player;

    private Integer nb_stars;

    private String comment;
}
