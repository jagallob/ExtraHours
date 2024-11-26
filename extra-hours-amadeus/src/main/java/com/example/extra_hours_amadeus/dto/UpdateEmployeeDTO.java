package com.example.extra_hours_amadeus.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateEmployeeDTO {
    private String name;
    private String position;
    private Double salary;
    private Long manager_id;
    private String manager_name;
}
