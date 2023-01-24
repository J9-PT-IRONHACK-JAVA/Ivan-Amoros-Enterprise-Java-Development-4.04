package com.ironhack.lab_4_04.service;

import com.ironhack.lab_4_04.dto.PatientDTO;
import com.ironhack.lab_4_04.model.Patient;
import com.ironhack.lab_4_04.repository.DoctorRepository;
import com.ironhack.lab_4_04.repository.PatientRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    public Patient create(PatientDTO patientDTO) {
        var patient = new Patient();
        patient.setName(patientDTO.getName());
        patient.setDateOfBirth(patientDTO.getDateOfBirth());
        patient.setAdmittedBy(doctorRepository.findById(patientDTO.getAdmittedBy()).get());
        return patientRepository.save(patient);
    }

    public Patient update(Long id, PatientDTO patientDTO) {
        var patient = patientRepository.findById(id).get();
        patient.setName(patientDTO.getName());
        patient.setDateOfBirth(patientDTO.getDateOfBirth());
        patient.setAdmittedBy(doctorRepository.findById(patientDTO.getAdmittedBy()).get());
        return patientRepository.save(patient);
    }
}
