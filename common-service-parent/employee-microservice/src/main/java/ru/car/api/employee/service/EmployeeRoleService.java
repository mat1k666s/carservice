package ru.car.api.employee.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.car.api.employee.entity.EmployeeRoleEntity;

import ru.car.api.employee.mapper.EmployeeRoleMapper;
import ru.car.api.employee.repository.EmployeeRoleRepository;

import ru.car.employee.dto.EmployeeRoleDto;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeRoleService {
    private final EmployeeRoleRepository employeeRoleRepository;

    @Transactional
    public EmployeeRoleDto getById(Integer id) {
        Optional<EmployeeRoleEntity> entity = employeeRoleRepository.findById(id);
        if (entity.isPresent()) {
            return EmployeeRoleMapper.INSTANCE.toDto(entity.get());
        }
        return null;
    }

    @Transactional
    public EmployeeRoleDto add(EmployeeRoleDto employeeRoleDto) {
        employeeRoleDto.setId(null);
        EmployeeRoleEntity entity = EmployeeRoleMapper.INSTANCE.toEntity(employeeRoleDto);
        entity = employeeRoleRepository.saveAndFlush(entity);
        return EmployeeRoleMapper.INSTANCE.toDto(entity);

    }

    @Transactional
    public EmployeeRoleDto update(EmployeeRoleDto employeeRoleDto) {
        EmployeeRoleEntity entity = EmployeeRoleMapper.INSTANCE.toEntity(employeeRoleDto);
        entity = employeeRoleRepository.saveAndFlush(entity);
        return EmployeeRoleMapper.INSTANCE.toDto(entity);
    }

    @Transactional
    public Integer deleteById(Integer id) {
        employeeRoleRepository.deleteById(id);
        return id;
    }
    @Transactional
    public List<EmployeeRoleDto> findByName(String name) {
        List<EmployeeRoleEntity> entities = employeeRoleRepository.findByName(name);
        return EmployeeRoleMapper.INSTANCE.toDtoList(entities);
    }
    @Transactional
    public List<EmployeeRoleDto>findByCode(String code) {
        List<EmployeeRoleEntity> entities = employeeRoleRepository.findByCode(code);
        return EmployeeRoleMapper.INSTANCE.toDtoList(entities);
    }

}
