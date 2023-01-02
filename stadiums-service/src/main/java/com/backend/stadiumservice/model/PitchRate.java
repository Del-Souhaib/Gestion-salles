package com.backend.stadiumservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class PitchRate {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pitch_id",updatable = false,insertable = false)
    @JsonIgnore
    private Pitch pitch;

    private Long pitch_id;

    private Long player_id;

    private Integer nb_stars;

    private String reservation;

}
