package com.backend.securityservice.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
    @SequenceGenerator(name = "user_gen", sequenceName = "user_gen")
    @Column(name = "id", nullable = false)
    private Long id;

    private String first_name;

    private String last_name;

    private String location;

    private String email;

    private String phone;

    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id",insertable = false,updatable = false)
    private Role role;

    private Long role_id;
}
