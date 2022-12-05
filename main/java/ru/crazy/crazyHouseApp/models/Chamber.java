package ru.crazy.crazyHouseApp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "chambers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chamber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int chamberNumber;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "chamber")
    private List<Patient> patients = new ArrayList<>();

}
