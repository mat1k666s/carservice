package ru.car.api.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ru.car.api.employee.entity.EmployeeEntity;
import ru.car.api.employee.entity.EmployeeScheduleEntity;


import java.util.List;

public interface EmployeeScheduleRepository extends JpaRepository<EmployeeScheduleEntity, Integer>, JpaSpecificationExecutor<EmployeeScheduleEntity> {
    List<EmployeeScheduleEntity> findByEmployeeId(EmployeeEntity employeeId);

}
