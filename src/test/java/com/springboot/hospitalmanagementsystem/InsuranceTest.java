package com.springboot.hospitalmanagementsystem;

import com.springboot.hospitalmanagementsystem.entity.Appointment;
import com.springboot.hospitalmanagementsystem.entity.Insurance;
import com.springboot.hospitalmanagementsystem.service.AppointmentService;
import com.springboot.hospitalmanagementsystem.service.InsuranceService;
import com.springboot.hospitalmanagementsystem.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientService patientService;

    @Test
    public void testAssignInsuranceToPatient(){
        Insurance insurance= Insurance.builder()
                .provider("HDFC Ergo")
                .policyNumber("HDFC_1001")
                .validUntil(LocalDate.of(2030,1,1))
                .build();

        var updatedInsurance= insuranceService.assignInsuranceToPatient(insurance,1L);

        System.out.println(updatedInsurance);

        patientService.deletePatient(1L);
    }

    @Test
    public void testCreateAppointment(){
        Appointment appointment=Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026,7,5,14,55))
                .reason("Cancer")
                .build();

        var updatedAppointment = appointmentService.createNewAppointment(appointment,1L,2L);
        System.out.println(updatedAppointment);

        patientService.deletePatient(1L);
    }


}
