package com.example.extra_hours_amadeus.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "managers")
public class Manager {
    @Id
    @Column(name = "manager_id", nullable = false)
    private Long manager_id;
    private String manager_name;
}
