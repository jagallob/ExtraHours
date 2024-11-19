package com.example.extra_hours_amadeus.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeWithUserDTO {
    private Long id;
    private String name;
    private String position;
    private Double salary;
    private String manager;
    private Integer manager_id;
    private String email;
    private String password;
    private String role;
    private String username;
}
