package com.example.extra_hours_amadeus.dto;

import com.example.extra_hours_amadeus.entity.Employee;
import com.example.extra_hours_amadeus.entity.ExtraHour;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class ExtraHourWithEmployee {
    private ExtraHour extraHour;
    private Employee employee;

    public ExtraHourWithEmployee(ExtraHour extraHour, Employee employee) {
        this.extraHour = extraHour; this.employee = employee; }
}
