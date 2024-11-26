package com.example.extra_hours_amadeus.repository;

import com.example.extra_hours_amadeus.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByManager_Id(Long managerId);
}
