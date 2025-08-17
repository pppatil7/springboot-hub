package com.practice.service;

import com.practice.entity.Insurance;
import com.practice.entity.Patient;
import com.practice.repository.InsuranceRepository;
import com.practice.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {


    private final InsuranceRepository insuranceRepository;

    private final PatientRepository patientRepository;


    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId).
                orElseThrow(() -> new EntityNotFoundException("Patient Not found with id: " + patientId));
        patient.setInsurance(insurance);
        insurance.setPatient(patient); //bidirectional consistency maintainance
        return patient;
    }

    @Transactional
    public Patient dissociateInsuranceFromPatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId).
                orElseThrow(() -> new EntityNotFoundException("Patient Not found with id: " + patientId));

        patient.setInsurance(null);
        return patient;
    }


}
