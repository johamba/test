package edu.miu.cs.cs425.hcmc3.service.impl;

import edu.miu.cs.cs425.hcmc3.model.Patient;
import edu.miu.cs.cs425.hcmc3.repository.PatientRepository;
import edu.miu.cs.cs425.hcmc3.service.PatientService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {
    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> getPatients() {
        return patientRepository.findAll(Sort.by("fullName"));
    }

    @Override
    public List<Patient> getElderlyPatients() {
        return patientRepository.findAll().stream()
                .filter(p -> (LocalDate.now().getYear() - p.getDateOfBirth().getYear()) >= 65)
                .filter(p -> !((LocalDate.now().getYear() - p.getDateOfBirth().getYear()) == 65
                        && LocalDate.now().getMonthValue() >= p.getDateOfBirth().getMonthValue()))
                .filter(p -> !((LocalDate.now().getYear() - p.getDateOfBirth().getYear()) == 65
                        && LocalDate.now().getMonthValue() == p.getDateOfBirth().getMonthValue()
                        && LocalDate.now().getDayOfMonth() < p.getDateOfBirth().getDayOfMonth()))
                .sorted(Comparator.comparing(Patient::getDateOfBirth))
                .collect(Collectors.toList());
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient getPatientById(Long patientId) {
        return patientRepository.findById(patientId).orElse(null);
    }

    @Override
    public void deletePatientById(Long patientId) {
        patientRepository.deleteById(patientId);
    }

}
