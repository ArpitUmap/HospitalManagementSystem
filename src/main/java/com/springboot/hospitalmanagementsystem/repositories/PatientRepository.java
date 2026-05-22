package com.springboot.hospitalmanagementsystem.repositories;

import com.springboot.hospitalmanagementsystem.dto.BloodGroupStats;
import com.springboot.hospitalmanagementsystem.dto.CPatientInfo;
import com.springboot.hospitalmanagementsystem.dto.IPatientInfo;
import com.springboot.hospitalmanagementsystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    @Query(("SELECT p.id as id, p.name  as name, p.email as email FROM Patient p"))
    List<IPatientInfo> getAllPatientsInfo();

    @Query(("SELECT new com.springboot.hospitalmanagementsystem.dto.CPatientInfo(p.id, p.name) FROM Patient p"))
    List<CPatientInfo> getAllPatientsInfoConcrete();

    @Query("SELECT new com.springboot.hospitalmanagementsystem.dto.BloodGroupStats (p.bloodGroup,COUNT(p)) from Patient p GROUP BY p.bloodGroup ORDER BY COUNT(p)")
    List<BloodGroupStats> getBloodGroupStats();

    @Transactional
    @Modifying
    @Query("UPDATE Patient p set p.name= :name where p.id= :id")
    int updatePatientNameWithId(@Param("name")String name,@Param("id")Long id);


}
