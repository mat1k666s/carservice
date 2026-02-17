package ru.car.employee.dto;

import lombok.Data;
import ru.car.api.employee.entity.EmployeeEntity;

@Data
public class EmployeeSkillDto {
    private Integer id;
    private String skillName;
    private String skillCode;
    private String description;
    private Integer experienceYears;
    private String certification;
    private String employeeName;
    private EmployeeEntity employeeId;

}
