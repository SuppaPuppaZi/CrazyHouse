package ru.crazy.crazyHouseApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.crazy.crazyHouseApp.models.Personal;
import ru.crazy.crazyHouseApp.repositories.PersonalRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalService {

    private final PersonalRepository personalRepository;

    @Autowired
    public PersonalService(PersonalRepository personalRepository) {
        this.personalRepository = personalRepository;
    }

    public List<Personal> findAll(){
        return personalRepository.findAll();
    }
    public void createPersonal(Personal personal){
        personalRepository.save(personal);
    }

    public Optional<Personal> findById(Long id) {
        return personalRepository.findById(id);
    }

    public boolean existById(Long id) {
        return personalRepository.existsById(id);
    }

    public void savePersonal(Personal personal) {
        personalRepository.save(personal);
    }

    public void deleteById(Long id) {
        personalRepository.deleteById(id);
    }

}
