package com.example.extra_hours_amadeus.controller;

import com.example.extra_hours_amadeus.entity.ExtraHour;
import com.example.extra_hours_amadeus.repository.ExtraHourRepository;
import com.example.extra_hours_amadeus.service.ExtraHourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/extra-hour")
public class ExtraHourController {

    @Autowired
    private ExtraHourService extraHourService;

    @GetMapping("/id/{id}")
    public ResponseEntity<List<ExtraHour>> getExtraHoursById(@PathVariable("id") long id) {
        List<ExtraHour> extraHours = extraHourService.findExtraHoursById(id);

        if (extraHours == null) {
            extraHours = new ArrayList<>(); // Inicializar como lista vacía si es null
        }

        return ResponseEntity.ok(extraHours);
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<ExtraHour>> getExtraHoursByDateRange(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate) {
        if (startDate == null || endDate == null) {
            return ResponseEntity.status(400).body(null);
        } LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        List<ExtraHour> extraHours = extraHourService.findByDateRange(start, end);
        if (extraHours.isEmpty()) { return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.ok(extraHours);
        }
        }

    @Autowired
    private ExtraHourRepository extraHourRepository;

    @PostMapping
    public ResponseEntity<ExtraHour> createExtraHour(@RequestBody ExtraHour extraHour) {
        ExtraHour savedExtraHour = extraHourRepository.save(extraHour);
        return ResponseEntity.ok(savedExtraHour);
    }

    @GetMapping
    public List<ExtraHour> getAllExtraHours() {
        return extraHourRepository.findAll();
    }

    @PatchMapping("/{registry}/approve")
    @PreAuthorize("hasAnyRole('MANAGER', 'SUPERUSERIO')")
    public ResponseEntity<ExtraHour> approveExtraHour(@PathVariable Long registry) {
        Optional<ExtraHour> extraHourOptional = extraHourRepository.findById(registry);
        if (extraHourOptional.isPresent()) {
            ExtraHour extraHour = extraHourOptional.get();
            extraHour.setApproved(true);
            ExtraHour updatedExtraHour = extraHourRepository.save(extraHour);
            return ResponseEntity.ok(updatedExtraHour);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{registry}")
    @PreAuthorize("hasAnyRole('MANAGER', 'SUPERUSERIO')")
    public ResponseEntity<Void> deleteExtraHour(@PathVariable Long registry) {
        if (extraHourRepository.existsById(registry)) {
            extraHourRepository.deleteById(registry);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

