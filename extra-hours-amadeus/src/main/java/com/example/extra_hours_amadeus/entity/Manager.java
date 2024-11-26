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
    private Long id;

    @Column(name = "manager_name", nullable = false)
    private String manager_name;

    public Manager(Long id, String manager_name) {
        this.id = id;
        this.manager_name = manager_name;
    }

    public Manager() {}
}
