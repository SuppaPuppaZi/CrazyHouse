package ru.crazy.crazyHouseApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.crazy.crazyHouseApp.models.MentalIllness;
import ru.crazy.crazyHouseApp.services.MentalIllnessService;

import java.util.Optional;

@Controller
@RequestMapping("/mental_illness")
public class MentalIllnessController {

    private final MentalIllnessService mentalIllnessService;

    @Autowired
    public MentalIllnessController(MentalIllnessService mentalIllnessService) {
        this.mentalIllnessService = mentalIllnessService;
    }

    @GetMapping
    public String getAllMentalIllness(Model model) {
        model.addAttribute("illness", mentalIllnessService.findAll());
        return "mental_illness";
    }

    @GetMapping("/create")
    public String createMentalIllnessForm(MentalIllness illness){
        return "mental_illness-create";
    }

    @PostMapping("/create")
    public String createMentalIllness(MentalIllness illness){
        mentalIllnessService.saveMentalIllness(illness);
        return "redirect:/mental_illness";
    }

    @GetMapping("/delete/{id}")
    public String deleteMentalIllness(@PathVariable(value = "id") Long id){
        mentalIllnessService.deleteById(id);
        return "redirect:/mental_illness";
    }

    @GetMapping("/update/{id}")
    public String updateMentalIllness(@PathVariable("id") Long id, Model model){
        Optional<MentalIllness> illness = mentalIllnessService.findById(id);
        model.addAttribute("illness", illness);
        return "mental_illness-update";
    }

    @PostMapping("/update")
    public String updateMentalIllness(MentalIllness illness){
        mentalIllnessService.saveMentalIllness(illness);
        return "redirect:/mental_illness";
    }
}
