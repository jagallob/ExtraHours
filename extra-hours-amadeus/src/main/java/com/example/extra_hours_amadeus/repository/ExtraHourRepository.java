package com.example.extra_hours_amadeus.repository;

import com.example.extra_hours_amadeus.entity.ExtraHour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ExtraHourRepository extends JpaRepository<ExtraHour, Long> {
    List<ExtraHour> findExtraHoursById(long id); // Busca todos los registros por el ID del empleado
    List<ExtraHour> findByDateBetween(LocalDate startDate, LocalDate endDate);
    Optional<ExtraHour> findByRegistry(int registry);
}


