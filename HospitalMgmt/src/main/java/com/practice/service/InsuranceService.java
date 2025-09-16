package com.practice.service;

import com.practice.entity.Insurance;
import com.practice.entity.Patient;
import com.practice.repository.InsuranceRepository;
import com.practice.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InsuranceService {


    private final InsuranceRepository insuranceRepository;

    private final PatientRepository patientRepository;


    @Transactional
    public Insurance assignInsuranceToPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(insurance);

        insurance.setPatient(patient); //optional
        return insurance;
    }

}
