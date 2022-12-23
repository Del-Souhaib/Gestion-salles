package com.backend.stadiumservice.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Pitch {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stadium_gen")
    @SequenceGenerator(name = "stadium_gen", sequenceName = "stadium_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String description;
    private String type;
    private Integer capacity;
    private boolean covered;

    private Double price;

    private String location;

    @OneToMany(mappedBy = "pitch",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PitchImage> images;


//    public List<PitchImage> getImages() {
//        if(images==null){
//            images=new ArrayList<>();
//        }
//        return images;
//    }

}
