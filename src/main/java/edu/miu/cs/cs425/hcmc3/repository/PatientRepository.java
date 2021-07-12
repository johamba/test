package edu.miu.cs.cs425.hcmc3.repository;

import edu.miu.cs.cs425.hcmc3.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

}
