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


    @ManyToOne
    @JoinColumn(name = "ville_id",updatable = false,insertable = false)
    private Ville ville;

    private Long ville_id;

    @OneToMany(mappedBy = "pitch",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PitchImage> images;

    @OneToMany(mappedBy = "pitch",fetch = FetchType.EAGER,orphanRemoval = true)
    private List<PitchRate> pitchRates;


//    public List<PitchImage> getImages() {
//        if(images==null){
//            images=new ArrayList<>();
//        }
//        return images;
//    }


}
