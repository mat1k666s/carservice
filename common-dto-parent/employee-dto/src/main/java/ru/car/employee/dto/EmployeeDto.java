package ru.car.employee.dto;


import lombok.Data;
import ru.car.api.employee.EmployeeStatus;


import java.time.LocalDate;

@Data
public class EmployeeDto {

    private Integer id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String fullName;
    private String phoneNumber;
    private String email;
    private Integer roleId;
    private LocalDate hireDate;
    private EmployeeStatus status;
}
