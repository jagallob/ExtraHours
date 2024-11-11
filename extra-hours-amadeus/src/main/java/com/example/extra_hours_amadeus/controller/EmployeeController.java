package com.example.extra_hours_amadeus.controller;

import com.example.extra_hours_amadeus.entity.Employee;
import com.example.extra_hours_amadeus.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PreAuthorize("hasAnyAuthority('manager', 'empleado', 'superusuario')")
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employeeOptional = employeeService.findById(id);
        if (employeeOptional.isPresent()) {
            return new ResponseEntity<>(employeeOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasAnyAuthority('manager', 'empleado', 'superusuario')")
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('manager')")
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('manager')")
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable Long id, @RequestBody Employee employeeDetails) {
        Employee updateEmployee = employeeService.updateEmployee(id, employeeDetails);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('manager')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
