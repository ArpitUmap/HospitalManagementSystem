package com.springboot.hospitalmanagementsystem.service;

import com.springboot.hospitalmanagementsystem.entity.Insurance;
import com.springboot.hospitalmanagementsystem.entity.Patient;
import com.springboot.hospitalmanagementsystem.repositories.InsuranceRepository;
import com.springboot.hospitalmanagementsystem.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Insurance assignInsuranceToPatient(Insurance insurance,Long patientId){
        Patient patient= patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(insurance);

        insurance.setPatient(patient);

        return insurance;
    }


}
