package ru.car.api.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.car.api.employee.entity.EmployeeEntity;
import ru.car.api.employee.entity.EmployeeSkillEntity;


import java.util.List;

public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkillEntity, Integer> , JpaSpecificationExecutor<EmployeeSkillEntity> {

    List<EmployeeSkillEntity> findByEmployeeId(EmployeeEntity employeeId);

    List<EmployeeSkillEntity> findBySkillCode(String skillCode);
}
