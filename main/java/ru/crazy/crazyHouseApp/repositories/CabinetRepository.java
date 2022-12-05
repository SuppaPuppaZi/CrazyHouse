package ru.crazy.crazyHouseApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.crazy.crazyHouseApp.models.Cabinet;

public interface CabinetRepository extends JpaRepository<Cabinet, Long> {
}
