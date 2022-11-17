package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_gen")
    @SequenceGenerator(name = "role_gen", sequenceName = "role_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    private String first_name;

    private String last_name;

    private String location;

    private String email;

    private String phone;

    private String password;

    private Role role;

}
