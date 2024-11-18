package com.example.extra_hours_amadeus.config;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalTime;

@Data
@Entity
public class Config {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double weekly_extra_hours_limit;
    private double diurnal_multiplier;
    private double nocturnal_multiplier;
    private double diurnal_holiday_multiplier;
    private double nocturnal_holiday_multiplier;
    private LocalTime diurnal_start;
    private LocalTime  diurnal_end;

}
