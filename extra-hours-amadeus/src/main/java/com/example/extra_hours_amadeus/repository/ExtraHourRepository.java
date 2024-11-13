package com.example.extra_hours_amadeus.repository;

import com.example.extra_hours_amadeus.entity.ExtraHour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExtraHourRepository extends JpaRepository<ExtraHour, Long> {
    List<ExtraHour> findById(long id); // Busca todos los registros por el ID del empleado
}
