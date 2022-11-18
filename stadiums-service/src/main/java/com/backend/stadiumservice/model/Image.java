package com.backend.stadiumservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_gen")
    @SequenceGenerator(name = "image_gen", sequenceName = "image_seq")
    @Column(name = "id", nullable = false)
    private Long id;

  private  String image;
}
