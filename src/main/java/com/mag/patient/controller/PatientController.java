package com.mag.patient.controller;

import com.mag.patient.dto.PatientResponseDTO;
import com.mag.patient.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> getPatient() {
        List<PatientResponseDTO> patientResponseDTOS = patientService.getPatient();
        return ResponseEntity.ok().body(patientResponseDTOS);
    }
}
