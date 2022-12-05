package ru.crazy.crazyHouseApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.crazy.crazyHouseApp.models.Chamber;
import ru.crazy.crazyHouseApp.services.ChamberService;

import java.util.Optional;


@Controller
@RequestMapping("/chambers")
public class ChamberController {

    private final ChamberService chamberService;

    @Autowired
    public ChamberController(ChamberService chamberService) {
        this.chamberService = chamberService;
    }

    @GetMapping
    public String getAllChambers(Model model) {
        model.addAttribute("chambers", chamberService.findAll());
        return "chambers";
    }

    @GetMapping("/create")
    public String createChamberForm(Chamber chamber){
        return "chambers-create";
    }

    @PostMapping("/create")
    public String createChamber(Chamber chamber){
        chamberService.saveChamber(chamber);
        return "redirect:/chambers";
    }

    @GetMapping("/delete/{id}")
    public String deleteChamber(@PathVariable(value = "id") Long id){
        chamberService.deleteById(id);
        return "redirect:/chambers";
    }

    @GetMapping("/update/{id}")
    public String updateChambersForm(@PathVariable(value = "id") Long id, Model model){
        Optional<Chamber> chamber = chamberService.findById(id);
        model.addAttribute("chamber", chamber);
        return "chambers-update";
    }

    @PostMapping("/update")
    public String updateChamber(Chamber chamber){
        chamberService.saveChamber(chamber);
        return "redirect:/chambers";
    }

}
