package tn.esprit.pockerplanning.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Evenement {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idEvent;
    private String address;
    private String description;
    private Date eventDate;
    private String name;
    private Long nbPlace;
    private String image;
    private Long price;
    private Long hour;
    private int rating;





}
