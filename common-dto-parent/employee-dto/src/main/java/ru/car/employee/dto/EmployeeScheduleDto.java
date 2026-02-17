package ru.car.employee.dto;

import lombok.Data;
import ru.car.api.employee.entity.EmployeeEntity;

import java.time.LocalTime;

@Data
public class EmployeeScheduleDto {
    private Integer id;
    private LocalTime startTime;
    private LocalTime endTime;
    private Boolean isWorkingDay;
    private String employeeName;
    private EmployeeEntity employee;
}
