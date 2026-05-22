package com.springboot.hospitalmanagementsystem.dto;

import com.springboot.hospitalmanagementsystem.entity.type.BloodGroupType;
import lombok.Data;

@Data
public class BloodGroupStats {
    private final BloodGroupType bloodGroupType;
    private final Long count;
}
