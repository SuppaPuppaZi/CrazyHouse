package ru.crazy.crazyHouseApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.crazy.crazyHouseApp.models.Cabinet;
import ru.crazy.crazyHouseApp.services.CabinetService;

import java.util.Optional;


@Controller
@RequestMapping("/cabinets")
public class CabinetController {

    private final CabinetService cabinetService;

    @Autowired
    public CabinetController(CabinetService cabinetService) {
        this.cabinetService = cabinetService;
    }

    @GetMapping
    public String getAllCabinets(Model model) {
        model.addAttribute("cabinets", cabinetService.findAll());
        return "cabinets";
    }

    @GetMapping("/create")
    public String createCabinetForm(Cabinet cabinet){
        return "cabinets-create";
    }

    @PostMapping("/create")
    public String createCabinet(Cabinet cabinet){
        cabinetService.saveCabinet(cabinet);
        return "redirect:/cabinets";
    }

    @GetMapping("/delete/{id}")
    public String deleteCabinet(@PathVariable(value = "id") Long id){
        cabinetService.deleteById(id);
        return "redirect:/cabinets";
    }

    @GetMapping("/update/{id}")
    public String updateCabinetForm(@PathVariable("id") Long id, Model model){
        Optional<Cabinet> cabinet = cabinetService.findById(id);
        model.addAttribute("cabinet", cabinet);
        return "cabinets-update";
    }

    @PostMapping("/update")
    public String updateCabinet(Cabinet cabinet){
        cabinetService.saveCabinet(cabinet);
        return "redirect:/cabinets";
    }

}
