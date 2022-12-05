package ru.crazy.crazyHouseApp.controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.crazy.crazyHouseApp.models.Patient;
import ru.crazy.crazyHouseApp.services.PatientService;

import java.util.Optional;


@Controller
@RequestMapping("/patients")
public class PatientController {


    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public String getAllPatients(Model model) {
        model.addAttribute("patients", patientService.findAll());
        return "patients";
    }

    @GetMapping("/create")
    public String createPatientForm(Patient patient) {
        return "patients-create";
    }

    @PostMapping("/create")
    public String createPatient(Patient patient) {
        patientService.savePatient(patient);
        return "redirect:/patients";
    }

    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable(value = "id") Long id) {
        patientService.deleteById(id);
        return "redirect:/patients";
    }

    @GetMapping("/update/{id}")
    public String updatePatientForm(@PathVariable("id") Long id, Model model) {
        Optional<Patient> patient = patientService.findById(id);
        model.addAttribute("patient", patient);
        return "patients-update";
    }

    @PostMapping("/update")
    public String updatePatient(Patient patient) {
        patientService.saveCabinet(patient);
        return "redirect:/patients";
    }
}
