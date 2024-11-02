package com.example.extra_hours_amadeus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalTime;

@Entity
@Table(name = "extra_hours_config")
public class ExtraHoursConfig {

    @Id
    private Long id = 1L; // Mantener un solo registro con un id fijo
    private double diurnalMultiplier;
    private double nocturnalMultiplier;
    private double diurnalHolidayMultiplier;
    private double nocturnalHolidayMultiplier;
    private LocalTime diurnalStart;
    private LocalTime diurnalEnd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getDiurnalMultiplier() {
        return diurnalMultiplier;
    }

    public void setDiurnalMultiplier(double diurnalMultiplier) {
        this.diurnalMultiplier = diurnalMultiplier;
    }

    public double getNocturnalMultiplier() {
        return nocturnalMultiplier;
    }

    public void setNocturnalMultiplier(double nocturnalMultiplier) {
        this.nocturnalMultiplier = nocturnalMultiplier;
    }

    public double getDiurnalHolidayMultiplier() {
        return diurnalHolidayMultiplier;
    }

    public void setDiurnalHolidayMultiplier(double diurnalHolidayMultiplier) {
        this.diurnalHolidayMultiplier = diurnalHolidayMultiplier;
    }

    public double getNocturnalHolidayMultiplier() {
        return nocturnalHolidayMultiplier;
    }

    public void setNocturnalHolidayMultiplier(double nocturnalHolidayMultiplier) {
        this.nocturnalHolidayMultiplier = nocturnalHolidayMultiplier;
    }

    public LocalTime getDiurnalStart() {
        return diurnalStart;
    }

    public void setDiurnalStart(LocalTime diurnalStart) {
        this.diurnalStart = diurnalStart;
    }

    public LocalTime getDiurnalEnd() {
        return diurnalEnd;
    }

    public void setDiurnalEnd(LocalTime diurnalEnd) {
        this.diurnalEnd = diurnalEnd;
    }
}
