package com.ironhack.lab_4_04.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class PatientDTO {

    private String name;
    private LocalDate dateOfBirth;
    private String admittedBy;
}
