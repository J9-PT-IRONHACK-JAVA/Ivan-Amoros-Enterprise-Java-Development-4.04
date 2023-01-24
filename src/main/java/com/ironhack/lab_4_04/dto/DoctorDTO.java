package com.ironhack.lab_4_04.dto;

import com.ironhack.lab_4_04.model.DoctorStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DoctorDTO {

    private String employeeId;
    private String department;
    private String name;
    private DoctorStatus status;
}
