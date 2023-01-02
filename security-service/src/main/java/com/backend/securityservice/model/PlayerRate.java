package com.backend.securityservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class PlayerRate {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id",insertable = false,updatable = false)
    @JsonIgnore
    private MyUser player;

    private Long player_id;

    private Integer nb_stars;

    private String reservation;

    @ManyToOne
    @JoinColumn(name = "owner_id",insertable = false,updatable = false)
    @JsonIgnore
    private MyUser owner;

    private Long owner_id;

}
