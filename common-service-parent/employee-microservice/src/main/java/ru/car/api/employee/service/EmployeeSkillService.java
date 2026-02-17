package ru.car.api.employee.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.car.api.employee.entity.EmployeeEntity;
import ru.car.api.employee.entity.EmployeeSkillEntity;
import ru.car.api.employee.mapper.EmployeeSkillMapper;
import ru.car.api.employee.repository.EmployeeSkillRepository;
import ru.car.employee.dto.EmployeeSkillDto;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeSkillService {
    private final EmployeeSkillRepository employeeSkillRepository;

    @Transactional
    public EmployeeSkillDto getById(Integer id) {
        Optional<EmployeeSkillEntity> entity = employeeSkillRepository.findById(id);
        if (entity.isPresent()) {
            return EmployeeSkillMapper.INSTANCE.toDto(entity.get());
        }
        return null;
    }

    @Transactional
    public EmployeeSkillDto add(EmployeeSkillDto employeeSkillDto) {
        employeeSkillDto.setId(null);
        EmployeeSkillEntity entity = EmployeeSkillMapper.INSTANCE.toEntity(employeeSkillDto);
        entity = employeeSkillRepository.saveAndFlush(entity);
        return EmployeeSkillMapper.INSTANCE.toDto(entity);

    }

    @Transactional
    public EmployeeSkillDto update(EmployeeSkillDto employeeSkillDto) {
        EmployeeSkillEntity entity = EmployeeSkillMapper.INSTANCE.toEntity(employeeSkillDto);
        entity = employeeSkillRepository.saveAndFlush(entity);
        return EmployeeSkillMapper.INSTANCE.toDto(entity);
    }

    @Transactional
    public Integer deleteById(Integer id) {
        employeeSkillRepository.deleteById(id);
        return id;
    }
    @Transactional
    public List<EmployeeSkillDto> findByEmployeeId(EmployeeEntity employeeId) {
        List<EmployeeSkillEntity> entities = employeeSkillRepository.findByEmployeeId(employeeId);
        return EmployeeSkillMapper.INSTANCE.toDtoList(entities);
    }
    @Transactional
    public List<EmployeeSkillDto> findBySkillCode(String skillCode) {
        List<EmployeeSkillEntity> entities = employeeSkillRepository.findBySkillCode(skillCode);
        return EmployeeSkillMapper.INSTANCE.toDtoList(entities);
    }
}
