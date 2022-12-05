package ru.crazy.crazyHouseApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.crazy.crazyHouseApp.models.Drug;

public interface DrugRepository extends JpaRepository<Drug, Long> {
}
