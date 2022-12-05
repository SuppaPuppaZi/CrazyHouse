package ru.crazy.crazyHouseApp.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "patients")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String lastName;
    private String firstName;
    private String middleName;
    private Date dateOfBirth;
    private Date dateOfArrival;
    private char sex;


    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn (name = "chamber_id")
    @ToString.Exclude
    private Chamber chamber;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn (name = "personal_id")
    @ToString.Exclude
    private Personal personal;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn (name = "mental_illness_id")
    private MentalIllness mentalIllness;

}


