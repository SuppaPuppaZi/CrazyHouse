package ru.crazy.crazyHouseApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.crazy.crazyHouseApp.models.MentalIllness;

public interface MentalIllnessRepository extends JpaRepository<MentalIllness, Long> {
}
