package com.example.extra_hours_amadeus.controller;

import com.example.extra_hours_amadeus.entity.ExtraHour;
import com.example.extra_hours_amadeus.repository.ExtraHourRepository;
import com.example.extra_hours_amadeus.service.ExtraHourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/extra-hour")
public class ExtraHourController {

    private final ExtraHourService extraHourService;

    @Autowired
    public ExtraHourController(ExtraHourService extraHourService) {
        this.extraHourService = extraHourService;
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<List<ExtraHour>> getExtraHoursByEmployeeId(@PathVariable long id) {
        List<ExtraHour> extraHours = extraHourService.getExtraHoursByEmployeeId(id);

        if (extraHours.isEmpty()) {
            return ResponseEntity.noContent().build();
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

