package edu.miu.cs.cs425.hcmc3.service;

import edu.miu.cs.cs425.hcmc3.model.Patient;

import java.util.List;

public interface PatientService {
    public abstract List<Patient> getPatients();
    public abstract List<Patient> getElderlyPatients();
    public abstract Patient savePatient(Patient patient);
    public abstract Patient getPatientById(Long patientId);
    public abstract void deletePatientById(Long patientId);
}