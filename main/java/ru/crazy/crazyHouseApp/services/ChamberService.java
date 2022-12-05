package ru.crazy.crazyHouseApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.crazy.crazyHouseApp.models.Chamber;
import ru.crazy.crazyHouseApp.repositories.ChamberRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ChamberService {

    private final ChamberRepository chamberRepository;

    @Autowired
    public ChamberService(ChamberRepository chamberRepository) {
        this.chamberRepository = chamberRepository;
    }

    public List<Chamber> findAll(){
        return chamberRepository.findAll();
    }

    public void saveChamber(Chamber chamber) {
        chamberRepository.save(chamber);
    }

    public void deleteById(Long id) {
        chamberRepository.deleteById(id);
    }

    public Optional<Chamber> findById(Long id) {
        return chamberRepository.findById(id);
    }
}
