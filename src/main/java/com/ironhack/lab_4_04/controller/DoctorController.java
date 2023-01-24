package com.ironhack.lab_4_04.controller;

import com.ironhack.lab_4_04.dto.DoctorDTO;
import com.ironhack.lab_4_04.model.Doctor;
import com.ironhack.lab_4_04.model.DoctorStatus;
import com.ironhack.lab_4_04.repository.DoctorRepository;
import com.ironhack.lab_4_04.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorRepository doctorRepository;
    private final DoctorService doctorService;

    @GetMapping
    @RequestMapping("/all")
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Doctor getById(@PathVariable String id) {
        return doctorRepository.findById(id).get();
    }

    @GetMapping
    @RequestMapping("/status")
    public List<Doctor> getByStatus(@RequestParam DoctorStatus status) {
        return doctorRepository.findDoctorByStatusIs(status);
    }

    @GetMapping
    @RequestMapping("/department")
    public List<Doctor> getByDepartment(@RequestParam String department) {
        return doctorRepository.findDoctorByDepartmentIs(department);
    }

    @PostMapping
    @RequestMapping("/create")
    public Doctor create(@RequestBody DoctorDTO doctorDTO) {
        return doctorService.create(doctorDTO);
    }

    @PatchMapping
    @RequestMapping("/{id}/update-status")
    public Doctor updateStatus(@PathVariable String id, @RequestParam DoctorStatus status) {
        return doctorService.updateStatus(id, status);
    }

    @PatchMapping
    @RequestMapping("/{id}/update-department")
    public Doctor updateDepartment(@PathVariable String id, @RequestParam String department) {
        return doctorService.updateDepartment(id, department);
    }
}
