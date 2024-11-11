package com.example.extra_hours_amadeus.repository;

import com.example.extra_hours_amadeus.entity.ExtraHour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExtraHourRepository extends JpaRepository<ExtraHour, Long> {
}
