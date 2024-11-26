package com.example.extra_hours_amadeus.service;

import com.example.extra_hours_amadeus.dto.UpdateEmployeeDTO;
import com.example.extra_hours_amadeus.entity.Employee;
import com.example.extra_hours_amadeus.entity.Manager;
import com.example.extra_hours_amadeus.repository.EmployeeRepository;
import com.example.extra_hours_amadeus.repository.ExtraHourRepository;
import com.example.extra_hours_amadeus.repository.ManagerRepository;
import com.example.extra_hours_amadeus.repository.UsersRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ManagerRepository managerRepository;
    private final UsersRepo usersRepo;
    private final ExtraHourRepository extraHourRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, ManagerRepository managerRepository, UsersRepo usersRepo, ExtraHourRepository extraHourRepository) {
        this.employeeRepository = employeeRepository;
        this.managerRepository = managerRepository;
        this.usersRepo = usersRepo;
        this.extraHourRepository = extraHourRepository;
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

    @Transactional
    public Employee updateEmployee(Long id, UpdateEmployeeDTO dto) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setName(dto.getName());
            employee.setPosition(dto.getPosition());
            employee.setSalary(dto.getSalary());

            Optional<Manager> optionalManager = managerRepository.findById(dto.getManager_id());
            if (optionalManager.isPresent()) {
                Manager manager = optionalManager.get();
                employee.setManager(manager);


            } else {
                throw new RuntimeException("Manager no encontrado con el ID proporcionado");
            }

            return employeeRepository.save(employee);
        } else {
            throw new RuntimeException("Empleado no encontrado");
        }
    }

    @Transactional
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Empleado no encontrado"));
        usersRepo.deleteById(employee.getId());
        employeeRepository.deleteById(id);
        extraHourRepository.deleteById(id);
    }

}
