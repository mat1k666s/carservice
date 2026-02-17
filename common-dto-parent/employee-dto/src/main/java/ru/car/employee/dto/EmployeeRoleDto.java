package ru.car.employee.dto;

import lombok.Data;


@Data
public class EmployeeRoleDto {
    private Integer id;
    private String name;
    private String description;
    private Integer accessLevel;
    private String code;



}
