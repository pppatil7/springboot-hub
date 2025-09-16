package com.practice;

import com.practice.entity.Appointment;
import com.practice.entity.Insurance;
import com.practice.service.AppointmentService;
import com.practice.service.InsuranceService;
import com.practice.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTests {


    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientService patientService;

    @Test
    public void testAssignInsuranceToPatient() {
        Insurance insurance = Insurance.builder()
                .provider("HDFC Ergo")
                .policyNumber("HDFC_12F")
                .validUntil(LocalDate.of(2028, 1, 1))
                .build();
        var updatedInsurance = insuranceService.assignInsuranceToPatient(insurance, 1L);
        System.out.println(updatedInsurance);
        patientService.deletePatient(1L);
    }

    @Test
    public void testCreateAppointment() {
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025, 9, 16, 16, 0, 0))
                .reason("Cold")
                .build();
        var updatedAppointment = appointmentService.createNewAppointment(appointment, 2L, 4L);
        System.out.println(updatedAppointment);
        patientService.deletePatient(2L);
    }


}
