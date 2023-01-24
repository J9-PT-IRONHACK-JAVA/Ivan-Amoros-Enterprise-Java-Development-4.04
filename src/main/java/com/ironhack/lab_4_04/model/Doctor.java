package com.ironhack.lab_4_04.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Doctor {

    @Id
    private String employeeId;
    private String department;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private DoctorStatus status;

    public Doctor(String employeeId, String department, String name, DoctorStatus status) {
        this.employeeId = employeeId;
        this.department = department;
        this.name = name;
        this.status = status;
    }
}
