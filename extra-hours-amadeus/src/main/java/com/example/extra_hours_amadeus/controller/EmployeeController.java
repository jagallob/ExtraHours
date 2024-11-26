package com.example.extra_hours_amadeus.controller;

import com.example.extra_hours_amadeus.dto.EmployeeWithUserDTO;
import com.example.extra_hours_amadeus.dto.UpdateEmployeeDTO;
import com.example.extra_hours_amadeus.entity.Employee;
import com.example.extra_hours_amadeus.entity.Manager;
import com.example.extra_hours_amadeus.entity.Users;
import com.example.extra_hours_amadeus.repository.ManagerRepository;
import com.example.extra_hours_amadeus.repository.UsersRepo;
import com.example.extra_hours_amadeus.service.EmployeeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private ManagerRepository managerRepository;



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

    @PostMapping
    @Transactional
    public ResponseEntity<Map<String, String>> addEmployee(@RequestBody EmployeeWithUserDTO dto) {
        if (dto.getManager_id() == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Manager ID es requerido"));
        }
        try {
            Optional<Manager> optionalManager = managerRepository.findById(dto.getManager_id());
            if (optionalManager.isEmpty()) {
                return ResponseEntity.badRequest().body(Map.of("error", "Manager no encontrado con el ID proporcionado"));
            }
            Manager manager = optionalManager.get();

            Employee employee = new Employee(
                    dto.getId(),
                    dto.getName(),
                    dto.getPosition(),
                    dto.getSalary(),
                    manager
            );

            employeeService.addEmployee(employee);

            String email = dto.getName().toLowerCase().replace(" ", ".") + "@empresa.com";
            String username = dto.getName().toLowerCase().replace(" ", ".");
            String encodedPassword = passwordEncoder.encode("password123");

            Users user = new Users(
                    dto.getId(), // ID del usuario es el mismo que el del empleado
                    email,
                    dto.getName(),
                    encodedPassword,
                    dto.getRole() != null ? dto.getRole() : "empleado",
                    username
            );

            usersRepo.save(user);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(Map.of("message", "Empleado y usuario agregados exitosamente"));
        } catch (Exception e) {
            // Captura errores inesperados y los devuelve en JSON
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Error al agregar empleado", "details", e.getMessage()));
        }
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateEmployee(@PathVariable("id") Long id, @RequestBody UpdateEmployeeDTO dto) {

        if (dto.getManager_id() == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Manager ID es requerido"));
        }

        try {

            Employee updatedEmployee = employeeService.updateEmployee(id, dto);

            if (updatedEmployee == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Empleado no encontrado"));
            }

            Map<String, String> response = new HashMap<>();
            response.put("message", "Empleado actualizado correctamente");
            response.put("manager_id", String.valueOf(updatedEmployee.getManager().getId()));
            response.put("manager_name", updatedEmployee.getManager().getManager_name());

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", "Error al actualizar el empleado", "details", e.getMessage()));
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
