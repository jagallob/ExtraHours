package com.example.extra_hours_amadeus.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "extra_hours")
public class ExtraHour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registry;
    private Long id;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Double diurnal;
    private Double nocturnal;
    private Double diurnalHoliday;
    private Double nocturnalHoliday;
    private Double extrasHours;
    private String observations;

    @Column(nullable = false)
    private boolean approved = false;

}

