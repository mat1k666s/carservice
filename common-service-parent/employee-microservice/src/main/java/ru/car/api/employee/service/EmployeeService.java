package ru.car.api.employee.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.car.api.employee.entity.EmployeeEntity;


import ru.car.api.employee.EmployeeStatus;
import ru.car.api.employee.mapper.EmployeeMapper;
import ru.car.api.employee.repository.EmployeeRepository;
import ru.car.employee.dto.EmployeeDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Transactional
    public EmployeeDto getById(Integer id) {
        Optional<EmployeeEntity> entity = employeeRepository.findById(id);
        if (entity.isPresent()) {
            return EmployeeMapper.INSTANCE.toDto(entity.get());
        }
        return null;
    }

    @Transactional
    public EmployeeDto add(EmployeeDto employeeDto) {
        employeeDto.setId(null);
        EmployeeEntity entity = EmployeeMapper.INSTANCE.toEntity(employeeDto);
        entity = employeeRepository.saveAndFlush(entity);
        return EmployeeMapper.INSTANCE.toDto(entity);

    }

    @Transactional
    public EmployeeDto update(EmployeeDto employeeDto) {
        EmployeeEntity entity = EmployeeMapper.INSTANCE.toEntity(employeeDto);
        entity = employeeRepository.saveAndFlush(entity);
        return EmployeeMapper.INSTANCE.toDto(entity);
    }

    @Transactional
    public Integer deleteById(Integer id) {
        employeeRepository.deleteById(id);
        return id;
    }
    @Transactional
    public List<EmployeeDto> findByStatus(EmployeeStatus status ) {
        List<EmployeeEntity> entities = employeeRepository.findByStatus(status);
        return EmployeeMapper.INSTANCE.toDtoList(entities);
    }
    @Transactional
    public List<EmployeeDto> findByRoleId(Integer roleId) {
        List<EmployeeEntity>entities = employeeRepository.findByRoleId(roleId);
        return EmployeeMapper.INSTANCE.toDtoList(entities);
    }
    @Transactional
    public List<EmployeeDto> findByHireDate(LocalDate startDate, LocalDate endDate) {
        List<EmployeeEntity>entities = employeeRepository.findByHireDateBetween(startDate, endDate);
        return EmployeeMapper.INSTANCE.toDtoList(entities);
    }

}
