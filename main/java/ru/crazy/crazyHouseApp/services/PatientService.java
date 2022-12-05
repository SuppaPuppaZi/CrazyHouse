package ru.crazy.crazyHouseApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.crazy.crazyHouseApp.models.Patient;
import ru.crazy.crazyHouseApp.repositories.PatientRepository;

import java.util.List;
import java.util.Optional;



@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Optional<Patient> findById(Long id){
        return patientRepository.findById(id);
    }

    public List<Patient> findAll(){
        return patientRepository.findAll();
    }

    public void addPatient(Patient patient){
        Patient addedPatient = patientRepository.save(patient);

    }

    public void deletePatient(long id){
        patientRepository.deleteById(id);
    }

    public Patient getPatientById(Long id) {
       return patientRepository.findById(id).orElse(null);
    }

    public void saveCabinet(Patient patient) {
        patientRepository.save(patient);
    }

    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }

    public void savePatient(Patient patient) {
        patientRepository.save(patient);
    }
}

