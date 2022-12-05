package ru.crazy.crazyHouseApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.crazy.crazyHouseApp.models.Drug;
import ru.crazy.crazyHouseApp.services.DrugService;

import java.util.Optional;


@Controller
@RequestMapping("/drugs")
public class DrugController {

    private final DrugService drugService;

    @Autowired
    public DrugController(DrugService drugService) {
        this.drugService = drugService;
    }

    @GetMapping
    public String getAllDrugs(Model model) {
        model.addAttribute("drugs", drugService.findAll());
        return "drugs";
    }

    @GetMapping("/create")
    public String createDrugForm(Drug drug){
        return "drugs-create";
    }

    @PostMapping("/create")
    public String createDrug(Drug drug){
        drugService.saveDrug(drug);
        return "redirect:/drugs";
    }

    @GetMapping("/delete/{id}")
    public String deleteDrug(@PathVariable(value = "id") Long id){
        drugService.deleteById(id);
        return "redirect:/drugs";
    }

    @GetMapping("/update/{id}")
    public String updateDrugForm(@PathVariable("id") Long id, Model model){
        Optional<Drug> drug = drugService.findById(id);
        model.addAttribute("drug", drug);
        return "drugs-update";
    }

    @PostMapping("/update")
    public String updateDrug(Drug drug){
        drugService.saveDrug(drug);
        return "redirect:/drugs";
    }
}
