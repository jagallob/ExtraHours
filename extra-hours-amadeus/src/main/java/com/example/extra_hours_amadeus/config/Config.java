package com.example.extra_hours_amadeus.config;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Config {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double diurnalMultiplier;
    private double nocturnalMultiplier;
    private double diurnalHolidayMultiplier;
    private double nocturnalHolidayMultiplier;
    private int diurnalStart;
    private int diurnalEnd;

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

    public int getDiurnalStart() {
        return diurnalStart;
    }

    public void setDiurnalStart(int diurnalStart) {
        this.diurnalStart = diurnalStart;
    }

    public int getDiurnalEnd() {
        return diurnalEnd;
    }

    public void setDiurnalEnd(int diurnalEnd) {
        this.diurnalEnd = diurnalEnd;
    }
}
