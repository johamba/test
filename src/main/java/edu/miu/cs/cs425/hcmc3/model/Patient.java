package edu.miu.cs.cs425.hcmc3.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    @NotNull(message = "patientNumber is required")
    @NotBlank(message = "patient Number can not be blank")
    private String patientNumber;
    @NotNull(message = "fullName is required")
    @NotBlank(message = "fullName can not be blank")
    private String fullName;
    private String emailAddress;
    @NotNull(message = "patientNumber is required")
    @NotBlank(message = "patient Number can not be blank")
    private String contactPhoneNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    @NotNull(message = "patientNumber is required")
    @NotBlank(message = "patient Number can not be blank")
    private String isAnOutPatient;

    public Patient() {
    }

    public Patient(Long patientId, String patientNumber, String fullName, String emailAddress, String contactPhoneNumber,
                   LocalDate dateOfBirth, String isAnOutPatient) {
        this.patientId = patientId;
        this.patientNumber = patientNumber;
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.contactPhoneNumber = contactPhoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.isAnOutPatient = isAnOutPatient;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIsAnOutPatient() {
        return isAnOutPatient;
    }

    public void setIsAnOutPatient(String isAnOutPatient) {
        this.isAnOutPatient = isAnOutPatient;
    }
}
