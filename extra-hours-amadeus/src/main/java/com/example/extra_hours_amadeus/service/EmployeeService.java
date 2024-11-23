package com.example.extra_hours_amadeus.service;

import com.example.extra_hours_amadeus.entity.Employee;
import com.example.extra_hours_amadeus.repository.EmployeeRepository;
import com.example.extra_hours_amadeus.repository.UsersRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UsersRepo usersRepo;

    public EmployeeService(EmployeeRepository employeeRepository, UsersRepo usersRepo) {
        this.employeeRepository = employeeRepository;
        this.usersRepo = usersRepo;
    }

    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();

            employee.setName(employeeDetails.getName());
            employee.setPosition(employeeDetails.getPosition());
            employee.setSalary(employeeDetails.getSalary());
            employee.setManager_id(employeeDetails.getManager_id());
            employee.setManager(employeeDetails.getManager());

            return employeeRepository.save(employee);
        } else {
            return null;
        }
    }

    @Transactional
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Empleado no encontrado"));
        employeeRepository.deleteById(id);
        usersRepo.deleteById(employee.getId());
    }

}
