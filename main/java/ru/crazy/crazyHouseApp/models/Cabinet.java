package ru.crazy.crazyHouseApp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cabinets")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cabinet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int cabinetNumber;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "cabinet")
    private List<Personal> personal = new ArrayList<>();
}
