package ru.crazy.crazyHouseApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.crazy.crazyHouseApp.models.Personal;

public interface PersonalRepository extends JpaRepository<Personal, Long> {
}
