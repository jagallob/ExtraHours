package com.example.extra_hours_amadeus.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "managers")
public class Manager {
    @Id
    @Column(name = "manager_id", nullable = false)
    private int managerId;
    private String manager;

    public Manager(int manager_id, String manager) {
        this.managerId = managerId;
        this.manager = manager;
    }

    public Manager() {}
}
