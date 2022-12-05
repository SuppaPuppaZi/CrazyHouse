package ru.crazy.crazyHouseApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.crazy.crazyHouseApp.models.Position;
import ru.crazy.crazyHouseApp.repositories.PositionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PositionService {

    private final PositionRepository positionRepository;

    @Autowired
    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    public void deleteById(Long id) {
        positionRepository.deleteById(id);
    }

    public Optional<Position> findById(Long id) {
        return positionRepository.findById(id);
    }

    public void savePosition(Position position) {
        positionRepository.save(position);
    }
}

