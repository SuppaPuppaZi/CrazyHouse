package ru.crazy.crazyHouseApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.crazy.crazyHouseApp.models.Position;

public interface PositionRepository extends JpaRepository<Position, Long> {
}
