package ru.crazy.crazyHouseApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.crazy.crazyHouseApp.models.MentalIllness;
import ru.crazy.crazyHouseApp.repositories.MentalIllnessRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MentalIllnessService {

    private final MentalIllnessRepository mentalIllnessRepository;

    @Autowired
    public MentalIllnessService(MentalIllnessRepository mentalIllnessRepository) {
        this.mentalIllnessRepository = mentalIllnessRepository;
    }

    public List<MentalIllness> findAll(){
        return mentalIllnessRepository.findAll();
    }

    public void saveMentalIllness(MentalIllness illness) {
        mentalIllnessRepository.save(illness);
    }

    public Optional<MentalIllness> findById(Long id) {
        return mentalIllnessRepository.findById(id);
    }

    public void deleteById(Long id) {
        mentalIllnessRepository.deleteById(id);
    }
}
