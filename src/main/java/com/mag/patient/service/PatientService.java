package com.mag.patient.service;

import com.mag.patient.dto.PatientResponseDTO;
import com.mag.patient.mapper.PatientMapper;
import com.mag.patient.model.Patient;
import com.mag.patient.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getPatient() {
        List<Patient> patients = patientRepository.findAll();
        List<PatientResponseDTO> patientResponseDTOS = patients.stream()
                .map(patient -> new PatientMapper().toDTO(patient)).collect(Collectors.toList());
        return patientResponseDTOS;
    }
}
