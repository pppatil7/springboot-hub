package com.practice;

import com.practice.dto.BloodGroupStats;
import com.practice.dto.CPatientInfo;
import com.practice.dto.IPatientInfo;
import com.practice.entity.Patient;
import com.practice.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientRepository patientRepository;


    @Test
    public void testPatient() {
//        List<IPatientInfo> patientList = patientRepository.getAllPatientsInfo();
//        List<CPatientInfo> patientList = patientRepository.getAllPatientsInfoConcrete();
//        List<BloodGroupStats> patientList = patientRepository.getBloodGroupStats();
//
//        for (var p : patientList) {
//            System.out.println(p);
//        }

        int rowAffected = patientRepository.updatePatientNameWithId("Ankit Sharma", 1L);
        System.out.println(rowAffected);

    }


}
