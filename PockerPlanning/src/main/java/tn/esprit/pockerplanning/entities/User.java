package tn.esprit.pockerplanning.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.pockerplanning.entities.enums.Role;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long id;

    String firstname;
    String lastname;
    String email;
    String password;
    String picture;

    @Enumerated(EnumType.STRING)
    Role role;


    @ManyToMany
    Set<Project> projectSet;


    @OneToMany(mappedBy = "user")
    Set<Participation> participationSet;

    @ManyToOne
    Badge badge;



}
