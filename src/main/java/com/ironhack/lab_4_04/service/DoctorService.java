package com.ironhack.lab_4_04.service;

import com.ironhack.lab_4_04.dto.DoctorDTO;
import com.ironhack.lab_4_04.model.Doctor;
import com.ironhack.lab_4_04.model.DoctorStatus;
import com.ironhack.lab_4_04.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    public Doctor create(DoctorDTO doctorDTO) {
        var doctor = new Doctor();
        doctor.setEmployeeId(doctorDTO.getEmployeeId());
        doctor.setDepartment(doctorDTO.getDepartment());
        doctor.setName(doctorDTO.getName());
        doctor.setStatus(doctorDTO.getStatus());
        return doctorRepository.save(doctor);
    }

    public Doctor updateStatus(String id, DoctorStatus status) {
        var doc = doctorRepository.findById(id).get();
        doc.setStatus(status);
        return doctorRepository.save(doc);
    }

    public Doctor updateDepartment(String id, String department) {
        var doc = doctorRepository.findById(id).get();
        doc.setDepartment(department);
        return doctorRepository.save(doc);
    }
}
