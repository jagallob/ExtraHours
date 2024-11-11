package com.example.extra_hours_amadeus.controller;

import com.example.extra_hours_amadeus.entity.ExtraHoursConfig;
import com.example.extra_hours_amadeus.service.ExtraHoursConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/config")
public class ExtraHoursConfigController {
    private final ExtraHoursConfigService configService;

    @Autowired
    public ExtraHoursConfigController(ExtraHoursConfigService configService) {
        this.configService = configService;
    }

    @GetMapping
    @PreAuthorize("hasRole('SUPERUSUARIO')")
    public ExtraHoursConfig getConfig() {
        return configService.getConfig();
    }

    @PutMapping
    @PreAuthorize("hasRole('SUPERUSUARIO')")
    public ExtraHoursConfig updateConfig(@RequestBody ExtraHoursConfig config) {
        return configService.updateConfig(config);
    }
}
