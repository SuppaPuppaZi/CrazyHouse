package ru.crazy.crazyHouseApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.crazy.crazyHouseApp.models.Drug;
import ru.crazy.crazyHouseApp.repositories.DrugRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DrugService {

    private final DrugRepository drugRepository;

    @Autowired
    public DrugService(DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }

    public List<Drug> findAll(){
        return drugRepository.findAll();
    }

    public void saveDrug(Drug drug) {
        drugRepository.save(drug);
    }

    public void deleteById(Long id) {
        drugRepository.deleteById(id);
    }

    public Optional<Drug> findById(Long id) {
        return drugRepository.findById(id);
    }
}
