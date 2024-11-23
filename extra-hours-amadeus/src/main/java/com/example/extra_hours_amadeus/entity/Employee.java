package com.example.extra_hours_amadeus.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String position;
    private Double salary;
    private String manager;
    private int manager_id;

    public Employee(Long id, String name, String position, Double salary, String manager, Integer manager_id) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.manager = manager;
        this.manager_id = manager_id;
    }

    public Employee() {}

}