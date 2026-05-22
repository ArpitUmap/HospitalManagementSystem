package com.springboot.hospitalmanagementsystem;

import com.springboot.hospitalmanagementsystem.dto.BloodGroupStats;
import com.springboot.hospitalmanagementsystem.dto.CPatientInfo;
import com.springboot.hospitalmanagementsystem.dto.IPatientInfo;
import com.springboot.hospitalmanagementsystem.entity.Patient;
import com.springboot.hospitalmanagementsystem.entity.type.BloodGroupType;
import com.springboot.hospitalmanagementsystem.repositories.PatientRepository;
import com.springboot.hospitalmanagementsystem.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

//    @Test
//    public void testPatient(){
//
////        List<Patient> patientList=patientRepository.findAll();
////        List<CPatientInfo> patientList=patientRepository.getAllPatientsInfoConcrete();
////        List<BloodGroupStats> patientList=patientRepository.getBloodGroupStats();
////
////        for(BloodGroupStats p:patientList){
////            System.out.println(p);
////        }
//
////        int affectedRows=patientRepository.updatePatientNameWithId("Anuj Sharma",1L);
////        System.out.println(affectedRows);
//
//        patientService.testPatientTransaction();
//
//
//    }
}
