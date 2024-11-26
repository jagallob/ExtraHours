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


    @ManyToOne
    @JoinColumn(name = "manager_id", insertable = true, updatable = true)
    private Manager manager;

    public Employee(Long id, String name, String position, Double salary,  Manager manager) {

        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.manager = manager;
    }

    public Employee() {}

}