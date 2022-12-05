package ru.crazy.crazyHouseApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.crazy.crazyHouseApp.models.Cabinet;
import ru.crazy.crazyHouseApp.repositories.CabinetRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CabinetService {

    private final CabinetRepository cabinetRepository;

    @Autowired
    public CabinetService(CabinetRepository cabinetRepository) {
        this.cabinetRepository = cabinetRepository;
    }

    public List<Cabinet> findAll(){
        return cabinetRepository.findAll();
    }
    public boolean existById(Long id) {
        return cabinetRepository.existsById(id);
    }

    public void saveCabinet(Cabinet cabinet) {
        cabinetRepository.save(cabinet);
    }

    public void deleteById(Long id) {
        cabinetRepository.deleteById(id);
    }

    public Optional<Cabinet> findById(Long id) {
        return cabinetRepository.findById(id);
    }
//    public Optional<Cabinet> findById(Long id) {
//        return cabinetRepository.findById(id);
//    }
//
//    public void getCabinetDetails(Long id, Model model){
//        Optional<Cabinet> cabinet = findById(id);
//        ArrayList<Cabinet> res = new ArrayList<>();
//        cabinet.ifPresent(res::add);
//        model.addAttribute("cabinets", res);
//    }


}
