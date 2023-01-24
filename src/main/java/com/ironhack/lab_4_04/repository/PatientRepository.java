package com.ironhack.lab_4_04.repository;

import com.ironhack.lab_4_04.model.DoctorStatus;
import com.ironhack.lab_4_04.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    public List<Patient> findByDateOfBirthBetween(LocalDate start, LocalDate end);

    public List<Patient> findByAdmittedBy_DepartmentIs(String department);

    public List<Patient> findByAdmittedBy_StatusIs(DoctorStatus status);
}
