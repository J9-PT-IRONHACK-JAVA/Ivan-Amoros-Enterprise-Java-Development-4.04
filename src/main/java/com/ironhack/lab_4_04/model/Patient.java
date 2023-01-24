package com.ironhack.lab_4_04.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    private String name;
    private LocalDate dateOfBirth;
    @ManyToOne
    @JoinColumn(name = "admitted_by")
    private Doctor admittedBy;

    public Patient(String name, LocalDate dateOfBirth, Doctor admittedBy) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.admittedBy = admittedBy;
    }
}
