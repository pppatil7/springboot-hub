package com.practice.dto;

import com.practice.entity.type.BloodGroupType;
import lombok.Data;

@Data
public class BloodGroupStats {

    private final BloodGroupType bloodGroupType;

    private final Long count;
}
