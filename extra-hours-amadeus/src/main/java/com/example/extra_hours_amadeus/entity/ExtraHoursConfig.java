package com.example.extra_hours_amadeus.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalTime;

@Entity
@Table(name = "extra_hours_config")
public class ExtraHoursConfig {

    @Id
    private Long id = 1L; // Mantener un solo registro con un id fijo
    private double diurnal_multiplier;
    private double nocturnal_multiplier;
    private double diurnal_holiday_multiplier;
    private double nocturnal_holiday_multiplier;
    private LocalTime diurnal_start;
    private LocalTime diurnal_end;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getDiurnal_multiplier() {
        return diurnal_multiplier;
    }

    public void setDiurnal_multiplier(double diurnal_multiplier) {
        this.diurnal_multiplier = diurnal_multiplier;
    }

    public double getNocturnal_multiplier() {
        return nocturnal_multiplier;
    }

    public void setNocturnal_multiplier(double nocturnal_multiplier) {
        this.nocturnal_multiplier = nocturnal_multiplier;
    }

    public double getDiurnal_holiday_multiplier() {
        return diurnal_holiday_multiplier;
    }

    public void setDiurnal_holiday_multiplier(double diurnal_holiday_multiplier) {
        this.diurnal_holiday_multiplier = diurnal_holiday_multiplier;
    }

    public double getNocturnal_holiday_multiplier() {
        return nocturnal_holiday_multiplier;
    }

    public void setNocturnal_holiday_multiplier(double nocturnal_holiday_multiplier) {
        this.nocturnal_holiday_multiplier = nocturnal_holiday_multiplier;
    }

    public LocalTime getDiurnal_start() {
        return diurnal_start;
    }

    public void setDiurnal_start(LocalTime diurnal_start) {
        this.diurnal_start = diurnal_start;
    }

    public LocalTime getDiurnal_end() {
        return diurnal_end;
    }

    public void setDiurnal_end(LocalTime diurnal_end) {
        this.diurnal_end = diurnal_end;
    }
}
