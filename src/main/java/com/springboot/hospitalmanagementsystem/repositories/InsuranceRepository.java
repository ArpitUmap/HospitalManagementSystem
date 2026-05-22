package com.springboot.hospitalmanagementsystem.repositories;

import com.springboot.hospitalmanagementsystem.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}