package ru.crazy.crazyHouseApp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mental_illness")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MentalIllness {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String mentalIllnessName;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "drug_id")
    @ToString.Exclude
    public Drug drug;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mentalIllness")
    private List<Patient> patients = new ArrayList<>();
}
