package com.example.extra_hours_amadeus.service;

import com.example.extra_hours_amadeus.entity.ExtraHour;
import com.example.extra_hours_amadeus.repository.ExtraHourRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ExtraHourService {

    @Autowired
    private  ExtraHourRepository extraHourRepository;


    public List<ExtraHour> findByDateRange(LocalDate startDate, LocalDate endDate) {
        return extraHourRepository.findByDateBetween(startDate, endDate);
    }

    public List<ExtraHour> findExtraHoursById(long id) {
        List<ExtraHour> extraHours = extraHourRepository.findExtraHoursById(id);
        return extraHours != null ? extraHours : new ArrayList<>();
    }

    public Optional<ExtraHour> findByRegistry(Long registry) {
        return extraHourRepository.findByRegistry(registry);
    }

    @Transactional
    public boolean deleteExtraHourByRegistry(Long registry) {
        if (extraHourRepository.existsByRegistry(registry)) {
            extraHourRepository.deleteByRegistry(registry);
            return true;
        }
            return false;
    }
}




