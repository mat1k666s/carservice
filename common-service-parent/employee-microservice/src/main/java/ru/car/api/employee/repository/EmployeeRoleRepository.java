package ru.car.api.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.car.api.employee.entity.EmployeeRoleEntity;

import java.util.List;

public interface EmployeeRoleRepository extends JpaRepository<EmployeeRoleEntity, Integer>, JpaSpecificationExecutor<EmployeeRoleEntity> {
    List<EmployeeRoleEntity> findByName(String name);

    List<EmployeeRoleEntity> findByCode(String code);
}
