package ru.crazy.crazyHouseApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.crazy.crazyHouseApp.models.Personal;
import ru.crazy.crazyHouseApp.services.PersonalService;

import java.util.Optional;

@Controller
@RequestMapping("/personal")
public class PersonalController {

    private final PersonalService personalService;

    @Autowired
    public PersonalController(PersonalService personalService) {
        this.personalService = personalService;
    }

    @GetMapping
    public String getAllPersonal(Model model) {
        model.addAttribute("personal", personalService.findAll());
        return "personal";
    }

    @GetMapping("/create")
    public String createPersonalForm(Personal personal){
        return "personal-create";
    }

    @PostMapping("/create")
    public String createPersonal(Personal personal){
        personalService.savePersonal(personal);
        return "redirect:/personal";
    }

    @GetMapping("/delete/{id}")
    public String deletePersonal(@PathVariable(value = "id") Long id){
        personalService.deleteById(id);
        return "redirect:/personal";
    }

    @GetMapping("/update/{id}")
    public String updatePersonalForm(@PathVariable("id") Long id, Model model){
        Optional<Personal> personal = personalService.findById(id);
        model.addAttribute("personal", personal);
        return "personal-update";
    }

    @PostMapping("/update")
    public String updatePersonal(Personal personal){
        personalService.savePersonal(personal);
        return "redirect:/personal";
    }
}
