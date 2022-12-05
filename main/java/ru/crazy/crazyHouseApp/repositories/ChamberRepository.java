package ru.crazy.crazyHouseApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.crazy.crazyHouseApp.models.Chamber;

public interface ChamberRepository extends JpaRepository<Chamber, Long> {
}
