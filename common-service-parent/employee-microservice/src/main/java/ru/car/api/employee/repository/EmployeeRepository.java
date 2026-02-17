package ru.car.api.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.car.api.employee.entity.EmployeeEntity;
import ru.car.api.employee.EmployeeStatus;


import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>, JpaSpecificationExecutor<EmployeeEntity> {
    List<EmployeeEntity> findByStatus(EmployeeStatus status);

    List<EmployeeEntity> findByRoleId(Integer roleId);

    List<EmployeeEntity> findByHireDateBetween(LocalDate startDate, LocalDate endDate);
}
