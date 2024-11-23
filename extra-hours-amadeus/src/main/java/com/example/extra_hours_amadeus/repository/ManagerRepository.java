package com.example.extra_hours_amadeus.repository;

import com.example.extra_hours_amadeus.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
