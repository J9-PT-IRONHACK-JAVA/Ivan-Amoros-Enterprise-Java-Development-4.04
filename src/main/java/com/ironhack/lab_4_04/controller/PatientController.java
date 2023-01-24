package com.ironhack.lab_4_04.controller;

import com.ironhack.lab_4_04.dto.PatientDTO;
import com.ironhack.lab_4_04.model.DoctorStatus;
import com.ironhack.lab_4_04.model.Patient;
import com.ironhack.lab_4_04.repository.PatientRepository;
import com.ironhack.lab_4_04.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientRepository patientRepository;
    private final PatientService patientService;

    @GetMapping
    @RequestMapping("/all")
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Patient getById(@PathVariable Long id) {
        return patientRepository.findById(id).get();
    }

    @GetMapping
    @RequestMapping("/date-of-birth-between")
    public List<Patient> getByDateOfBirthBetween(@RequestParam LocalDate start, @RequestParam LocalDate end) {
        return patientRepository.findByDateOfBirthBetween(start, end);
    }

    @GetMapping
    @RequestMapping("/department")
    public List<Patient>  getByAdmittedDoctorDepartment(@RequestParam String department) {
        return patientRepository.findByAdmittedBy_DepartmentIs(department);
    }

    @GetMapping
    @RequestMapping("/off")
    public List<Patient>  getByAdmittedDoctorDepartment() {
        return patientRepository.findByAdmittedBy_StatusIs(DoctorStatus.OFF);
    }

    @PostMapping
    @RequestMapping("/create")
    public Patient createPatient(@RequestBody PatientDTO patientDTO) {
        return patientService.create(patientDTO);
    }

    @PutMapping
    @RequestMapping("/update/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody PatientDTO patientDTO) {
        return patientService.update(id, patientDTO);
    }
}
