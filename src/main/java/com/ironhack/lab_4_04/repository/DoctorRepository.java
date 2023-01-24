package com.ironhack.lab_4_04.repository;

import com.ironhack.lab_4_04.model.Doctor;
import com.ironhack.lab_4_04.model.DoctorStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, String> {

    public List<Doctor> findDoctorByStatusIs(DoctorStatus status);

    public List<Doctor> findDoctorByDepartmentIs(String department);
}
