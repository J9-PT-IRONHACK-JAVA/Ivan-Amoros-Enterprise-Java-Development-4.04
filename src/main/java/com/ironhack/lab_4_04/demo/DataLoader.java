package com.ironhack.lab_4_04.demo;

import com.ironhack.lab_4_04.model.Doctor;
import com.ironhack.lab_4_04.model.Patient;
import com.ironhack.lab_4_04.repository.DoctorRepository;
import com.ironhack.lab_4_04.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static com.ironhack.lab_4_04.model.DoctorStatus.*;

@RequiredArgsConstructor
@Component
@Profile("load-data")
public class DataLoader {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void oadData() {
        var doc1 = new Doctor("356712", "cardiology", "Alonso Flores", ON_CALL);
        doctorRepository.save(doc1);

        var doc2 = new Doctor("564134", "immunology", "Sam Ortega",	ON);
        doctorRepository.save(doc2);

        var doc3 = new Doctor("761527", "cardiology", "German Ruiz", OFF);
        doctorRepository.save(doc3);

        var doc4 = new Doctor("166552", "pulmonary", "Maria Lin", ON);
        doctorRepository.save(doc4);

        var doc5 = new Doctor("156545", "orthopaedic", "Paolo Rodriguez", ON_CALL);
        doctorRepository.save(doc5);

        var doc6 = new Doctor("172456", "psychiatric", "John Paul Armes", OFF);
        doctorRepository.save(doc6);

        var pat1 = new Patient("Jaime Jordan", LocalDate.of(1984, 03, 02), doctorRepository.findById("564134").get());
        patientRepository.save(pat1);

        var pat2 = new Patient("Marian Garcia", LocalDate.of(1972, 01, 12), doctorRepository.findById("564134").get());
        patientRepository.save(pat2);

        var pat3 = new Patient("Julia Dusterdieck", LocalDate.of(1954, 06, 11), doctorRepository.findById("356712").get());
        patientRepository.save(pat3);

        var pat4 = new Patient("Steve McDuck", LocalDate.of(1931, 11, 10), doctorRepository.findById("761527").get());
        patientRepository.save(pat4);

        var pat5 = new Patient("Marian Garcia", LocalDate.of(1999, 02, 15), doctorRepository.findById("172456").get());
        patientRepository.save(pat5);
    }
}
