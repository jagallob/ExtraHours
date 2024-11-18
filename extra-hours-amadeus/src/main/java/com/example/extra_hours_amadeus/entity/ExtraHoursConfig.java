package com.example.extra_hours_amadeus.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalTime;

@Data
@Entity
@Table(name = "extra_hours_config")
public class ExtraHoursConfig {

    @Id
    private Long id = 1L; // Mantener un solo registro con un id fijo
    private double weekly_extra_hours_limit;
    private double diurnal_multiplier;
    private double nocturnal_multiplier;
    private double diurnal_holiday_multiplier;
    private double nocturnal_holiday_multiplier;
    private LocalTime diurnal_start;
    private LocalTime diurnal_end;

}
