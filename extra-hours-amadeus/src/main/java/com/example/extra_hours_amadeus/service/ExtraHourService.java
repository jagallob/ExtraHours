package com.example.extra_hours_amadeus.service;

import com.example.extra_hours_amadeus.entity.ExtraHour;
import com.example.extra_hours_amadeus.repository.ExtraHourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtraHourService {

    private final ExtraHourRepository extraHourRepository;

    @Autowired
    public ExtraHourService(ExtraHourRepository extraHourRepository) {
        this.extraHourRepository = extraHourRepository;
    }

    public List<ExtraHour> getExtraHoursByEmployeeId(long id) {
        return extraHourRepository.findById(id);
    }
}
