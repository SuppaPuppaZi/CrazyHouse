package ru.crazy.crazyHouseApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.crazy.crazyHouseApp.models.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
