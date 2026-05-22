package com.springboot.hospitalmanagementsystem.service;

import com.springboot.hospitalmanagementsystem.entity.Appointment;
import com.springboot.hospitalmanagementsystem.entity.Doctor;
import com.springboot.hospitalmanagementsystem.entity.Patient;
import com.springboot.hospitalmanagementsystem.repositories.AppointmentRepository;
import com.springboot.hospitalmanagementsystem.repositories.DoctorRepository;
import com.springboot.hospitalmanagementsystem.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment, Long patientId, Long doctorId){
        Patient patient= patientRepository.findById(patientId).orElseThrow();
        Doctor doctor=doctorRepository.findById(doctorId).orElseThrow();

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        appointmentRepository.save(appointment);

        return appointment;
    }
}
